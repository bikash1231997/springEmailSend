package com.example.RestApi.angular.controller;

import com.example.RestApi.angular.model.EmailModel;
import com.example.RestApi.common.utils.EmailAttachmentFeedBack;
import com.example.RestApi.common.utils.EmailAttachmentSender;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "send/")
public class AngularController {

	Logger logger = LoggerFactory.getLogger(AngularController.class);

	@Autowired
	EmailAttachmentFeedBack emailAttachmentFeedBack;

	@Autowired
	EmailAttachmentSender emailAttachmentSender;

	@RequestMapping(value = "", method = { RequestMethod.GET })
	public String hello() {
		return "Api is Running";
	}

	@RequestMapping(value = "emailsend", method = {
			RequestMethod.POST }, produces = "application/json", consumes = "application/json")
	@Transactional
	public ResponseEntity<String> emailsend(@Valid @RequestBody EmailModel email) {
		logger.info("Method : emailsend starts");

		if (!email.getSub().isEmpty() && !email.getMsg().isEmpty() && !email.getName().isEmpty()
				&& email.getSub() != null && email.getMsg() != null && email.getName() != null) {
			try {
				System.out.println("Hello");
				if (email.getChecker().equals("akash")) {
					System.out.println("akash");
					emailAttachmentFeedBack.sendEmailWithAttachments(email.getEmailaddr(),
							"Thank You For Your Response", "Akash Mahapatra");
					email.setMsg(email.getMsg() + "\r\n" + " Mailed By:- " + email.getEmailaddr());
					email.setEmailaddr("akashmahapatra71@gmail.com");
					emailAttachmentSender.sendEmailWithAttachments(email.getName(), email.getEmailaddr(),
							email.getSub(), email.getMsg(), "");

				} else if (email.getChecker().equals("bikash")) {
					System.out.println("bikash");
					String feedBackEmail = EmailAttachmentFeedBack.feedBackEmail(
							"https://www.facebook.com/bikash.mahapatra.31", "https://twitter.com/bikashbalia",
							"https://www.instagram.com/bikash_mahapatra_1997");
					emailAttachmentFeedBack.sendEmailWithAttachments(email.getEmailaddr(),
							"Thank You For Your Response", feedBackEmail);
					email.setMsg(email.getMsg() + "\r\n" + " Mailed By:- " + email.getEmailaddr());
					email.setEmailaddr("bikashmohapatra1997@gmail.com");
					System.out.println(email);
					emailAttachmentSender.sendEmailWithAttachments(email.getName(), email.getEmailaddr(),
							email.getSub(), email.getMsg(), "");
				} else {
					return null;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Send", "Sent");
		ResponseEntity<String> response = new ResponseEntity<String>("OK", responseHeaders, HttpStatus.OK);

		logger.info("Method : emailsend ends");
		return response;
	}
}