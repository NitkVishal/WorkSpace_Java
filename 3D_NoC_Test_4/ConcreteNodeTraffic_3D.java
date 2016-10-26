import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Vector;

/**
 * The ConcreteNodeTraffic class extends the functionality of the abstract
 * NodeTraffic class. It defines the traffic configuration of the generated
 * messages of a node and also facilitates the encoding of Header and Data
 * flits.
 * 
 * @version 1.0
 * 
 */
public class ConcreteNodeTraffic_3D extends NodeTraffic_3D {

	public static long LOCAL_IN = 0;

	public static long LOCAL_OUT = 0;

	/**
	 * Constructor of the class. It also invokes constructor of the base
	 * NodeTraffic class.
	 * 
	 * @param address
	 *            address of the node to which this class belongs
	 */
	public ConcreteNodeTraffic_3D(int address) {
		super(address);

	}

	/**
	 * <p>
	 * Generates a packet and sets the next message generation time for the
	 * node.
	 * </p>
	 * 
	 * <p>
	 * moveNodeTrafficFromNodeToSwitch(nCycle) method of Network object calls
	 * the updateOutput(nCycle) method of Node which then checks if actual
	 * parameter nCycle is equal to the state variable nextMessageGenTime of
	 * NodeTraffic objects and if so then that method calls this generateMessage
	 * method.
	 * </p>
	 * 
	 * <p>
	 * The methods performs in the following steps.
	 * <ul>
	 * <li>Gets total number of flits for this packet by exponential
	 * distribution. </li>
	 * <li>Finds out destination node number other than itself in the range of
	 * number of Nodes. The destination node number is then converted to address
	 * format depending on network type. </li>
	 * <li>Generates one header flit and stores information</li>
	 * <li>Generates remaining data flits with random data.</li>
	 * <li>Calls the setNextMsgGenTime to set the next message generation time.
	 * </li>
	 * </ul>
	 * </p>
	 * 
	 * 
	 * @param curCycle
	 *            current simulation cycle
	 * @param curMessageCount
	 *            current message stored in the buffer of the node
	 * @return a Vector data structure containing the whole packet
	 */
	public Vector generateMessage(int curCycle, int curMessageCount) {
		Vector packet = new Vector();
		int vcId = 0; // dummy VC ID is given while Flits are produced from
		// packet;
		int i;

		if (curMessageCount >= IConstants_3D.MAX_MESSAGE_NUMBER) {
			nextMsgGenTime = curCycle + 1;
			return null;
		}
		int noOfFlit = this.getMessageSize();

		int destination = 0;

		destination = this.getDestination();
		packet.add(createHeaderFlit(destination, noOfFlit, vcId, curCycle));

		for (i = 1; i < noOfFlit; i++) {
			packet.add(createDataFlit(vcId, curCycle, destination));
		}
		setNextMsgGenTime(curCycle);

		return packet;
	}

	/**
	 * Updates the state variable nextMessageGenTime of this class (inherited
	 * from NodeTraffic class) by calculating a time from exponential
	 * distribution using the average inter message generation time and adding
	 * this time with curCycle. The method is called by Network Initialization
	 * method and updateOutput() method of Node just after calling
	 * generateMessage().
	 * 
	 * @param curCycle
	 *            current simulation cycle
	 */
	public void setNextMsgGenTime(int curCycle) {

		nextMsgGenTime = (int) (-1 * IConstants_3D.AVG_INTER_ARRIVAL * Math
				.log(NetworkManager_3D.getHelpingUtility().getNextRandomNumber()))
				+ curCycle + 1;

		if (IConstants_3D.TRACE) {
			try {
				RandomAccessFile raf = new RandomAccessFile(
						IConstants_3D.TRACE_FILE, "rw");
				raf.seek(raf.length());
				raf.writeBytes("\nCycle " + curCycle + " Node " + address
						+ " will produce Message at " + nextMsgGenTime);

				raf.close();
			} catch (IOException ioex) {
			}
		}

	}

	/**
	 * Return the nextMsgGenTime (next message generation time) variable of this
	 * class.
	 * 
	 * @return next message generation time
	 */

