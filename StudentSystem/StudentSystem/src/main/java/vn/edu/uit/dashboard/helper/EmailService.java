package vn.edu.uit.dashboard.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public static void send(String sendTo, String subject, String content) {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "khoeladep.com.vn");
			props.put("mail.smtp.socketFactory.port", "587");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.localhost", "khoeladep.com.vn");

			Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("hotro@khoeladep.com.vn","alo!@#app");
					}
			});
			
		
			
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hotro@khoeladep.com.vn"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
//			message.addRecipient(Message.RecipientType.CC, new InternetAddress("hieutran59794@gmail.com"));
//			message.addRecipient(Message.RecipientType.CC, new InternetAddress("duongaiduc123@gmail.com"));
//			message.addRecipient(Message.RecipientType.CC, new InternetAddress("tuan.iwork.vn@gmail.com"));
			message.setSubject(subject);
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}
}