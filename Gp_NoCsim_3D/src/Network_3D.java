import java.util.Vector;


public class Network_3D {

	private Vector nodeList;
	
	private Vector switchList;
	
	
	public Network_3D(int networkType) {
		
		nodeList = new Vector();
		switchList = new Vector();
		
	}
	
	
	public void createMeshNetwork_3D(){
	  //public static void main(String args[]){
			
		int i, address, numSwitch, row, col,  noOfAdjNode ;
		double factor;
		MeshSwitch_3D meshSwitch;
		Node_3D nd;
		
		
		noOfAdjNode = IConstants_3D.MESH_ADJ_NODE;
		numSwitch = IConstants_3D.NUMBER_OF_IP_NODE / noOfAdjNode;
		
		IConstants_3D.MESH_ROW = (int) Math.floor(Math.sqrt(numSwitch));
		IConstants_3D.MESH_COL = (int) Math.ceil(Math.sqrt(numSwitch));
		IConstants_3D.MESH_NODE_BITS_REQ = (int) Math.ceil(Math.log(IConstants_3D.MESH_ADJ_NODE) / Math.log(2));
		IConstants_3D.CURRENT_LINK_COUNT = IConstants_3D.MESH_ADJ_NODE + 4;
		IConstants_3D.MESH_ROW_BITS = (int) Math.ceil(Math.log(IConstants_3D.MESH_ROW) / Math.log(2));
		IConstants_3D.MESH_COL_BITS = (int) Math.ceil(Math.log(IConstants_3D.MESH_COL) / Math.log(2));
		
		
		
	  /*   Readjusted Number of IP Nodes and Number of Switches .. Only n * m
		   swithces are possible.. where n = m or m+1  */
		 
		
		
	    IConstants_3D.NUMBER_OF_SWITCH = IConstants_3D.MESH_ROW * IConstants_3D.MESH_COL;
	    IConstants_3D.NUMBER_OF_IP_NODE = IConstants_3D.NUMBER_OF_SWITCH * noOfAdjNode;
	    
	 // Creates the Mesh Switches
	    for (i = 0; i < IConstants_3D.NUMBER_OF_SWITCH; i++) {
			row = i / IConstants_3D.MESH_COL;
			col = i % IConstants_3D.MESH_COL;
			address = (row << IConstants_3D.MESH_COL_BITS) + col;
			meshSwitch = new MeshSwitch_3D(IConstants_3D.CURRENT_LINK_COUNT,
					IConstants_3D.CURRENT_VC_COUNT, address, noOfAdjNode,
					IConstants_3D.CURRENT_ADJ_SWITCH, i);
			switchList.add(meshSwitch);
		
			//add Node to Switch
			address = address << IConstants_3D.MESH_NODE_BITS_REQ;
			nd = new Node_3D(address , meshSwitch,  0,
					IConstants_3D.CURRENT_VC_COUNT, 1.0);
			meshSwitch.setAdjacentNode(nd, 0);
			nodeList.add(nd);
		}
	    
	      //assign index to nodes for statistical purpose
	 		for (i = 0; i < IConstants_3D.NUMBER_OF_IP_NODE; i++) {
	 			((Node_3D) nodeList.get(i)).setNodeListIndex(i);
	 		}
	 }
	
	
	
	 private void setAdjacentMeshSwitch() {
		//public static void main(String args[]){
		MeshSwitch_3D meshSwitch;
		int noOfAdjNode;
		int i , row , col , minSwitchBottomReq , minSwitchRightReq ;
		
		int maxRow = IConstants_3D.MESH_ROW - 1 ;
		int maxCol = IConstants_3D.MESH_COL - 1 ; 
		
		int numSwitch = IConstants_3D.NUMBER_OF_SWITCH ; 
		
		for(i =9; i <10 ; i++){
			row = i / IConstants_3D.MESH_COL;
			col = i % IConstants_3D.MESH_COL;
			meshSwitch = (MeshSwitch_3D) (switchList.get(i));
			noOfAdjNode = IConstants_3D.MESH_ADJ_NODE;
			minSwitchBottomReq = ((row + 1) *IConstants_3D.MESH_COL) +col + 1;
			minSwitchRightReq = row * IConstants_3D.MESH_COL + col + 1 + 1;
			
			
			if(row > 0) {
               // top
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList.get(((row - 1) *
						IConstants_3D.MESH_COL) + col), IConstants_3D.SWITCH_TOP);
			}else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_TOP + noOfAdjNode , null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_TOP + noOfAdjNode , null);
			}
			
			
			if(row < maxRow && numSwitch >=minSwitchBottomReq) {
				// bottom
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList.get(((row+1) * 
						IConstants_3D.MESH_COL) + col) ,IConstants_3D.SWITCH_BOTTOM);
			}else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_BOTTOM + noOfAdjNode ,null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_BOTTOM + noOfAdjNode ,null);
			}
			
			
			if (col > 0) {
				//left
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList.get((row*IConstants_3D.MESH_COL) + 
						(col-1)), IConstants_3D.SWITCH_LEFT);
			}else {
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_LEFT + noOfAdjNode, null);
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_LEFT + noOfAdjNode, null);
			}
			
			
			if(col <maxCol && numSwitch >= minSwitchRightReq){
				//right
				meshSwitch.setAdjacentSwitch((MeshSwitch_3D) switchList.get((row * IConstants_3D.MESH_COL) + 
						(col+1)), IConstants_3D.SWITCH_RIGHT);
			}else{
				meshSwitch.setInputLinkController(IConstants_3D.SWITCH_RIGHT + noOfAdjNode, null) ;
				meshSwitch.setOutputLinkController(IConstants_3D.SWITCH_RIGHT + noOfAdjNode, null) ;
			}
				 
			//System.out.println(minSwitchRightReq);	
			System.out.println(numSwitch);
		}
		
   }
	 
	 
	 
	 
	
}
