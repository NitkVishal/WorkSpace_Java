import java.util.*;

/**
 * Network is the object through which all the nodes (Resource blocks) and all
 * the communication switches are connected to perform the desired goal into one
 * unit. According to the input parameters the network is built up. Different
 * types of network topologies can be created but for simulation at a time only
 * one type of network is instantiated. Mesh, Torus, Butterfly Fat Tree and
 * Extended Butterfly Fat Tree, Octal are among the different types of network.
 * 
 * N.B. Extended Butterfly Fat Tree (an extension of the Butterfly Fat Tree) and
 * Octal (an extension of the Octagon topology) are two architectures originally
 * proposed by the researchers in Dept. of CSE, BUET)
 * 
 * @version 1.0
 * 
 */

public class Network {
	/**
	 * A vector type variable holding the reference of all the resource nodes of
	 * the network. This list is used for retrieving nodes� reference to invoke
	 * methods directly from network.
	 */
	private Vector nodeList;

	/**
	 * A vector type variable holding the reference of all the communication
	 * switches of the network. This list is used for retrieving switches�
	 * reference to invoke methods directly from network.
	 */
	private Vector switchList;

	/**
	 * Constructor of the Network. In this version of the simulator, the type of
	 * the networks that have been implemented are Mesh, Torus, Butterfly Fat
	 * Tree, Extended Butterfly Fat Tree, and Octal. The constructor performs in
	 * the following fashion.
	 * <ul>
	 * <li>Creates nodeList and switchList vector object.</li>
	 * <li>Checks the type of the network to build.</li>
	 * <li>The network of specified type is created along with creation of
	 * adjacency relationship with other switches for all the switches.</li>
	 * </ul>
	 * 
	 * @param networkType
	 *            An integer which determines which type of network the
	 *            constructor will build.
	 * 
	 * @see IConstants
	 */
	public Network(int networkType) {
		nodeList = new Vector();
		switchList = new Vector();
		
		
		createMeshNetwork();
		setAdjacentMeshSwitch();
}

