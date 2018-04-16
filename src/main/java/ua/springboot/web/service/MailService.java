package ua.springboot.web.service;

import ua.springboot.web.mail.Mail;

public interface MailService {

	void sendMessage(Mail mail);
	
}
