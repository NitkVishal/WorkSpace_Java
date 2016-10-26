
import java.io.*;
import java.net.*;
public class Provider{
    ServerSocket ps;
    Socket con = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String message;
    Provider(){}
    void run()
    {
        try{
            //1. creating a server socket
            ps = new ServerSocket(2004, 10);
            //2. Wait for connection
            System.out.println("Waiting for connection");
            con = ps.accept();
            //InetAddress str=con.getInetAddress();
           // System.out.println("Connection received from " +str );
            //3. get Input and Output streams
            out = new ObjectOutputStream(con.getOutputStream());
            //System.out.println(con.getOutputStream());
            out.flush();
            in = new ObjectInputStream(con.getInputStream());
            sendMessage("Connection successful");
            //4. The two parts communicate via the input and output streams
           do{
                try{
                    message = (String)in.readObject();
                    
                    System.out.println("client>" + message);
                    if (message.equals("bye"))
                        sendMessage("bye");
                }
                catch(ClassNotFoundException classnot){
                    System.err.println("Data received in unknown format");
                }
            }
            while(!message.equals("bye"));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                ps.close();
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
            System.out.println("server>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        Provider server = new Provider();
        while(true)
        {
            server.run();
        }
    }
}