	/**
	 * Instantiates all the nodes and mesh switches of the mesh network as well
	 * as assigns which node will be connected with which mesh switch. The
	 * method performs in the following manner.
	 * 
	 * <ul>
	 * <li>Determines how many adjacent nodes per switch.</li>
	 * <li>Determines the number of switches required in the network.</li>
	 * <li>Calculates required number of mesh rows and columns with a target of
	 * number of rows and columns being equal (if not possible then number of
	 * columns being the higher).</li>
	 * <li>Calculates the number of bits required to encode row number and
	 * column number of a switch to form the address of a switch.</li>
	 * <li>Instantiate all the switch by assigning them corresponding address
	 * generated from row and column.</li>
	 * <li>For every instantiated switch instantiate the required number of
	 * adjacent nodes.</li>
	 * </ul>
	 * 
	 * <p>
	 * Assumptions:
	 * <li>This method considers a topology that has either m*n Mesh Switches.
	 * Here n = m or m+1. </li>
	 * <li>This method also works for the Torus network. </li>
	 * <li>The Number of IP Nodes and Switches adjusted according to the n * m
	 * switch architecture. Where, n = m or m+1, i.e. the architecture is
	 * adjusted to have a square shape.</li>
	 * </p>
	 * 
	 * @see MeshSwitch
	 * @see NetworkManager
	 * @see IConstants
	 */
	public void createMeshNetwork() {
		int i, address, numSwitch, row, col, noOfAdjNode;
		double factor;
		MeshSwitch meshSwitch;
		Node nd;

		noOfAdjNode = IConstants.MESH_ADJ_NODE;
		numSwitch = IConstants.NUMBER_OF_IP_NODE / noOfAdjNode;

		/* Check the assumptions in the documentation of this method. */
		IConstants.MESH_ROW = (int) Math.floor(Math.sqrt(numSwitch));
		IConstants.MESH_COL = (int) Math.ceil(Math.sqrt(numSwitch));
		IConstants.MESH_NODE_BITS_REQ = (int) Math.ceil(Math
				.log(IConstants.MESH_ADJ_NODE)
				/ Math.log(2));
		IConstants.CURRENT_LINK_COUNT = IConstants.MESH_ADJ_NODE + 4;
		IConstants.MESH_ROW_BITS = (int) Math.ceil(Math
				.log(IConstants.MESH_ROW)
				/ Math.log(2));
		IConstants.MESH_COL_BITS = (int) Math.ceil(Math
				.log(IConstants.MESH_COL)
				/ Math.log(2));

		/*
		 * Readjusted Number of IP Nodes and Number of Switches .. Only n * m
		 * swithces are possible.. where n = m or m+1
		 */
		IConstants.NUMBER_OF_SWITCH = IConstants.MESH_ROW * IConstants.MESH_COL;
		IConstants.NUMBER_OF_IP_NODE = IConstants.NUMBER_OF_SWITCH
				* noOfAdjNode;

		// Creates the Mesh Switches
		for (i = 0; i < IConstants.NUMBER_OF_SWITCH; i++) {
			row = i / IConstants.MESH_COL;
			col = i % IConstants.MESH_COL;
			//address = (row << IConstants.MESH_COL_BITS) + col;
			address =i;
			//System.out.println("Add Of"+ i+"="+  address);
			
			meshSwitch = new MeshSwitch(IConstants.CURRENT_LINK_COUNT,
					IConstants.CURRENT_VC_COUNT, address, noOfAdjNode,
					IConstants.CURRENT_ADJ_SWITCH, i);
			switchList.add(meshSwitch);

			// add IP Nodes to the Mesh Switch
			//address = address << IConstants.MESH_NODE_BITS_REQ;
			
			//System.out.println("Add Of"+ i+"="+  address);
			for (int k = 0; k < noOfAdjNode; k++) {
				factor = NetworkManager.getHelpingUtility()
						.getNextRandomNumber();
				factor = factor * 5 + 4;
				int intVal = (int) factor;
				factor = (double) intVal / 10;

				if (IConstants.ASYNCHRONOUS)
					nd = new Node(address + k, meshSwitch, k,
							IConstants.CURRENT_VC_COUNT, factor);
				else
					nd = new Node(address + k, meshSwitch, k,
							IConstants.CURRENT_VC_COUNT, 1.0);
				meshSwitch.setAdjacentNode(nd, k);
				nodeList.add(nd);
			}
		}

		// assign index to nodes for statistical purpose
		for (i = 0; i < IConstants.NUMBER_OF_IP_NODE; i++) {
			((Node) nodeList.get(i)).setNodeListIndex(i);
		}
	}

