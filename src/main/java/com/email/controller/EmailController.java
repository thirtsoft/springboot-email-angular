package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.model.Email;
import com.email.service.EmailService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/email")
	public ResponseEntity<Email> sendEmail(@ RequestBody Email email) {
		try {
			emailService.sendEmail(email);
			return new ResponseEntity<Email>(email, HttpStatus.OK);
		}catch(MailException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

}