	protected int getNextMsgGenTime() {

		return this.nextMsgGenTime;
	}

	/**
	 * Returns the address of the destination node. This method calls an
	 * appropriate method for generating address of the destination according to
	 * the network topology.
	 * 
	 * @return address of the destination node
	 */

	protected int getDestination() {

		int destination = 0;

		if (IConstants_3D.CURRENT_NET == IConstants_3D.NET_MESH) {
			destination = generateDestinationForMeshNetwork(address);
		}

		return destination;
	}

	/**
	 * Generates a header flit and return it to message generator method. It
	 * generates the header flit in following fashion.
	 * <ul>
	 * <li> Check if the flit length is sufficient to contain the header flit
	 * info. If not update the flit length to minimum size required to hold the
	 * header info. </li>
	 * <li> Then encode the following information in that order from LSB to MSB.
	 * <ul>
	 * <li> Flit Type (here header flit) � 1 or 2 bits </li>
	 * <li> Virtual channel number � bit length depends on number of virtual
	 * channel per physical channel used in the system. </li>
	 * <li> Calculate number of bits required to encode source and destination
	 * addresses and this number is encoded in 6 bits (changeable). </li>
	 * <li> Source address is then encoded by using calculated number of bits.</li>
	 * <li> Destination address is then encoded by using calculated number of
	 * bits.</li>
	 * <ul>
	 * </li>
	 * </ul>
	 * 
	 * @param destination
	 *            address of the destination node
	 * @param noOfFlit
	 *            no of flits in the packet
	 * @param vcId
	 *            virtual channel no
	 * @param curCycle
	 *            current simulation cycle
	 * @return Header Flit
	 */

	protected Flit_3D createHeaderFlit(int destination, int noOfFlit, int vcId,
			int curCycle) {

		int flitData = 0, bitUsed = 0;
		int noOfInt = 0;
		int data[];
		int minFlitLength = IConstants_3D.FLIT_LENGTH;
		IConstants_3D.NUM_VCID_BITS = (int) Math.ceil(Math
				.log(IConstants_3D.CURRENT_VC_COUNT)
				/ Math.log(2));
		if (IConstants_3D.CURRENT_NET == IConstants_3D.NET_MESH) {
			minFlitLength = IConstants_3D.NUM_FLIT_TYPE_BITS
					+ IConstants_3D.NUM_VCID_BITS + IConstants_3D.NUM_ADDR_BITS
					+ IConstants_3D.NUM_FLITS_BITS + IConstants_3D.MESH_ROW_BITS
					+ IConstants_3D.MESH_COL_BITS + IConstants_3D.MESH_NODE_BITS_REQ
					+ IConstants_3D.MESH_ROW_BITS + IConstants_3D.MESH_COL_BITS
					+ IConstants_3D.MESH_NODE_BITS_REQ;
		} 

		if (minFlitLength % IConstants_3D.INT_SIZE > 0) {
			minFlitLength += IConstants_3D.INT_SIZE
					- (minFlitLength % IConstants_3D.INT_SIZE);
		}
		if (minFlitLength < IConstants_3D.FLIT_LENGTH) {
			minFlitLength = IConstants_3D.FLIT_LENGTH;
		}

		data = new int[minFlitLength / IConstants_3D.INT_SIZE];

		flitData = IConstants_3D.HEADER_FLIT; // 1 bit for flit type
		bitUsed += IConstants_3D.NUM_FLIT_TYPE_BITS;

		flitData = (vcId << bitUsed) | flitData; // IConstants.CURRENT_VC_COUNT
		// bits for VCID
		bitUsed += IConstants_3D.NUM_VCID_BITS;

		int numAddrBits = 30;
		if (IConstants_3D.CURRENT_NET == IConstants_3D.NET_MESH
				) {

			numAddrBits = IConstants_3D.MESH_ROW_BITS + IConstants_3D.MESH_COL_BITS
					+ IConstants_3D.MESH_NODE_BITS_REQ;
		} 

		flitData = (numAddrBits << bitUsed) | flitData; //
		bitUsed += IConstants_3D.NUM_ADDR_BITS; // how many bits required to
		// represent number of bits in
		// address

		if (bitUsed + IConstants_3D.NUM_FLITS_BITS > IConstants_3D.INT_SIZE) {
			int rest = bitUsed + IConstants_3D.NUM_FLITS_BITS
					- IConstants_3D.INT_SIZE;
			int temp = noOfFlit
					% (int) Math.pow(2, IConstants_3D.NUM_FLITS_BITS - rest);

			flitData = (temp << bitUsed) | flitData;
			data[noOfInt++] = flitData;
			flitData = noOfFlit >>> (IConstants_3D.NUM_FLITS_BITS - rest);
			bitUsed = rest;
		} else {
			flitData = (noOfFlit << bitUsed) | flitData;
			bitUsed += IConstants_3D.NUM_FLITS_BITS;
		}

		// source address
		if (bitUsed + numAddrBits > IConstants_3D.INT_SIZE) {
			int rest = bitUsed + numAddrBits - IConstants_3D.INT_SIZE;
			int temp = address % (int) Math.pow(2, numAddrBits - rest);
			flitData = (temp << bitUsed) | flitData;
			data[noOfInt] = flitData;
			noOfInt++;
			flitData = address >>> (numAddrBits - rest);
			bitUsed = rest;
		} else {
			flitData = (address << bitUsed) | flitData;
			bitUsed += numAddrBits;
		}

		// dest address
		if (bitUsed + numAddrBits > IConstants_3D.INT_SIZE) {
			int rest = bitUsed + numAddrBits - IConstants_3D.INT_SIZE;
			int temp = destination % (int) Math.pow(2, numAddrBits - rest);
			flitData = (temp << bitUsed) | flitData;
			data[noOfInt] = flitData;
			noOfInt++;
			flitData = destination >>> (numAddrBits - rest);
			bitUsed = rest;
		} else {
			flitData = (destination << bitUsed) | flitData;
			bitUsed += numAddrBits;
		}
		// rest bits
		data[noOfInt] = flitData;

		Flit_3D header = new Flit_3D(data, curCycle);
		header.setDest(destination);
		header.setSource(this.address);
		/*
		 * System.out.println("Header Flit (" + header.getSourceNode() + "," +
		 * header.getDestinationNode() + ") Length = " +
		 * header.getPacketLength()) ;
		 */

		// System.out.println("Address BITs: "+IConstants.NUM_ADDR_BITS);
		return header;
	}

