package emailrAndD.analysis;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.event.MessageCountEvent;
import javax.mail.event.MessageCountListener;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;

import emailrAndD.sendEmail.SendMail;

/*@author Vishal
 * Date  7-Sep-16
 * 
 * call start services services method TO start listner!!
*/



public class ImapReconnect {

    private IMAPFolder imapFolder;
    private IMAPFolder processedFolder;
    private IMAPFolder invalidFolder;
    private static String email;
    private static String password;
    private static final long KEEP_ALIVE_FREQ = 1000;
    private static final String IRIDIUM_MAILBOX_PROCESSED="Processed";
    private static final String IRIDIUM_MAILBOX_INVALID="Invalid";
    
    public ImapReconnect(String email,String pass){
    	this.email = email;
    	this.password = pass;
    }
    
    private void startService(){
        try {
            setup();
        } catch( MessagingException e) {
            System.out.println("Error configuring imap server:");
            System.out.println(e.toString());
            System.exit(1);
        }

        Thread keepAlive = new Thread(new Runnable(){
            public void run() {
                keepAliveRunner();
            }
        });
        keepAlive.start();

        imapFolder.addMessageCountListener(new MessageCountListener(){

            public void messagesAdded(MessageCountEvent arg0) {
                System.out.println("New message was added.");
                try {
					Message msg = imapFolder.getMessage(imapFolder.getMessageCount());
					if(msg.getContent() instanceof Multipart){
						Multipart mp = (Multipart) msg.getContent();
		                BodyPart bp = mp.getBodyPart(0);
						DataNode node = new DataNode();
						node.setChannel("email");
						String from = msg.getFrom()[0].toString();
		                node.setFrom(from.substring(from.indexOf("<")+1,from.length()-1));
		                node.setText(bp.getContent().toString());
		                System.out.println(node.getChannel() +" !! "+node.getfrom()+" !! "+node.getText());
		                
//		                Sent node for further analysis
		                
		                
		                
		                
		                
		            }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            public void messagesRemoved(MessageCountEvent arg0) {

            }

        });

        while (!Thread.interrupted()) {
            try {
                imapFolder.idle();
            } catch (FolderClosedException e) {
                System.out.println("The remote server closed the IMAP folder, we're going to try reconnecting.");
                startService();
            } catch (MessagingException e) {
                System.out.println("Now closing imap mailbox, due to unhandlable exception: ");
                System.out.println(e.toString());
                break;
            }      
        }

        if (keepAlive.isAlive()) {
            keepAlive.interrupt();
        }

        try {
            imapFolder.close(false);
            processedFolder.close(false);
            invalidFolder.close(false);
        } catch (MessagingException e) {
            System.out.println("Error closing all the folders:");
            System.out.println(e.toString());
        }
    }

    private void setup() throws MessagingException{
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, null);
        Store store = session.getStore();

        store.connect("imap.googlemail.com", 993,email,password);
        imapFolder = (IMAPFolder) store.getFolder("INBOX");

        processedFolder = (IMAPFolder) imapFolder.getFolder(IRIDIUM_MAILBOX_PROCESSED);
        if(!processedFolder.exists())
            processedFolder.create(Folder.HOLDS_MESSAGES);

        invalidFolder = (IMAPFolder) imapFolder.getFolder(IRIDIUM_MAILBOX_INVALID);
        if(!invalidFolder.exists())
            invalidFolder.create(Folder.HOLDS_MESSAGES);

        imapFolder.open(Folder.READ_WRITE);
    }

    public void keepAliveRunner(){
        while (!Thread.interrupted()) {
            try {
                // sleep for 5 minutes
                Thread.sleep(KEEP_ALIVE_FREQ);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                imapFolder.doCommand(new IMAPFolder.ProtocolCommand() {
                    public Object doCommand(IMAPProtocol p)
                            throws ProtocolException {
                        p.simpleCommand("NOOP", null);
                        return null;
                    }
                });
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ImapReconnect reconnect = new ImapReconnect("vishalbabu.in@gmail.com", "Go@73510");
        reconnect.startService();
    }
}