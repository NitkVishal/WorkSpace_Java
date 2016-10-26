
public interface Switch_3D1 {
	
	public abstract void setNoOfPhysicalLink(int no);
	
	public abstract int getNoOfPhysicalLink();
	
	public abstract void setNoOfVirtualLink(int noVlink);
	
	public abstract int getNoOfVirtualLink();
	
	public abstract void setAddress(int addr);
	
	public abstract int getAddress();
	
	public abstract void setAdjacentNode(Node_3D node , int linkNo);
	
	public abstract int getNumAdjacentNode();
	
	
	
	//public abstract InputLinkController getInputLinkController(int linkNo);
	public abstract void setAdjacentSwitch(Switch_3D1 switchref , int linkno);
	
	
	

}