	/**
	 * Generates a data flit and return it to message generator method. It
	 * generates the data flit in following fashion:
	 * 
	 * <ul>
	 * <li> Calculate the required size of flit in bit. If current size is
	 * smaller than required then current size is updated. </li>
	 * <li> Then encode the following information in that order from LSB to MSB
	 * <ul>
	 * <li> Flit Type (here data flit) � 1 or 2 bits </li>
	 * <li> Virtual channel number � bit length depends on number of virtual
	 * channel per physical channel used in the system. This virtual channel
	 * number acts as trace of packet in the network. </li>
	 * <li> Then the data part for which this transmission process is encoded.
	 * </li>
	 * 
	 * </ul>
	 * </li>
	 * </ul>
	 * 
	 * @param destination
	 *            address of the destination node
	 * @param vcId
	 *            virtual channel no
	 * @param curCycle
	 *            current simulation cycle
	 * @return Data Flit
	 */
	protected Flit_3D createDataFlit(int vcId, int curCycle, int destination) {
		int flitData = 0;
		int bitUsed = 0;
		int minFlitLength = IConstants_3D.FLIT_LENGTH;
		IConstants_3D.NUM_VCID_BITS = (int) Math.ceil(Math
				.log(IConstants_3D.CURRENT_VC_COUNT)
				/ Math.log(2));
		if (IConstants_3D.CURRENT_NET == IConstants_3D.NET_MESH
				) {
			minFlitLength = IConstants_3D.NUM_FLIT_TYPE_BITS
					+ IConstants_3D.NUM_VCID_BITS + IConstants_3D.NUM_ADDR_BITS
					+ IConstants_3D.NUM_FLITS_BITS + IConstants_3D.MESH_ROW_BITS
					+ IConstants_3D.MESH_COL_BITS + IConstants_3D.MESH_NODE_BITS_REQ
					+ IConstants_3D.MESH_ROW_BITS + IConstants_3D.MESH_COL_BITS
					+ IConstants_3D.MESH_NODE_BITS_REQ;
		} 
		if (minFlitLength % IConstants_3D.INT_SIZE > 0) {
			minFlitLength += IConstants_3D.INT_SIZE
					- (minFlitLength % IConstants_3D.INT_SIZE);
		}
		if (minFlitLength < IConstants_3D.FLIT_LENGTH) {
			minFlitLength = IConstants_3D.FLIT_LENGTH;
		}

		int noOfInt = minFlitLength / IConstants_3D.INT_SIZE;
		int data[] = new int[noOfInt];

		flitData = IConstants_3D.DATA_FLIT; // 1 bit for flit type
		bitUsed += IConstants_3D.NUM_FLIT_TYPE_BITS;

		flitData = (vcId << bitUsed) | flitData; // IConstants.CURRENT_VC_COUNT
		// bits for VCID
		bitUsed += IConstants_3D.NUM_VCID_BITS;

		data[0] = flitData; // 0xDDDDDD00 | flitData ;

		for (int i = 1; i < noOfInt; i++) {
			data[i] = Integer.MAX_VALUE - address; // (int)
			// (NetworkManager.getHelpingUtility().getNextRandomNumber()
			// * Integer.MAX_VALUE) ;

		}
		Flit_3D dataFlit = new Flit_3D(data, curCycle);
		dataFlit.setDest(destination);
		dataFlit.setSource(this.address);

		return dataFlit;
	}