	/**
	 * Completes the creation of mesh network by setting the adjacency
	 * relationship between the switches of consecutive different rows and
	 * columns. The switches are added in the network in row major order i.e.
	 * first the earlier rows are filled. The method works in the following
	 * steps.
	 * 
	 * <ul>
	 * <li>For every switch determine its row and column index.</li>
	 * <li>Calculates minimum number of switches required in the network to
	 * have an adjacent switch in the bottom direction for this switch.</li>
	 * <li>Calculates minimum number of switches required in the network to
	 * have an adjacent switch in the right direction for this switch.</li>
	 * <li>If row index of this switch is greater than zero then this switch
	 * will have adjacent switch in top direction. If it has adjacent switch in
	 * top direction then that is found out (just one row earlier and same
	 * column) and corresponding adjacency field is updated for each switch. And
	 * then input/output link controllers for top direction are added.</li>
	 * <li>If row index of this switch is less than the maximum number of rows
	 * in the mesh network and the network has sufficient number of switches to
	 * have an adjacent switch in bottom direction then the switch in bottom
	 * direction is found out (just one row below and same column). The
	 * adjacency fields are updated for both these switches along with adding
	 * input/output link controller for bottom direction.</li>
	 * <li>In the similar way left and right adjacent switches are found out by
	 * using column index value of the switch and corresponding adjacency
	 * information are updates.</li>
	 * </ul>
	 * 
	 * 
	 * @see MeshSwitch
	 * @see InputLinkController
	 * @see OutputLinkController
	 * @see IConstants
	 */
	private void setAdjacentMeshSwitch() {
		MeshSwitch meshSwitch;
		int noOfAdjNode;
		int i, row, col, minSwitchBottomReq, minSwitchRightReq;

		int maxRow = IConstants.MESH_ROW - 1;
		int maxCol = IConstants.MESH_COL - 1;

		// int numSwitch = IConstants.NUMBER_OF_IP_NODE /
		// IConstants.MESH_ADJ_NODE ;
		int numSwitch = IConstants.NUMBER_OF_SWITCH;

		for (i = 0; i < numSwitch; i++) {
			row = i / IConstants.MESH_COL;
			col = i % IConstants.MESH_COL;
			meshSwitch = (MeshSwitch) (switchList.get(i));
			noOfAdjNode = IConstants.MESH_ADJ_NODE;
			minSwitchBottomReq = ((row + 1) * IConstants.MESH_COL) + col + 1;
			minSwitchRightReq = row * IConstants.MESH_COL + col + 1 + 1;

			if (row > 0) {
				// top
				meshSwitch.setAdjacentSwitch((MeshSwitch) switchList
						.get(((row - 1) * IConstants.MESH_COL) + col),
						IConstants.SWITCH_TOP);
			} else {
				meshSwitch.setInputLinkController(IConstants.SWITCH_TOP
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants.SWITCH_TOP
						+ noOfAdjNode, null);
			}
			if (row < maxRow && numSwitch >= minSwitchBottomReq) {
				// bottom
				meshSwitch.setAdjacentSwitch((MeshSwitch) switchList
						.get(((row + 1) * IConstants.MESH_COL) + col),
						IConstants.SWITCH_BOTTOM);
			} else {
				meshSwitch.setInputLinkController(IConstants.SWITCH_BOTTOM
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants.SWITCH_BOTTOM
						+ noOfAdjNode, null);
			}

			if (col > 0) {
				// left
				meshSwitch.setAdjacentSwitch((MeshSwitch) switchList
						.get((row * IConstants.MESH_COL) + (col - 1)),
						IConstants.SWITCH_LEFT);
			} else {
				meshSwitch.setInputLinkController(IConstants.SWITCH_LEFT
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants.SWITCH_LEFT
						+ noOfAdjNode, null);
			}

			if (col < maxCol && numSwitch >= minSwitchRightReq) {
				// right
				meshSwitch.setAdjacentSwitch((MeshSwitch) switchList
						.get((row * IConstants.MESH_COL) + (col + 1)),
						IConstants.SWITCH_RIGHT);
			} else {
				meshSwitch.setInputLinkController(IConstants.SWITCH_RIGHT
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants.SWITCH_RIGHT
						+ noOfAdjNode, null);
			}
		}
	}



	/**
	 * Invoked by Network.setAdjacentFatSwitch() and
	 * Network.setAdjacentExFatSwitch() to find out the first parent switch
	 * exists in the upper level by using current switch�s level and index in
	 * level values.
	 * 
	 * @param level
	 *            Level in the Butterfly Fat Tree, Extended Butterfly Fat Tree
	 *            topology
	 * @return Index value in the switch list
	 * 
	 * @see Network#setAdjacentFatSwitch()
	 * @see Network#setAdjacentExFatSwitch()
	 */
	private int getStartOfLevel(int level) {
		int i, count = 0;
		for (i = 1; i < level; i++)
			count += IConstants.NUMBER_OF_IP_NODE / (1 << (i + 1));
		return count;
	}

