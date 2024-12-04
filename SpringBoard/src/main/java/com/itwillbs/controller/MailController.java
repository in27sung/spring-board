package com.itwillbs.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.MailService;

@Controller
public class MailController {
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Inject
	private MailService mailService;
	
	// http://localhost:8088/sendMail
	// 메일전송
	@RequestMapping(value = "/sendMail",method = RequestMethod.GET)
	public void sendMail() throws Exception{
		logger.info(" 메일 전송 시작! ");
		
		String subject = "메일 테스트 제목";
		String to = "dkdgody00@gmail.com";
		String body = "메일 테스트 내용";
		mailService.sendMail(subject, to, body);	
	}
	
}
