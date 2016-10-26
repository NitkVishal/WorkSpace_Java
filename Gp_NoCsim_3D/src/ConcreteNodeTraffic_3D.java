import java.util.Vector;


public class ConcreteNodeTraffic_3D extends NodeTraffic_3D{
	
	public static long LOCAL_IN = 0;
	
	public static long LOCAL_OUT = 0;
	
	public ConcreteNodeTraffic_3D(int address){
	   super(address);
	}
	
	
	
	public static void main(String args []){
  }



	@Override
	public Vector generateMessage(int curCycle, int curMessageCount) {
		Vector packet = new Vector();
		int vcId = 0;
		 int i;
		 
		 if(curMessageCount >= IConstants_3D.MAX_MESSAGE_NUMBER) {
			 nextMsgGenTime = curCycle + 1;
			 return null;
		 }
		 
		 int noOfFlit = this.getDestination();
		 
		 int destination = 0;
		 destination  = this.getDestination();
		 
		// packet.add(createHeaderFlit(destination , noOfFlit , vcId, curCycle));
		 
		 
		 for(i =1; i < noOfFlit; i++) 
			// packet.add(createDataFlit( vcId, curCycle, destination));
		 
		 setNextMsgGenTime(curCycle);
		
		 
		 return packet;
	}



	@Override
	public void setNextMsgGenTime(int curCycle) {
		// TODO Auto-generated method stub
		
	}



	@Override
	protected int getNextMsgGenTime() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	protected int getDestination() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	protected int getMessageSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
