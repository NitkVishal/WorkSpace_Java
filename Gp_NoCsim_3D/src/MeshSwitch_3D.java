
public class MeshSwitch_3D {

	
	private int address;
	
	private int switchIndex;
	
	private int noOfPhysicallink;
	
	private int noOfvirtualLink;
	
	private MeshSwitch_3D [] switchList;

	private Node_3D [] nodeList;

	private int LastVCServeredList;
	
	private InputLinkController_3D inputLC[];
	
	private OutputLinkController_3D outputLC[];
	
	
	public MeshSwitch_3D(int pLink , int vLink , int address , int noOfAdjNode ,int noOfAdjSwitch ,int switchIndex){
		}

	
	public void setAdjacentNode(Node_3D node, int linkNo) {
		nodeList[linkNo] = node;
	}
	
	
	public void setAdjacentSwitch(MeshSwitch_3D meshSwitch, int linkNo) {
		switchList[linkNo] = meshSwitch;
	}
	
	public void setInputLinkController(int linkNo, InputLinkController_3D iLC) {
		
		inputLC[linkNo] = iLC;
		
	}
	
	public void setOutputLinkController(int linkNo, OutputLinkController_3D oLC) {
		outputLC[linkNo] = oLC;
	}
	
	
	
	
	
	
}
