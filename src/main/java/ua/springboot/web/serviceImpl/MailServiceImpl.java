package ua.springboot.web.serviceImpl;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ua.springboot.web.mail.Mail;
import ua.springboot.web.service.MailService;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendMessage(Mail mail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getContent());
		
		mailSender.send(message);
	}

	
	
}
