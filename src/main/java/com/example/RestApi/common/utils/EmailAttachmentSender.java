package com.example.RestApi.common.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailAttachmentSender {

    /*@Autowired
	private JavaMailSender mailSender;*/

    public static void sendEmailWithAttachments(String name, String toEmail,
												String subject,
												String body, String attachment) {
//		javax.mail.internet.MimeMessage mimeMessage = mailSender.createMimeMessage();
//		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setFrom("arjungautam8877@gmail.com");
//        mimeMessageHelper.setTo(toEmail);
//		String msg = "Sent By:- " + name + "\r\n" + " Message is :-  " + body;
//        mimeMessageHelper.setText(msg);
//        mimeMessageHelper.setSubject(subject);
//
//        FileSystemResource fileSystemResource =
//                new FileSystemResource(new File(attachment));
//        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),
//                fileSystemResource);
//        mailSender.send(mimeMessage);
        System.out.printf("Mail with attachment sent successfully..");
    }

}

/*	public static void sendEmailWithAttachments(String host, String port, final String addresses, final String password,
			String name, String address, String subject, String message) {
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

	}*/

