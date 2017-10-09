package com.aartek.prestigepoint.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.model.Mail;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.RegistrationService;

/**
 * 
 * @author Meenal Pathre
 *
 */
@SuppressWarnings("unused")
@Controller
public class MailController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private JavaMailSender mailSender;

	private static Logger log = LoggerFactory.getLogger(MailController.class);

	/**
	 * Display mail sending page
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @param emailId
	 * @return
	 */
	@RequestMapping("/sendMailPage")
	public String showSendMailPage(Map<String, Object> map, Model model, @RequestParam(required = false) String emailId) {
		log.info("this is mailer");// please chnage comment and comment should
									// meaningful
		map.put("Registration", new Registration());
		model.addAttribute("emailId", emailId);
		return "sendMail";
	}

	/**
	 * Use for send mail to particular address or all students or all enquires.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param attachFile
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 */
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public String sendEmail(@ModelAttribute("Mail") Mail mail, final @RequestParam CommonsMultipartFile attachFile)
			throws MessagingException {
		List<String> emailList = new ArrayList<String>();
		final String emailTo = mail.getEmailId();
		final String subject1 = mail.getSubject();
		final String message1 = mail.getMessage();
			if (mail.getAllStudent() != null) {
				if (mail.getAllStudent().equals("allstudent")) {
					emailList = registrationService.getallStudentEmailId();
					final String[] email = emailList.toArray(new String[emailList.size()]);
					InternetAddress[] addressTo = new InternetAddress[email.length];
					for (int i = 0; i < email.length; i++) {
						addressTo[i] = new InternetAddress(email[i]);
					}
					mailSender.send(new MimeMessagePreparator() {
						public void prepare(MimeMessage mimeMessage) throws Exception {
							MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
							messageHelper.setTo(email);
							messageHelper.setSubject(subject1);
							messageHelper.setText(message1);
							messageHelper.setFrom("hrd@prestigepoint.in");
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
				}
			}
		
		if (mail.getAllEnquiry() != null) {
			if (mail.getAllEnquiry().equals("allenquiry")) {
				emailList = registrationService.getallEnquiryEmailId();
				final String[] email = emailList.toArray(new String[emailList.size()]);
				InternetAddress[] addressTo = new InternetAddress[email.length];
				for (int i = 0; i < email.length; i++) {
					addressTo[i] = new InternetAddress(email[i]);
				}
				mailSender.send(new MimeMessagePreparator() {
					public void prepare(MimeMessage mimeMessage) throws Exception {
						MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
						messageHelper.setTo(email);
						messageHelper.setSubject(subject1);
						messageHelper.setText(message1);
						messageHelper.setFrom("hrd@prestigepoint.in");
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
			}
		}
if(mail.getAllStudent() == null && mail.getAllEnquiry() ==null){
		if (!emailTo.isEmpty() && emailTo != null) {
			final String[] email2 = emailTo.split(",");
			mailSender.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					messageHelper.setTo(emailTo);
					messageHelper.setSubject(subject1);
					messageHelper.setText(message1);
					messageHelper.setFrom("hrd@prestigepoint.in");
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
		}
}
		return "redirect:/mailSuccess.do";
	}

	/**
	 * Use for show mail sending success message.
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/mailSuccess")
	public String showSuccessPage(Map<String, Object> map, Model model, HttpServletRequest request) {// change
																										// method
																										// name
		HttpSession session = request.getSession();
		AdminLogin loginMember = (AdminLogin) session.getAttribute("login");
		if (loginMember != null) {
			return "mailSuccess";
		} else {
			return "redirect:/login.do";
		}
	}

	/**
	 * Use for get email address for sending mail.
	 * 
	 * @param model
	 * @param map
	 * @param request
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/getEmailId", method = { RequestMethod.GET, RequestMethod.POST })
	public String sendSingleMail(ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) String emailId) {
		model.addAttribute("emailId", emailId);
		return "redirect:/sendMailPage.do";
	}
}