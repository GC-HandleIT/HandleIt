package com.dao;

import java.util.Properties;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class EmailSessonBean
 */
@Stateless
@LocalBean
public class EmailSessonBean {

	private String port = "465";
	private String host = "stmp.gmail.com";
	private String to = "thehandleitproject@gmail.com";
	private String From = "user@email.com";
	private boolean auth = true;
	private String username = "thehandleitproject@gmail.com";
	private String password = "stuffandthings";
	private Protocol protocol = Protocol.SMTPS;
	private boolean debug = true;

	public void sendEmail(String name, String email, String phone, String message) throws MessagingException {
		
		
		
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.getProperty("mail.transport.protocol");
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", port);
		prop.setProperty("mail.user", username);
		prop.setProperty("mail.password", password);

		switch (protocol) {
		case SMTPS:
			prop.put("mail.smtp.ssl.enable", true);
			break;
		case TLS:
			prop.put("mail.smtp.smarttls.enable", true);
			break;
		case POP3:
			prop.put("mail.pop3.apop.enable", true);
			break;
		case IMAP:
			prop.put("mail.imap.sasl.enable", true);
			break;

		}

		Session session = Session.getInstance(prop, null);
			
		Transport transport = session.getTransport("smtp");
	
	
		try {
		MimeMessage message1 = new MimeMessage(session);
		
		
			message1.setFrom(email);
			message1.addRecipient(Message.RecipientType.TO, new InternetAddress("thehandleitproject@gmail.com"));
			message1.setSubject(phone);
			message1.setContentID(message);

			transport.connect();
			Transport.send(message1, message1.getRecipients(Message.RecipientType.TO));
			transport.close();

		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
	}

	public EmailSessonBean() {

	}

	public void sendEmail(String to2) {

	}

}
