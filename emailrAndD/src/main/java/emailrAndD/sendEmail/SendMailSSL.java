package emailrAndD.sendEmail;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailSSL {
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.augmentiq.co.in");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("vishalbabu.in@gmail.com","Go@73510");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vishalbabu.in@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("vishal.babu@augmentiq.co.in"));
			message.setSubject("Testing Subject");
			message.setText("Dear Augmentian," +
					"\n\n How are you doing , please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

