package com.itwillbs.service;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service(value = "mailService")
public class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	// 메일 전송을 위한 설정 주입(mail-contextx.xml)
	@Inject
	private JavaMailSender mailSender;

	public void sendMail(String subject, String to, String body) throws Exception {
		
		logger.info("sendMail() 실행");

		MimeMessage message = mailSender.createMimeMessage();

		MimeMessageHelper msgHelper = new MimeMessageHelper(message, true, "UTF-8");
		
		msgHelper.setFrom("in95sung@gmail.com", "인성"); // 발신자 메일주소 
		msgHelper.setSubject(subject); // 제목
		msgHelper.setTo(to); // 받는사람 
		msgHelper.setText(body); // 내용
		
		mailSender.send(message);
		
		logger.info("메일 전송 완료! ");
	}

}
