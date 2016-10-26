

import java.io.*;
import java.net.*;


public class Requester{
	InetAddress ip;
    Socket requestSocket;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    Requester(){}
    void run()
    {
        try{
            //1. creating a socket to connect to the server
            requestSocket = new Socket("localhost", 2004);
            System.out.println("Connected to localhost in port 2004");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            
            ip=InetAddress.getLocalHost();
            NetworkInterface ntwk = NetworkInterface.getByInetAddress(ip);
   		    byte[] ma = ntwk.getHardwareAddress();
   		    StringBuilder sb = new StringBuilder();
   		    for(int i=0;i<ma.length;i++)
		    {
			 sb.append(String.format("%02X%s", ma[i], (i < ma.length - 1) ? "-" : ""));
			// System.out.print(" "+ma[i]);
			 //System.out.print();
		     }
   		    String str=sb.toString();
   		   
            //3: Communicating with the server
           do{
                try{
                    message = (String)in.readObject();
                    System.out.println("server>" + message);
                    //sendMessage("Hi my server");
                    //sendMessage("my ip is "+ip);
                    sendMessage("and my mac is "+str);
                    message = "bye";
                    sendMessage(message);
                }
                catch(ClassNotFoundException classNot){
                    System.err.println("data received in unknown format");
                }
            }
            while(!message.equals("bye"));
        }
        catch(UnknownHostException unknownHost){
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println("client>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        Requester client = new Requester();
        client.run();
    }
}