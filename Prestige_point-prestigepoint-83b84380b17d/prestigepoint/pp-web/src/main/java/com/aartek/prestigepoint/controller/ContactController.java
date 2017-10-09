package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.ContactService;
import com.aartek.prestigepoint.service.FooterPhotoService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.UserEnquiryValidator;

/**
 * 
 * @author Dell
 *
 */
@Controller
public class ContactController {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ContactController.class);
	@Autowired
	private ContactService contactService;

	@Autowired
	private UserEnquiryValidator enquiryValidator;

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@Autowired
	private FooterPhotoService footerPhotoService;

	/**
	 * use for view the jsp of contactUs
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */
	@RequestMapping("/contactUs")
	public String showcontactUsPage(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		model.addAttribute("message", message);
		List<Subject> subjects = null;

		subjects = questionAnswerService.getAllSubjectName();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("subjectList", subjects);
		map.put("Enquiry", new Enquiry());
		return "contactUs";
	}

	/**
	 * use for add the contact information
	 * 
	 * @param enquiry
	 * @param result
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContact(@ModelAttribute("Enquiry") Enquiry enquiry, BindingResult result, ModelMap model,
			Map<String, Object> map) {
		boolean status = false;
		enquiryValidator.validate(enquiry, result);
		if (result.hasErrors()) {
			return "contactUs";
		}
		status = contactService.saveContact(enquiry);
		if (status) {
			model.addAttribute("message", IConstant.CONTACTUS_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.CONTACTUS_FAILURE_MESSAGE);
		}
		return "redirect:/contactUs.do";
	}

}
