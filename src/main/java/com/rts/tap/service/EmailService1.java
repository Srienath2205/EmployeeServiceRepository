package com.rts.tap.service;

import com.rts.tap.constants.EmailConstants;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService1 {

    
    private JavaMailSender mailSender;
    
    

    public EmailService1(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public void sendLoginCredentials(String toEmail, String username, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(EmailConstants.LOGIN_CREDENTIALS_SUBJECT);
        message.setText(String.format(EmailConstants.LOGIN_CREDENTIALS_BODY_TEMPLATE, username, password));

        mailSender.send(message);
    }

    public void sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject(subject != null ? subject : EmailConstants.DEFAULT_EMAIL_SUBJECT);
        message.setText(String.format(EmailConstants.DEFAULT_EMAIL_BODY_TEMPLATE, body));

        mailSender.send(message);
    }
}