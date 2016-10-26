package clientserver;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class DataServerDuplicateNodeKafka {

	static int count=0;
	static String preNode=null;
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9999);
        Scanner scan = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date date;
        String node;
        while (true) {
            	if(count%4==1){
                	node = preNode;
                	date = new Date();
                	node+="transTime:"+dateFormat.format(date);
                	KafkaOutChannel.writeToKafka(node, "TestTopic");
//                	System.out.println("Same NOde"+ node);
                } else {
                	node  = getNode();
                	date = new Date();
                	node+="transTime:"+dateFormat.format(date);
    				KafkaOutChannel.writeToKafka(node, "TestTopic");
//    				System.out.println("Random Node"+node);
    			}
    			count++;
    			count=count%10;
        }
    }
	
//	public static void main(String args[]){
//		for(int i=0;i<20;i++){
//			if(count%4==1)
//				System.out.println("Same"+preNode);
//			else {
//				System.out.println("random"+getNode());
//			}
//			count++;
//			count=count%10;
//			
//		}
//	}
	
	
    public static String [] AccountType = {"saving","current"};
    public static String [] Channels = {"offline","online","atm/cdm"};
    public static String [] locations = {"Mumbai","Pune"};
    
    public static String getNode (){
    	Random random = new Random();
//    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//		Date date = new Date();
		
    	String accountnumber = "accountnumber:"+createRandomInteger(1000000000, 9999999999L);
    	String transectionid = "transectionid:"+createRandomInteger(10000, 99999L);
    	String amount = "amount:"+Integer.toString(random.nextInt(500000));
    	String accType = "accType:"+AccountType[random.nextInt(AccountType.length)];
    	String channel = "channel:"+Channels[random.nextInt(Channels.length)];
//    	String transTime = "transTime:"+dateFormat.format(date);
    	String location = "geolocation:"+ locations[random.nextInt(locations.length)];
    	preNode= accountnumber+","+transectionid+","+amount+","+accType+","+channel+","+location+",";
    	return preNode;
    	
    }
    
    
    
    
    private static String createRandomInteger(int aStart, long aEnd){
	    Random aRandom = new Random();
    	if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    long range = aEnd - (long)aStart + 1;
	    long fraction = (long)(range * aRandom.nextDouble());
	    long randomNumber =  fraction + (long)aStart;
	    return Long.toString(randomNumber);
	  }
    
}

