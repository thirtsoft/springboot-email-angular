package com.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.model.Email;
import com.email.reposiroy.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailRepository emailRepository;
	
	private JavaMailSender javaMailSender;
	
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		
	}

	@Override
	public void sendEmail(Email email) throws MailException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Nom: " + email.getName()).append(System.lineSeparator());
		sb.append("\n Message: " + email.getMessage());
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setTo(email.getEmail());
		mail.setFrom("thirdiallo@gmail.com");
		mail.setSubject(email.getSubject());
		mail.setText(sb.toString());
		
		javaMailSender.send(mail);
		
		emailRepository.save(email);
		
		
	}

}
