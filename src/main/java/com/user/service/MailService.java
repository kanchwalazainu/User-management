package com.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.user.model.Mail;
import com.user.model.User;
import com.user.repository.MailRepository;

@Service
public class MailService {

	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailRepository mailRepository;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {

		this.javaMailSender = javaMailSender;

	}

	public void sendEmail(User user) throws MailException {

		SimpleMailMessage mail = new SimpleMailMessage();
		String subject="Registration to PCCW successfull!!";
		String body = "Welcome " +user.getFirstName() + " "+user.getLastName() +"  to our team!! You have been successfully registrated at PCCW";
		
		Mail newMail=new Mail(user.getUserid(), subject, body, user.getEmailId());
		
		mail.setTo(user.getEmailId());

		mail.setSubject(newMail.getMailsubject());

		mail.setText(newMail.getMailbody());

		javaMailSender.send(mail);
		
		mailRepository.save(newMail);

	}
	
	
	public List<Mail> getAllMails(){
		
		List<Mail> mails= new ArrayList<Mail>();
		mailRepository.findAll().forEach(mails::add);
		return mails;
		
	}

}
