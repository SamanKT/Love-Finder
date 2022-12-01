package com.saman.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class LoveCalServiceImp implements LoveCalServise {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	
	@Override
	public void sendEmail(String userName, String mailAdress, String result) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailAdress);
		mailMessage.setSubject("Love Calculator Result");
		mailMessage.setText("Dear "+userName+", Your result is: "+result);
		
		javaMailSenderImpl.send(mailMessage);
		

	}

}
