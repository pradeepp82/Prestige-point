/*package com.aartek.prestigepoint.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/sendMailAction.do")
public class SendEmailAttachController {
	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(method = RequestMethod.POST)
	public String sendEmail(final @RequestParam CommonsMultipartFile attachFile,
			@RequestParam(required = false) String subject, String message, String emailId) {

		// reads form input

		final String emailTo = emailId;
		final String subject1 = subject;
		final String message1 = message;

		// for logging
		System.out.println("emailTo: " + emailTo);
		System.out.println("subject: " + subject1);
		System.out.println("message: " + message1);
		System.out.println("attachFile: " + attachFile.getOriginalFilename());

		mailSender.send(new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setTo(emailTo);
				messageHelper.setSubject(subject1);
				messageHelper.setText(message1);
				messageHelper.setFrom("hrd@prestigepoint.in");
				// determines if there is an upload file, attach it to the
				// e-mail
				String attachName = attachFile.getOriginalFilename();
				if (!attachFile.equals("")) {

					messageHelper.addAttachment(attachName, new InputStreamSource() {

						public InputStream getInputStream() throws IOException {
							return attachFile.getInputStream();
						}
					});
				}

			}

		});

		return "mailSuccess";
	}
}*/