	/**
	 * <p>
	 * Returns the message size in flits, which may be either fixed or
	 * exponential random number computed from the average message length(in
	 * bytes) and flit length (in bits).
	 * </p>
	 * 
	 * @return message length in flits
	 */
	protected int getMessageSize() {
		int noOfFlit;

		if (IConstants_3D.FIXED_MESSAGE_LENGTH == false) {
			noOfFlit = (int) (-8
					* IConstants_3D.AVG_MESSAGE_LENGTH
					* Math.log(NetworkManager_3D.getHelpingUtility()
							.getNextRandomNumber()) / IConstants_3D.FLIT_LENGTH);
			noOfFlit = noOfFlit > 1 ? noOfFlit : 2;
		}

		else {
			noOfFlit = 8 * IConstants_3D.AVG_MESSAGE_LENGTH
					/ IConstants_3D.FLIT_LENGTH;
			noOfFlit = noOfFlit > 1 ? noOfFlit : 2;
		}

		System.out.println("min flit: " + noOfFlit);
		return noOfFlit;
		// return 10;
	}

	/**
	 * Returns the address of a destination node in the Mesh network randomly.
	 * This address is encoded in the appropriate format for the Mesh network
	 * and it is computed in the following manner:
	 * 
	 * <ul>
	 * <li>Gets the destination node number randomly.</li>
	 * <li>?Calculates the row of this node.
	 * <p>
	 * row = (destination/(C*N)). <br>
	 * Here C = Number of Columns in the Mesh Network, and N = Number of IP
	 * nodes per Switch.
	 * </p>
	 * </li>
	 * <li>Calculates the column of this node.
	 * <p>
	 * column = ((destination mod (C*N)) / N)
	 * </p>
	 * </li>
	 * <li>?Calculates its position, pos, in the switch.
	 * <p>
	 * (pos = destination mod N)
	 * </p>
	 * </li>
	 * <li>Finally the address of the destination node is encoded.
	 * <p>
	 * address = row * 2 ^ (bitC + bitN) + col * bitN + pos
	 * </p>
	 * <p>
	 * bitC = Number of bits used in representing column number the Mesh
	 * Network.<br>
	 * bitN = Number of bits used in representing node number of the Mesh Switch
	 * in Network.
	 * </p>
	 * 
	 * </li>
	 * </ul>
	 * 
	 * @param address
	 *            address of the source node
	 * @return address of a destination node (mesh network)
	 */

