package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.ForgotPasswordService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.ForgotPasswordValidator;

@Controller
public class ForgotPasswordController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ForgotPasswordController.class);
	@Autowired
	private ForgotPasswordService forgotPasswordService;

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@Autowired
	private ForgotPasswordValidator forgotPasswordValidator;

	/**
	 * Show forgot password page.
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
	public String forgotPassword(Map<String, Object> map, Model model,
			@RequestParam(required = false) String forgotMessage) {
		map.put("Registration", new Registration());
		model.addAttribute("forgotMessage", forgotMessage);
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		return "forgotPassword";
	}

	/**
	 * Method use for get password if user registered.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/userForgotPassword", method = { RequestMethod.GET, RequestMethod.POST })
	public String verify(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request) {
		boolean status = false;
		forgotPasswordValidator.validate(registration, result);
		if (result.hasErrors()) {
			return "forgotPassword";
		}
		status = forgotPasswordService.getPassword(registration.getEmailId());
		if (status) {
			model.addAttribute("forgotMessage", IConstant.FORGOT_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("forgotMessage", IConstant.FORGOT_FAIL_MESSAGE);
		}
		return "redirect:/login.do";
	}
}