	/**
	 * This method is called by the controller of the simulator to set initial
	 * events required for starting the simulator. The method performs in the
	 * following steps.
	 * 
	 * <ul>
	 * <li>For all resource nodes set next message generation timestamps</li>
	 * <li>Resets all the switches and switching info vector of the switches.</li>
	 * <li>Resets the statistical data calculator. </li>
	 * <ul>
	 * 
	 */
	public void setInitalEvents() {
		int i;
		Switch nocSwitch;
		for (i = 0; i < nodeList.size(); i++) {
			Node node = (Node) nodeList.get(i);
			node.nodeTraffic.setNextMsgGenTime(0);
		}

		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			nocSwitch.resetSwitchingInfoVector();
		}

		// track no of link active in each Switch. For statistical purpose
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			NetworkManager.getStatDataInstance().setSwitchNumLink(i,
					nocSwitch.getNumLinkActive());
		}

	}

	/**
	 * This method is used to transfer the outgoing flits at the output buffer
	 * of resource node to the input buffer of the parent switch of that node.
	 * The method performs its duty by calling nodes� updateOutput(nCycle)
	 * method for every simulation cycle.
	 * 
	 * @param nCycle
	 *            Simulation cycle
	 */

	public void moveNodeTrafficFromNodeToSwitch(int nCycle) {
		int i;
		Node node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node) nodeList.get(i);
			node.updateOutput(nCycle);
		}
	}

	public void updateSwitchTrafficPathRequest(int nCycle) {
		int i;
		Switch nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			nocSwitch.updateSwitchOutPathRequest(nCycle);
		}
	}

	/**
	 * This method is used to transfer the incoming flits at the input buffer of
	 * the switch to output buffer of that switch depending on the switching
	 * info vector. The method performs its duty by calling switches�
	 * moveInputBufferToOutputBuffer(nCycle) method for every simulation cycle.
	 * 
	 * @param nCycle
	 *            Simulation cycle
	 */

	public void moveSwitchTrafficFromInputBufferToOutputBuffer(int nCycle) {
		int i;
		Switch nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			nocSwitch.moveInputBufferToOutputBuffer(nCycle);
		}
	}

	/**
	 * This method is used to transfer the outgoing flits at the output buffer
	 * of the switch to input buffer of the adjacent switches and/or resource
	 * nodes. The method performs its assigned activities by calling the
	 * switches� moveSwitchOutputBufferToInputBufferOfNodeSwitch(nCycle) method
	 * for every simulation cycle.
	 * 
	 * @param nCycle
	 *            Simulation cycle
	 */
	public void moveSwitchTrafficFromOutputBufferToInputBufferOfNodeSwitch(
			int nCycle) {
		int i;
		Switch nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			nocSwitch.moveSwitchOutputBufferToInputBufferOfNodeSwitch(nCycle);
		}
	}

	/**
	 * This method is used to transfer the incoming flits at the input buffer of
	 * resource node to the message center of that node. The method performs its
	 * duty by calling nodes� forwardFlitToNodeMessageCenter(nCycle) method for
	 * every simulation cycle
	 * 
	 * @param nCycle
	 *            Simulation cycle
	 */
	public void moveNodeTrafficFromInputBufferToNodeMsgCenter(int nCycle) {
		int i;
		Node node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node) nodeList.get(i);
			node.forwardFlitToNodeMessageCenter(nCycle);
		}
	}

	/**
	 * The method performs its duty by calling nodes�
	 * updateStatusAfterCycle(nCycle) and switches'
	 * updateStatusAfterCycle(nCycle) method for every simulation cycle.
	 * 
	 * @param curCycle
	 *            Simulation cycle
	 */

	public void updateAfterCycleStatus(int curCycle) {
		int i;
		Switch nocSwitch;
		Node node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node) nodeList.get(i);
			node.updateStatusAfterCycle(curCycle);
		}
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch) switchList.get(i);
			nocSwitch.updateStatusAfterCycle(curCycle);
		}
	}

}