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

public class Network_3D {
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
	 * @see IConstants_3D
	 */
	
	public Network_3D(int networkType) {
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
	 * <li>Calculates required number of mesh x_axiss and y_axisumns with a target of
	 * number of x_axiss and y_axisumns being equal (if not possible then number of
	 * y_axisumns being the higher).</li>
	 * <li>Calculates the number of bits required to encode x_axis number and
	 * y_axisumn number of a switch to form the address of a switch.</li>
	 * <li>Instantiate all the switch by assigning them corresponding address
	 * generated from x_axis and y_axisumn.</li>
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
	 * @see MeshSwitch_3D
	 * @see NetworkManager_3D
	 * @see IConstants_3D
	 */
	
	
	/*public static void main(String args[]){
		int x,y,z,add;
		for(int i=0;i<IConstants_3D.NUMBER_OF_SWITCH;i++)
		{
			x=(i/8)%8;
			y=i%8;
			z=i/64;
			add=((x<<3)+y)<<3+z;
		System.out.println("Add of "+i+ " "+add+"\n");
	}
		}*/
	
	
	public void createMeshNetwork() {
		int i, address,x_axis, y_axis, z_axis, noOfAdjNode;
		double factor;
		MeshSwitch_3D meshSwitch;
		Node_3D nd;

		noOfAdjNode = IConstants_3D.MESH_ADJ_NODE;
		
		IConstants_3D.MESH_ROW = (int) Math.floor(Math.sqrt(64));
		
		IConstants_3D.MESH_COL = (int) Math.ceil(Math.sqrt(64));
		IConstants_3D.MESH_NODE_BITS_REQ = (int) Math.ceil(Math
				.log(IConstants_3D.MESH_ADJ_NODE)
				/ Math.log(2));
		IConstants_3D.CURRENT_LINK_COUNT = IConstants_3D.MESH_ADJ_NODE + 6;
		IConstants_3D.MESH_ROW_BITS = (int) Math.ceil(Math
				.log(IConstants_3D.MESH_ROW)
				/ Math.log(2));
		IConstants_3D.Z_AXIS_BITS=(int)Math.ceil(Math
				.log(IConstants_3D.NUMBER_OF_SWITCH/64)/Math.log(2));
		IConstants_3D.MESH_COL_BITS = (int) Math.ceil(Math
				.log(IConstants_3D.MESH_COL)
				/ Math.log(2));
		
		
		
		IConstants_3D.NUMBER_OF_SWITCH=IConstants_3D.NUMBER_OF_IP_NODE;
			
		
		

		// Creates the Mesh Switches
		for (i = 0; i < IConstants_3D.NUMBER_OF_SWITCH; i++) {
			x_axis = (i / 8)%8;
			y_axis = i % 8;
			z_axis = i / 64;
			//address = (x_axis << IConstants_3D.MESH_COL_BITS) + y_axis;
			address =i;
			meshSwitch = new MeshSwitch_3D(IConstants_3D.CURRENT_LINK_COUNT,
					IConstants_3D.CURRENT_VC_COUNT, address, noOfAdjNode,
					IConstants_3D.CURRENT_ADJ_SWITCH, i);
			switchList.add(meshSwitch);
             //System.out.println("Address Of Switch  :"+meshSwitch.getAddress());
			// add IP Nodes to the Mesh Switch
			address = address << IConstants_3D.MESH_NODE_BITS_REQ;
			
			 //System.out.println("Address Of Node  :"+""+i+"=="+address);
			for (int k = 0; k < noOfAdjNode; k++) {
				factor = NetworkManager_3D.getHelpingUtility()
						.getNextRandomNumber();
				factor = factor * 5 + 6;
				int intVal = (int) factor;
				factor = (double) intVal / 10;

				if (IConstants_3D.ASYNCHRONOUS)
				{
					//System.out.println("factor ="+factor+"Address ="+(address + k));
					nd = new Node_3D(address + k, meshSwitch, k,IConstants_3D.CURRENT_VC_COUNT, factor);
				}
				else
					{
					//System.out.println("factor ="+factor+"Address ="+(address + k));
					nd = new Node_3D(address + k, meshSwitch, k,IConstants_3D.CURRENT_VC_COUNT, 1.0);
					}
				//System.out.println("Address Of Node  :"+nd.getAddress());
				meshSwitch.setAdjacentNode(nd, k);
				nodeList.add(nd);
				
			}
		}
		//System.out.println("IP Nodes "+IConstants_3D.NUMBER_OF_IP_NODE);
		// assign index to nodes for statistical purpose
		for (i = 0; i < IConstants_3D.NUMBER_OF_IP_NODE; i++) {
			((Node_3D) nodeList.get(i)).setNodeListIndex(i);
		}
	}

	/**
	 * Completes the creation of mesh network by setting the adjacency
	 * relationship between the switches of consecutive different x_axiss and
	 * y_axisumns. The switches are added in the network in x_axis major order i.e.
	 * first the earlier x_axiss are filled. The method works in the following
	 * steps.
	 * 
	 * <ul>
	 * <li>For every switch determine its x_axis and y_axisumn index.</li>
	 * <li>Calculates minimum number of switches required in the network to
	 * have an adjacent switch in the bottom direction for this switch.</li>
	 * <li>Calculates minimum number of switches required in the network to
	 * have an adjacent switch in the right direction for this switch.</li>
	 * <li>If x_axis index of this switch is greater than zero then this switch
	 * will have adjacent switch in top direction. If it has adjacent switch in
	 * top direction then that is found out (just one x_axis earlier and same
	 * y_axisumn) and corresponding adjacency field is updated for each switch. And
	 * then input/output link controllers for top direction are added.</li>
	 * <li>If x_axis index of this switch is less than the maximum number of x_axiss
	 * in the mesh network and the network has sufficient number of switches to
	 * have an adjacent switch in bottom direction then the switch in bottom
	 * direction is found out (just one x_axis below and same y_axisumn). The
	 * adjacency fields are updated for both these switches along with adding
	 * input/output link controller for bottom direction.</li>
	 * <li>In the similar way left and right adjacent switches are found out by
	 * using y_axisumn index value of the switch and corresponding adjacency
	 * information are updates.</li>
	 * </ul>
	 * 
	 * 
	 * @see MeshSwitch_3D
	 * @see InputLinkController_3D
	 * @see OutputLinkController_3D
	 * @see IConstants_3D
	 * 
	 */
	
	
	private void setAdjacentMeshSwitch() {
		MeshSwitch_3D meshSwitch;
		int noOfAdjNode;
		int i, x_axis, y_axis,z_axis ;

		

		int numSwitch = IConstants_3D.NUMBER_OF_SWITCH;
         
		for (i = 0; i < numSwitch; i++)
		
		{
			x_axis = (i / 8)%8;
			y_axis = i % 8;
			z_axis = i / 64;
			meshSwitch = (MeshSwitch_3D) (switchList.get(i));
			noOfAdjNode = IConstants_3D.MESH_ADJ_NODE;
			
			

			if (x_axis > 0) {
				// top
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList
						.get(i-8),
						IConstants_3D.SWITCH_TOP);
			} else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_TOP
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_TOP
						+ noOfAdjNode, null);
			}
			if (x_axis < 7) {
				// bottom
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList.get(i+8),
						IConstants_3D.SWITCH_BOTTOM);
			} else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_BOTTOM
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_BOTTOM
						+ noOfAdjNode, null);
			}

			if (y_axis > 0) {
				// left
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList
						.get(i-1),
						IConstants_3D.SWITCH_LEFT);
			} else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_LEFT
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_LEFT
						+ noOfAdjNode, null);
			}

			if (y_axis < 7) {
				// right
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList
						.get(i+1),
						IConstants_3D.SWITCH_RIGHT);
			} else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_RIGHT
						+ noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_RIGHT
						+ noOfAdjNode, null);
			}
			if(z_axis>0)
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D)
						switchList.get(i-64), IConstants_3D.SWITCH_UP);
			else
			{
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_UP+noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_UP+noOfAdjNode, null);
			}
			if(z_axis<(numSwitch/64)-1)
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D)
						switchList.get(i+64), IConstants_3D.SWITCH_DOWN);
			else
			{
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_DOWN+noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_DOWN+noOfAdjNode, null);
			}
			
		}
	}

	/**
	 * <p>
	 * This method completes the creation of torus network by setting the
	 * adjacency relationship between the switches of consecutive different
	 * levels. The method works in almost the same way as was described for mesh
	 * network except the circular relation.
	 * </p>
	 * 
	 * <p>
	 * The switches in the top most and bottom most x_axiss have adjacency relation
	 * in top and bottom directions respectively whereas in mesh network they
	 * had no adjacency relations. And in similar way leftmost and rightmost
	 * y_axisumns have adjacency relation in left and right directions respectively
	 * whereas in mesh network they had no adjacency relations.
	 * </p>
	 * 
	 * @see MeshSwitch_3D
	 * @see InputLinkController
	 * @see OutputLinkController
	 * @see IConstants_3D
	 * 
	 */

	
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
		Switch_3D nocSwitch;
		for (i = 0; i < nodeList.size(); i++) {
			Node_3D node = (Node_3D) nodeList.get(i);
			node.nodeTraffic.setNextMsgGenTime(0);
		}

		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
			nocSwitch.resetSwitchingInfoVector();
		}

		// track no of link active in each Switch. For statistical purpose
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
			NetworkManager_3D.getStatDataInstance().setSwitchNumLink(i,
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
		Node_3D node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node_3D) nodeList.get(i);
			node.updateOutput(nCycle);
		}
	}

	public void updateSwitchTrafficPathRequest(int nCycle) {
		int i;
		Switch_3D nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
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
		Switch_3D nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
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
		Switch_3D nocSwitch;
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
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
		Node_3D node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node_3D) nodeList.get(i);
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
		Switch_3D nocSwitch;
		Node_3D node;
		for (i = 0; i < nodeList.size(); i++) {
			node = (Node_3D) nodeList.get(i);
			node.updateStatusAfterCycle(curCycle);
		}
		for (i = 0; i < switchList.size(); i++) {
			nocSwitch = (Switch_3D) switchList.get(i);
			nocSwitch.updateStatusAfterCycle(curCycle);
		}
	}

}