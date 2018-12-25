package vn.edu.uit.dashboard.helper;

import java.io.IOException;
import java.util.Properties;
//
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHelper {
	
//	final private static String fromEmail = "tuan.nguyen@aloapp.com.vn";
//	final private static String username = "apikey";
//	final private static String password = "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";
//	final private static String smtpHost = "smtp.sendgrid.net";
//	final private static String smtpSocketPort = "587";
//	final private static String smtpMailPort = "587";
	
	final private static String fromEmail = "hotro@khoeladep.com.vn";
	final private static String username = "hotro@khoeladep.com.vn";
	final private static String password = "alo!@#app";
	final private static String smtpHost = "khoeladep.com.vn";
	final private static String smtpSocketPort = "587";
	final private static String smtpMailPort = "587";
	
	
	/*
	public static void sendEmailSendgrid(String sendTo, String subject, String message){
		Email from = new Email("tuan.nguyen@aloapp.com.vn");
//	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email(sendTo);
	    Content content = new Content("text/plain",message);
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("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"));
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	    	System.out.println(ex.getMessage());
	    }
	    
		
	}
	
	*/

	
	public static void sendEmailSMTP(String sendTo, String subject, String content) {
		try {
			Properties props = new Properties();
		    props.put("mail.smtp.host", smtpHost);
		    props.put("mail.smtp.socketFactory.port", smtpSocketPort);
		    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", smtpMailPort); 
		    Session session = Session.getDefaultInstance(props,
		        new Authenticator() {
		                            @Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(username, password);
		            }
		        });

		    try {

		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(fromEmail));
		        message.setRecipients(Message.RecipientType.TO,
		                InternetAddress.parse(sendTo));
		        message.setSubject(subject);
		        message.setText(content);

		        Transport.send(message);

		    } catch (MessagingException e) {
		        e.printStackTrace();
		    }
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}