
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class mac
{
public static void main(String args [])
 {
    InetAddress ip;
	try {
	     ip=InetAddress.getLocalHost();
		 System.out.println("current ip address  :" + ip.getHostAddress());
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
		 System.out.println(sb.toString());
	    }
	catch (UnknownHostException e) {
		 
		e.printStackTrace();}
	 catch (SocketException e){
		 
			e.printStackTrace();
	 
		}
 }
}