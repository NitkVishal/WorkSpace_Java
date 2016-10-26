
public class Thread2 extends Thread {
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Message from First thred " +i);
			try{
				Thread.sleep(1000);
			}catch(InterruptedException interruptedExceptuion ){
				System.out.println("First ThreadException When it is sleeping  "+ interruptedExceptuion);
			}
		}
	}

}
