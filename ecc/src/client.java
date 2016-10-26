

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class client
{

	public static void main(String args[]) throws IOException 
	{
		final String host = "localhost";
		final int portNumber = 81;
		System.out.println("Creating socket to '" + host + "' on port " + portNumber);
		
		
		while (true) {
			Socket socket = new Socket(host, portNumber);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			System.out.println("server says:" + br.readLine());

			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
			String userInput = userInputBR.readLine();

			out.println(maca());

			System.out.println("server says:" + br.readLine());

			if ("exit".equalsIgnoreCase(userInput)) {
				socket.close();
				break;
			}
		}
	}
	
	
	
	
	
	
	public static String maca()
	{
		      String str = null,str1=null;
			 
			    InetAddress ip;
				try {
				     ip=InetAddress.getLocalHost();
				     str1=ip.getHostAddress();
					 System.out.println("current ip address  :" +str1 );
					 NetworkInterface network = NetworkInterface.getByInetAddress(ip);
					 byte[] ma = network.getHardwareAddress();
					 StringBuilder sb = new StringBuilder();
					 for(int i=0;i<ma.length;i++)
					 {
						 sb.append(String.format("%02X%s", ma[i], (i < ma.length - 1) ? "-" : ""));
						// System.out.print(" "+ma[i]);
						 //System.out.print();
					 }
					 //System.out.println(network);
					  str=sb.toString();
					 //System.out.println();
				    }
				catch (UnknownHostException e) 
				{
					e.printStackTrace();
					}
				 catch (SocketException e)
				 {
				  e.printStackTrace();
				 }
			 
		 return str;
	}
	
	
	
	
}