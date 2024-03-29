package com.example.RestApi.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@ConfigurationProperties
public class EmailConfig {

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private String port;

	@Value("${spring.mail.username}")
	private String user;

	@Value("${spring.mail.password}")
	private String password;

	@Value("${spring.email.sender.debug}")
	private Boolean debug;

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		System.out.println(user);
		System.out.println(password);
		mailSender.setHost(host);
		mailSender.setPort(Integer.parseInt(port));
		mailSender.setUsername(user);
		mailSender.setPassword(password);
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", debug);
		return mailSender;
	}
}
