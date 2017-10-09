package com.aartek.prestigepoint.controller;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.service.EnquiryService;

@Controller
public class EnquiryController {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EnquiryController.class);
	@Autowired
	private EnquiryService enquiryService;

	/**
	 * Add Enquiry into database.
	 * 
	 * @param enquiry
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/enquiryAction", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(Enquiry enquiry, BindingResult result, ModelMap model, Map<String, Object> map,
			HttpServletRequest request) throws ParseException {
		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String comment = request.getParameter("comment");
		String mobileNo = request.getParameter("mobileNo");
		String returnText;
		enquiry.setEmailId(emailId);
		enquiry.setName(name);
		enquiry.setComment(comment);
		enquiry.setMobileNo(mobileNo);
		enquiryService.saveEnquiryMessage(enquiry);
		returnText = "Feedback has been added";
		return returnText;
	}
}
