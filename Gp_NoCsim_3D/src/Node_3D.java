import java.io.*;
import java.util.*;

public class Node_3D {
	
	private int address; 
	
	//private int nodeListIndex;
	
	public MeshSwitch_3D parent;
	
	private int messageVCIndex[];
	
	private int messagecount = 0;
	
	private Vector[] massegeList;
	
	private Vector[] receiveMassegeList;
	
	private int nodeReceivedFlitCounter[];
	
	private int [] outVCUsedList;
	
	private int vcCount;
	
	private int linkNo;
	
	private int lastSender = 0;
	
	private int lastOutVCServed = 0;
	
	private int lastInVCServed = 0;
	
	private int nodeListIndex ;
	
	private double clockRateFactor;
	
	private int lastUsedOwnInCycle = -1;
	
	private int lastUsedOwnOutCycle = -1;
	
	private InputVCBuffer_3D inputBuffer;
	
	private OutputVCBuffer_3D outputBuffer;
	
	//Nodetraffic nodeTraffic;
	
	
	
	
	
	public Node_3D(int address, MeshSwitch_3D parent, int pLink, int vcCount,
			double clkRateFactor) {
		
		int i;
		this.address = address;
		this.parent = parent;
		this.linkNo = pLink;
		this.vcCount = vcCount;
		this.clockRateFactor = clkRateFactor;
	}
	
	
	private void generateMassege(int curCycle){
		Vector packet;
		int i;
		
		//packet = nodeTraffic.
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void setNodeListIndex(int index) {
		this.nodeListIndex = index;
	}
	
	public static void main(String args []){
		System.out.println();
	}

	
	

}
