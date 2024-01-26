package com.example.RestApi.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailAttachmentFeedBack {

	@Autowired
	private final JavaMailSender javaMailSender;

	public EmailAttachmentFeedBack(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendEmailWithAttachments(String toEmail, String subject, String body) {

		System.out.println("Mail Send start...");

		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setTo(toEmail);
			helper.setSubject("subject");
			helper.setText(body, true);
		};

		try {
			javaMailSender.send(messagePreparator);
		} catch (MailException e) {
			e.printStackTrace();
		}

		System.out.println("Mail Send end...");
	}

	public static String feedBackEmail(String facebook, String twitter, String instagram) {
		String Mail = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Mail</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "		<tbody>\r\n" + "			<tr>\r\n" + "				<td align=\"center\">\r\n"
				+ "					<table class=\"col-600\" width=\"600\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "						<div>\r\n" + "							<tr>\r\n"
				+ "								<img align=\"center\" valign=\"top\" src=\"https://t3.ftcdn.net/jpg/02/69/25/12/240_F_269251265_uupO2yxugYWtRY7FwD2P5FP6S5yzO468.jpg\" bgcolor=\"#66809b\"\r\n"
				+ "									style=\"background-position: top\">\r\n"
				+ "								<div class=\"col-600\" width=\"600\" height=\"400\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "									<tbody></tbody>\r\n" + "								</div>\r\n"
				+ "							</tr>\r\n" + "						</div>\r\n"
				+ "					</table>\r\n" + "				</td>\r\n" + "			</tr>\r\n"
				+ "			<tr>\r\n" + "				<td align=\"center\">\r\n"
				+ "					<table class=\"col-500\" width=\"465\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"\r\n"
				+ "						style=\"margin-left: 20px; margin-right: 20px; border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9\">\r\n"
				+ "						<tbody>\r\n" + "							<tr>\r\n"
				+ "								<td height=\"35\"></td>\r\n" + "							</tr>\r\n"
				+ "							<tr>\r\n"
				+ "								<td align=\"center\" style=\"text-shadow: 0.5px 0.5px 0.5px #000, 1px 1px 0.5px #00f; font-size: 20px; font-weight: 700; bgcolor: #2a3a4b;\">Thank You for taking\r\n"
				+ "									the time to post this! We really appreciate it. We look forward to seeing you again soon!</td>\r\n"
				+ "							</tr>\r\n" + "						</tbody>\r\n"
				+ "					</table>\r\n" + "				</td>\r\n" + "			</tr>\r\n"
				+ "			<tr>\r\n" + "				<td height=\"5\"></td>\r\n" + "			</tr>\r\n"
				+ "			<tr>\r\n" + "				<td align=\"center\">\r\n"
				+ "					<table class=\"col-465\" width=\"465\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-left: 20px; margin-right: 20px\">\r\n"
				+ "						<tbody>\r\n" + "							<tr>\r\n"
				+ "								<td align=\"center\">\r\n"
				+ "									<table align=\"center\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-left: 1px solid #dbd9d9; border-right: 1px solid #dbd9d9\">\r\n"
				+ "										<tbody>\r\n"
				+ "											<tr>\r\n"
				+ "												<td height=\"50\"></td>\r\n"
				+ "											</tr>\r\n"
				+ "											<tr>\r\n"
				+ "												<td align=\"center\" bgcolor=\"#34495e\" background=\"https://designmodo.com/demo/emailtemplate/images/footer.jpg\" height=\"185\">\r\n"
				+ "													<table class=\"col-600\" width=\"465\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n"
				+ "														<tbody>\r\n"
				+ "															<tr>\r\n"
				+ "																<td height=\"25\"></td>\r\n"
				+ "															</tr>\r\n"
				+ "															<tr>\r\n"
				+ "																<td align=\"center\" style=\"font-family: Raleway, sans-serif; font-size: 26px; font-weight: 500; color: #f1c40f\">Follow Me On Social Media</td>\r\n"
				+ "															</tr>\r\n"
				+ "															<tr>\r\n"
				+ "																<td height=\"25\"></td>\r\n"
				+ "															</tr>\r\n"
				+ "														</tbody>\r\n"
				+ "													</table>\r\n"
				+ "													<table align=\"center\" width=\"35%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n"
				+ "														<tbody>\r\n"
				+ "															<tr>\r\n"
				+ "																<td align=\"center\" width=\"30%\" style=\"vertical-align: top\"><a href="
				+ facebook + "+ target=\"_blank\"> <img\r\n"
				+ "																		src=\"https://cdn-icons-png.flaticon.com/512/145/145802.png\" height=\"50px\">\r\n"
				+ "																</a></td>\r\n"
				+ "																<td align=\"center\" class=\"margin\" width=\"30%\" style=\"vertical-align: top\"><a href="
				+ twitter + " target=\"_blank\"> <img\r\n"
				+ "																		src=\"https://designmodo.com/demo/emailtemplate/images/icon-twitter.png\">\r\n"
				+ "																</a></td>\r\n"
				+ "																<td align=\"center\" width=\"30%\" style=\"vertical-align: top\"><a href="
				+ instagram + " target=\"_blank\"> <img\r\n"
				+ "																		src=\"https://cdn.icon-icons.com/icons2/1211/PNG/512/1491579602-yumminkysocialmedia36_83067.png\" height=\"45px\">\r\n"
				+ "																</a></td>\r\n"
				+ "															</tr>\r\n"
				+ "														</tbody>\r\n"
				+ "													</table>\r\n"
				+ "												</td>\r\n"
				+ "											</tr>\r\n"
				+ "										</tbody>\r\n"
				+ "									</table>\r\n" + "								</td>\r\n"
				+ "							</tr>\r\n" + "						</tbody>\r\n"
				+ "					</table>\r\n" + "				</td>\r\n" + "			</tr>\r\n"
				+ "		</tbody>\r\n" + "	</table>\r\n" + "</body>\r\n" + "</html>";
		return Mail;
	}

}

//BELOW CODE IS OLD CODE FOR REFRENCE WHICH IS USING JAVA MAIL API NOW WE ARE USING SPRING MAIL API
/*
 * public static void sendEmailWithAttachments(String host, String port, final
 * String addresses, final String password, String name, String address, String
 * subject, String message) throws AddressException, MessagingException,
 * UnsupportedEncodingException { Properties properties = new Properties();
 * properties.put("mail.smtp.host", host); properties.put("mail.smtp.port",
 * 587); properties.put("mail.smtp.auth", true);
 * properties.put("mail.smtp.ssl.trust", host);
 * properties.put("mail.smtp.starttls.enable", "true");
 * 
 * Authenticator auth = new Authenticator() { public PasswordAuthentication
 * getPasswordAuthentication() { return new PasswordAuthentication(addresses,
 * password); } };
 * 
 * Session session = Session.getInstance(properties, auth);
 * 
 * Message msg = new MimeMessage(session); msg.setFrom(new InternetAddress());
 * msg.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
 * msg.setSubject(subject); msg.setSentDate(new Date()); MimeBodyPart
 * messageBodyPart = new MimeBodyPart(); messageBodyPart.setContent(message,
 * "text/html"); Multipart multipart = new MimeMultipart();
 * multipart.addBodyPart(messageBodyPart); msg.setContent(multipart);
 * 
 * Transport.send(msg);
 * 
 * }
 */
