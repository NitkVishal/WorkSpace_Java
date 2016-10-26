package emailrAndD.ReadfromMailBox;

import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class InboxReader {

	public static void main(String args[]) throws IOException {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		try {
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", "vishalbabu.in@gmail.com", "Go@73510");
			
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_ONLY);
			

		    Flags seen = new Flags(Flags.Flag.SEEN);
		    FlagTerm unseenFlagTerm = new FlagTerm(seen, false);

			Message messages[] = inbox.search(unseenFlagTerm);
			System.out.println(messages.length);
			for(int i= messages.length;i>0;i--) {
				if(messages[i-1].getContent() instanceof Multipart){
					Multipart mp = (Multipart) messages[i-1].getContent();
					BodyPart bp = mp.getBodyPart(0);
					System.out.println("FROM :" + messages[i-1].getFrom()[0]);
					System.out.println("SENT DATE :" + messages[i-1].getSentDate());
		            System.out.println("SUBJECT :" + messages[i-1].getSubject());
		            MimeMultipart mine = (MimeMultipart) messages[i-1].getContent();
		            System.out.println("Content :" + mine.getBodyPart(0).getContent());
		            System.out.println();
			 	}
			}
		} catch (MessagingException e) {
			e.printStackTrace();
			System.exit(2);
		}
	}
}