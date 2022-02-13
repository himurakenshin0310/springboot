package com.spring.mail;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailImp = new JavaMailSenderImpl();
		mailImp.setHost("smtp.gmail.com");
		mailImp.setPort(587);

		mailImp.setUsername("himurakenshin0310@gmail.com");
		mailImp.setPassword("password");

		Properties props = mailImp.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailImp;
	}
}
