package emailrAndD.sendEmail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*@author Vishal
 * set the protocaol and server in properties
 * */

public class SendMail {

	public static void main(String[] args) {
//		String ssl = sendMailSSL("vishalbabu.in@gmail.com", "Go@73510", "vishal.babu@augmentiq.co.in", "Testing", "Hello Augmentian");
		String tls = sendMailTLS("vishalbabu.in@gmail.com", "Go@73510", "vishalbabu.in@gmail.com", "Testing", "Hello Augmentian");
		System.out.println(tls);
	}

	public static String sendMailSSL(final String userEmail, final String userPass,String to, String subject,String text){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userEmail,userPass);
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userEmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			return "Done";
		} catch (MessagingException me) {
			return me.getMessage();
		}
	}
	
	public static String sendMailTLS(final String userEmail, final String userPass,String to, String subject,String text){
		final String username = userEmail;
		final String password = userPass;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("Vishal"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);

			return "Done";

		} catch (MessagingException me) {
			return me.getMessage();
		}
	}
}
