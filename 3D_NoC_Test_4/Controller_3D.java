import java.io.*;

/**
 * The Controller class dictates the total flow of execution of the simulator.
 * 
 * @version 1.0
 */
public class Controller_3D {

	/**
	 * This is an object of
	 * 
	 * {@link NetworkManager_3D} type which holds the current network instance,
	 * statistical data holder and various helping utility object like input
	 * file reader.
	 */
	private NetworkManager_3D netManager = null;

	/**
	 * This is the reference of the instaniated
	 * 
	 * {@link Network} in {@link NetworkManager_3D}. It is used to invoke various
	 * methods of the network.
	 */
	private Network_3D network = null;

	/**
	 * Default Constructor
	 */
	public Controller_3D() {
	}

	/*
	 * private void initialize (int netType) { network =
	 * NetworkManager.getNetworkInstance() ; network.setInitalEvents() ; }
	 */

	// main loop
	/**
	 * The controller object performs its duty mainly by this method. The method
	 * performs in the following steps.
	 * 
	 * <ul>
	 * <li>i. Gets the network manager object by invoking the static
	 * getInstance() method of the NetworkManager class.</li>
	 * <li>ii. Determines if there is any other network configuration in the
	 * input file for simulation through network manager. If there exists one
	 * then create that network and perform the subsequent steps otherwise
	 * terminate the simulation process.</li>
	 * <li>iii. For every simulation run of the same network (simulation is
	 * performed several times, let 10 times, for same network configuration to
	 * get actual statistical scenario) performs the following operations.
	 * <ul>
	 * <li>?Initializes the network.</li>
	 * <li>?Sets random seed for various random data.</li>
	 * <li>Initializes the statistical data object.</li>
	 * <li>Sets initial events of the network</li>
	 * <li>?For every simulation cycle (one simulation run is complete after
	 * huge number of cycles, let 10 million, found from input file) performs
	 * the following operations.
	 * <ul>
	 * <li>Moves outgoing traffic those can be moved from every node to
	 * adjacent switches.</li>
	 * <li>Updates path requests of the incoming traffic of the switches.</li>
	 * <li>Moves incoming traffics those can be moved from input buffer to
	 * output buffer of the switches.</li>
	 * <li>Moves outgoing traffics those can be moved from output buffer of the
	 * switch to the input buffer of the adjacent switches and/or switches</li>
	 * <li>Moves incoming traffic those can be moved from the input buffer of
	 * the resource node to the message center of that node.</li>
	 * <li>Performs any clerical job required (change of various status and
	 * flags) to do at the end of the cycle</li>
	 * </ul>
	 * </li>
	 * <li>Updates the statistical parameter for this simulation run.</li>
	 * </ul>
	 * </li>
	 * <li>iv. Calculates the average of the statistical parameters found in
	 * the various simulation runs for the same network configuration. And then
	 * writes the various values of the statistical parameters and network
	 * configuration in the output file.</li>
	 * </ul>
	 */
	public void main_loop() {
		int i, run;
		boolean toGo;
		double nodeThroughput, throughput, avgDelay, avgPktNotProduced, linkUtil, packetRate;
		double inBufUtilNode, outBufUtilNode, inBufUtilSwitch, outBufUtilSwitch, totalBufUtil;
		double packetHopCount;
		double packetSent, packetReceived;

		netManager = NetworkManager_3D.getInstance(IConstants_3D.PARAM_FILE);
		toGo = netManager.createNextNetwork();

		System.out.println("ToGo: " + toGo);
		while (toGo) {
			if (IConstants_3D.TRACE) {
				try {
					RandomAccessFile raf = new RandomAccessFile(
							IConstants_3D.TRACE_FILE, "rw");
					raf.seek(raf.length());
					raf
							.writeBytes("\n\n\nStarting Trace Info for the Network\n\n");
					String str = "";
					str += "  Network\t" + IConstants_3D.CURRENT_NET;
					str += "\n  Number of IP\t" + IConstants_3D.NUMBER_OF_IP_NODE;
					str += "\n  Avg Msg Length(bytes)\t"
							+ IConstants_3D.AVG_MESSAGE_LENGTH;
					str += "\n  Flit Length(bits)\t" + IConstants_3D.FLIT_LENGTH;
					str += "\n  Avg Msg Production Rate(cycle/msg)\t"
							+ IConstants_3D.AVG_INTER_ARRIVAL;
					str += "\n  Number of Virtual Channel/Link\t"
							+ IConstants_3D.CURRENT_VC_COUNT;
					str += "\n  Number of Flit/Buffer\t"
							+ IConstants_3D.NUM_FLIT_PER_BUFFER;
					str += "\n  Number of Cycles\t" + IConstants_3D.NUM_CYCLE;
					raf.writeBytes(str + "\n\n");
					raf.close();
				} catch (IOException ioex) {
				}
			}

			NetworkManager_3D.getHelpingUtility().setRandomSeed();

			// //////////////////////////////////////////////////////////////////
			// Initialization of the performance parameters for each network ///
			// //////////////////////////////////////////////////////////////////

			nodeThroughput = throughput = avgDelay = avgPktNotProduced = linkUtil = packetRate = 0;
			inBufUtilNode = outBufUtilNode = inBufUtilSwitch = outBufUtilSwitch = totalBufUtil = 0;
			packetHopCount = 0;
			packetSent = packetReceived = 0;

			for (run = 0; run < IConstants_3D.NUM_RUN; run++) {
				if (IConstants_3D.TRACE) {
					try {
						RandomAccessFile raf = new RandomAccessFile(
								IConstants_3D.TRACE_FILE, "rw");
						raf.seek(raf.length());
						raf.writeBytes("\n\n  For run=" + run + "\n");
						raf.close();
					} catch (IOException ioex) {
					}
				}

				// ///////////////////////////////////////////////////////////
				// Initialization at every run ///
				// ///////////////////////////////////////////////////////////
				NetworkManager_3D.getInstance().initializeNetwork();
				network = NetworkManager_3D.getNetworkInstance();
				NetworkManager_3D.getHelpingUtility().setRandomSeed();
				NetworkManager_3D.getStatDataInstance().initializeStat();
				network.setInitalEvents();
				for (i = 0; i < IConstants_3D.NUM_CYCLE + IConstants_3D.WARM_UP_CYCLE; i++) {
					// ///////////////////////////////////////////////////////////
					// Operations at each cycle ///
					// ///////////////////////////////////////////////////////////
					network.moveNodeTrafficFromNodeToSwitch(i);
					network.updateSwitchTrafficPathRequest(i);
					network.moveSwitchTrafficFromInputBufferToOutputBuffer(i);
					network
							.moveSwitchTrafficFromOutputBufferToInputBufferOfNodeSwitch(i);
					network.moveNodeTrafficFromInputBufferToNodeMsgCenter(i);
					network.updateAfterCycleStatus(i);
				}

				// ///////////////////////////////////////////////////////////
				// Updates the performance parameters after each run ///
				// ///////////////////////////////////////////////////////////

				nodeThroughput += NetworkManager_3D.getStatDataInstance()
						.getNetworkNodeThroughput();
				throughput += NetworkManager_3D.getStatDataInstance()
						.getThroughput(IConstants_3D.NUM_CYCLE);
				avgDelay += NetworkManager_3D.getStatDataInstance()
						.getAvgPacketDelay();
				avgPktNotProduced += NetworkManager_3D.getStatDataInstance()
						.getAvgMessageNotProduced();
				linkUtil += NetworkManager_3D.getStatDataInstance()
						.getLinkUtilization();
				packetRate += (double) NetworkManager_3D.getStatDataInstance()
						.getNumberOfPacketProduced()
						/ IConstants_3D.NUM_CYCLE;

				packetHopCount += NetworkManager_3D.getStatDataInstance()
						.getAvgPacketHopCount();

				inBufUtilNode += NetworkManager_3D.getStatDataInstance()
						.getInputBufferNodeUtilization();
				outBufUtilNode += NetworkManager_3D.getStatDataInstance()
						.getOutputBufferNodeUtilization();
				inBufUtilSwitch += NetworkManager_3D.getStatDataInstance()
						.getInputBufferSwitchUtilization();
				outBufUtilSwitch += NetworkManager_3D.getStatDataInstance()
						.getOutputBufferSwitchUtilization();
				totalBufUtil += NetworkManager_3D.getStatDataInstance()
						.getBufferUtilization();

				packetSent += NetworkManager_3D.getStatDataInstance()
						.getNumberOfPacketSent();
				packetReceived += NetworkManager_3D.getStatDataInstance()
						.getNumberOfPacketReceived();
			}

			// ///////////////////////////////////////////////////////////////////////////////////////////////
			// Calculates the average of the statistical parameters found in the
			// various simulation runs for//
			// the same network configuration. //
			// ///////////////////////////////////////////////////////////////////////////////////////////////
			nodeThroughput /= run;
			throughput /= run;
			avgDelay /= run;
			avgPktNotProduced /= run;
			linkUtil /= run;
			packetRate /= run;

			inBufUtilNode /= run;
			outBufUtilNode /= run;
			inBufUtilSwitch /= run;
			outBufUtilSwitch /= run;
			totalBufUtil /= run;

			packetHopCount /= run;
			packetSent /= run;
			packetReceived /= run;

			try {
				// ///////////////////////////////////////////////////////////////////////////////////////////////////////
				// Writes the various values of the statistical parameters and
				// network configuration in the output file.//
				// ///////////////////////////////////////////////////////////////////////////////////////////////////////

				String Str = new String("");

				Str += "Input Configuration: ......\n";

				Str += "  Network\t" + IConstants_3D.CURRENT_NET + "\n";
				if (IConstants_3D.ASYNCHRONOUS)
					Str += "  Asynchronous Flow\n";
				else
					Str += "  Synchronous Flow\n";

				Str += "  Number of IP\t" + IConstants_3D.NUMBER_OF_IP_NODE + "\n";
				Str += "  Fixed Message Length\t"
						+ IConstants_3D.FIXED_MESSAGE_LENGTH + "\n";
				Str += "  Avg Msg Length(bytes)\t"
						+ IConstants_3D.AVG_MESSAGE_LENGTH + "\n";
				Str += "  Flit Length(bits)\t" + IConstants_3D.FLIT_LENGTH + "\n";
				Str += "  Avg Msg Production Rate(cycle/msg)\t"
						+ IConstants_3D.AVG_INTER_ARRIVAL + "\n";
				Str += "  Number of Virtual Channel/Link\t"
						+ IConstants_3D.CURRENT_VC_COUNT + "\n";
				Str += "  Number of Flit/Buffer\t"
						+ IConstants_3D.NUM_FLIT_PER_BUFFER + "\n";
				Str += "  Number of Cycles\t" + IConstants_3D.NUM_CYCLE + "\n";
				Str += "  Number of Warm_Up_Cycles\t"
						+ IConstants_3D.WARM_UP_CYCLE + "\n";
				Str += "  Traffic Type\t" + IConstants_3D.TRAFFIC_TYPE + "\n";

				Str += " .....................\n";
				Str += "Performance Measurements.......";

				Str += "\n  Throughput[Net]" + nodeThroughput;
				Str += "\n  Throughput[Flits leaving Switch]\t" + throughput;
				Str += "\n  Avg Packet Delay\t" + avgDelay;
				Str += "\n  Link Utilization\t" + linkUtil;
				Str += "\n  Buffer(Node & Switch) Utilization\t" + totalBufUtil;
				Str += "\n  Avg Packet Injection Rate\t" + packetRate;
				Str += "\n  Avg Packet Not Produced\t" + avgPktNotProduced;
				Str += "\n  Input Buffer(Node) Utilization\t" + inBufUtilNode;
				Str += "\n  Input Buffer(Switch) Utilization\t"
						+ inBufUtilSwitch;
				Str += "\n  Output Buffer(Node) Utilization\t" + outBufUtilNode;
				Str += "\n  Output Buffer(Switch) Utilization\t"
						+ outBufUtilSwitch;
				Str += "\n  Avg Hop Count\t" + packetHopCount;
				Str += "\n  Avg Packet Sent/Run\t" + packetSent;
				Str += "\n  Avg Packet Received/Run\t" + packetReceived;
				Str += "\n\n\n";

				Str += "\n  Total LOCA_IN = " + ConcreteNodeTraffic_3D.LOCAL_IN;
				Str += "\n  Total LOCA_OUT = " + ConcreteNodeTraffic_3D.LOCAL_OUT;
				Str += "\n  Total LOCA_IN Percentage = "
						+ ConcreteNodeTraffic_3D.LOCAL_IN
						/ (ConcreteNodeTraffic_3D.LOCAL_IN + (double) ConcreteNodeTraffic_3D.LOCAL_OUT);
				Str += "\n\n\n";

				RandomAccessFile raf = new RandomAccessFile(
						IConstants_3D.OUT_FILE, "rw");
				raf.seek(raf.length());
				raf.writeBytes(Str);
				raf.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			toGo = netManager.createNextNetwork();
		}

		System.out.println("Simulation Complete");
	}

}