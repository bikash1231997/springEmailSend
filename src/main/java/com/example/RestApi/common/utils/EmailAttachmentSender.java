package com.example.RestApi.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class EmailAttachmentSender {

	public static void sendEmailWithAttachments(String host, String port, final String addresses, final String password,
			String name, String address, String subject, String message)
			throws AddressException, MessagingException, UnsupportedEncodingException {
		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", 587);
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.ssl.trust", host);
		properties.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(addresses, password);
			}
		};

		Session session = Session.getInstance(properties, auth);

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress());
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		message = "Sent By:- " + name + "\r\n" + " Message is :-  " + message;
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(message, "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);

		Transport.send(msg);

	}

}