	private int generateDestinationForMeshNetwork(int address) {
		int destination = address;
		int tempRow = 0, tempCol = 0, tempNode = 0;
		if (IConstants_3D.TRAFFIC_TYPE == IConstants_3D.TRAFFIC_UNIFORM) {
			destination = address;
			while (destination == address) {
				destination = (int) (NetworkManager_3D.getHelpingUtility()
						.getNextRandomNumber() * IConstants_3D.NUMBER_OF_IP_NODE);
				tempRow = destination
						/ (IConstants_3D.MESH_COL * IConstants_3D.MESH_ADJ_NODE);
				tempCol = (destination % (IConstants_3D.MESH_COL * IConstants_3D.MESH_ADJ_NODE))
						/ IConstants_3D.MESH_ADJ_NODE;
				tempNode = destination % IConstants_3D.MESH_ADJ_NODE;
				destination = (tempRow << (IConstants_3D.MESH_COL_BITS + IConstants_3D.MESH_NODE_BITS_REQ))
						+ (tempCol << IConstants_3D.MESH_NODE_BITS_REQ) + tempNode;
			}

			return destination;
		} else if (IConstants_3D.TRAFFIC_TYPE == IConstants_3D.TRAFFIC_LOCAL) {
			return -1;
		}
		return -1;
	}

	/**
	 * Returns the address of a destination node in the Torus network randomly.
	 * This address is encoded in the appropriate format for the Torus network
	 * and it is computed in the following manner:
	 * 
	 * <ul>
	 * <li>Gets the destination node number randomly.</li>
	 * <li>?Calculates the row of this node.
	 * <p>
	 * row = (destination/(C*N)). <br>
	 * Here C = Number of Columns in the Torus Network, and N = Number of IP
	 * nodes per Switch.
	 * </p>
	 * </li>
	 * <li>Calculates the column of this node.
	 * <p>
	 * column = ((destination mod (C*N)) / N)
	 * </p>
	 * </li>
	 * <li>?Calculates its position, pos, in the switch.
	 * <p>
	 * (pos = destination mod N)
	 * </p>
	 * </li>
	 * <li>Finally the address of the destination node is encoded.
	 * <p>
	 * address = row * 2 ^ (bitC + bitN) + col * bitN + pos
	 * </p>
	 * <p>
	 * bitC = Number of bits used in representing column number the Torus
	 * Network.<br>
	 * bitN = Number of bits used in representing node number of the Torus
	 * Switch in Network.
	 * </p>
	 * 
	 * </li>
	 * </ul>
	 * 
	 * @param address
	 *            address of the source node
	 * @return address of a destination node (Torus network)
	 */
	private int generateDestinationForTorusNetwork(int address) {
		int destination = address;
		int tempRow = 0, tempCol = 0, tempNode = 0;
		if (IConstants_3D.TRAFFIC_TYPE == IConstants_3D.TRAFFIC_UNIFORM) {
			destination = address;
			while (destination == address) {
				destination = (int) (NetworkManager_3D.getHelpingUtility()
						.getNextRandomNumber() * IConstants_3D.NUMBER_OF_IP_NODE);
				tempRow = destination
						/ (IConstants_3D.MESH_COL * IConstants_3D.MESH_ADJ_NODE);
				tempCol = (destination % (IConstants_3D.MESH_COL * IConstants_3D.MESH_ADJ_NODE))
						/ IConstants_3D.MESH_ADJ_NODE;
				tempNode = destination % IConstants_3D.MESH_ADJ_NODE;
				destination = (tempRow << (IConstants_3D.MESH_COL_BITS + IConstants_3D.MESH_NODE_BITS_REQ))
						+ (tempCol << IConstants_3D.MESH_NODE_BITS_REQ) + tempNode;
			}

			return destination;
		} else if (IConstants_3D.TRAFFIC_TYPE == IConstants_3D.TRAFFIC_LOCAL) {
			return -1;
		}
		return -1;
	}

	/**
	 * Returns the address of a destination node in the fat tree network
	 * randomly.
	 * 
	 * @param address
	 *            address of the source node
	 * @return address of a destination node (fat tree network)
	 */


	
}
