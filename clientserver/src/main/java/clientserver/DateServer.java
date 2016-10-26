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


public class DateServer {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9999);
        Scanner scan = new Scanner(System.in);
        try {
        	
        	while (true){
        		KafkaOutChannel.writeToKafka(getNode(), "MyTopic");
        	}
            /*while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(getNode());
                    System.out.println("A Node has been sent successfully");
                } finally {
                    socket.close();
                }
            }*/
        }
        finally {
            listener.close();
        }
    }
	
//	public static void main(String args[]){
//		for(int i=0;i<10;i++){
//		System.out.println(getNode());
//		}
//	}
	
	
    public static String [] AccountType = {"saving","current"};
    public static String [] Channels = {"offline","online","atm/cdm"};
    public static String [] locations = {"Mumbai","Pune"};
    
    public static String getNode (){
    	Random random = new Random();
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		Date date = new Date();
		
    	String accountnumber = "accountnumber:"+createRandomInteger(1000000000, 9999999999L, random);
    	String transectionid = "transectionid:"+createRandomInteger(10000, 99999L, random);
    	String amount = "amount:"+Integer.toString(random.nextInt(500000));
    	String accType = "accType:"+AccountType[random.nextInt(AccountType.length)];
    	String channel = "channel:"+Channels[random.nextInt(Channels.length)];
    	String location = "geolocation:"+ locations[random.nextInt(locations.length)];
    	String transTime = "transTime:"+dateFormat.format(date);
    	
    	return accountnumber+","+transectionid+","+amount+","+accType+","+channel+","+location+","+transTime;
    	
    }
    
    
    
    private static String createRandomInteger(int aStart, long aEnd,Random aRandom){
//	    Random aRandom = new Random();
    	if ( aStart > aEnd ) {
	      throw new IllegalArgumentException("Start cannot exceed End.");
	    }
	    long range = aEnd - (long)aStart + 1;
	    long fraction = (long)(range * aRandom.nextDouble());
	    long randomNumber =  fraction + (long)aStart;
	    return Long.toString(randomNumber);
	  }
    }