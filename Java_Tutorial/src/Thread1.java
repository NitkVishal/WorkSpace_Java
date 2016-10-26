
public class Thread1 extends Thread {
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Message from Second thread"  +i);
		}
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException II){
			System.out.println("First ThreadException When it is sleeping  "+ II);
		}
		
	}
	

}
