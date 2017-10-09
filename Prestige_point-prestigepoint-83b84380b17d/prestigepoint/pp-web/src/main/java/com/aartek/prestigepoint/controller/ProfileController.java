package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.EmiService;
import com.aartek.prestigepoint.service.ProfileService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.ProfileValidator;

@Controller
public class ProfileController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ProfileController.class);

	@Autowired
	private ProfileService profileService;

	@Autowired
	private EmiService emiService;

	@Autowired
	private ProfileValidator profileValidator;

	@Autowired
	private QuestionAnswerService questionAnswerService;

	/**
	 * Show profile page
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/viewProfile")
	public String showProfilePage(Map<String, Object> map, Model model, HttpServletRequest request,
			@RequestParam(required = false) String message) {
		HttpSession session = request.getSession();
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		Registration registration = (Registration) session.getAttribute("registration");
		List<Registration> registrations = profileService.getStudentDetails(registration.getRegistrationId());
		List<Emi> emiList = emiService.getFeesDetails(registration.getRegistrationId());
		model.addAttribute("detailsList", registrations);
		model.addAttribute("emiList", emiList);
		model.addAttribute("message", message);
		return "viewProfile";
	}

	/**
	 * Show edit page for update student details
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param registrationId
	 * @return
	 */
	@RequestMapping(value = "/editProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBatchInfo(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) Integer registrationId) {
		List<Registration> registrations = profileService.getStudentDetails(registrationId);
		for (Object object : registrations) {
			registration = (Registration) object;
		}
		map.put("Registration", registration);
		return "editStudentDetails";
	}

	/**
	 * Action for update student profile.
	 * 
	 * @param registration
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/editProfileUser", method = { RequestMethod.GET, RequestMethod.POST })
	public String addStudent(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request) {
		profileValidator.validate(registration, result);
		if (result.hasErrors()) {
			return "editStudentDetails";
		}
		if (registration!= null) {
			boolean status = false;
			status = profileService.updateProfile(registration);
			if (status) {
				model.addAttribute("message", IConstant.PROFILE_UPDATE_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.PROFILE_UPDATE_FAILURE_MESSAGE);
			}
		}
		return "redirect:/viewProfile.do";

	}
	
	@RequestMapping(value = "/changePassword")
	public String changePassword(@ModelAttribute("Registration") Registration registration,Map<String, Object> map, Model model) {
		return "changePassword";
	}
	
	@RequestMapping(value = "/saveChangePassword", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveChangePassword(@ModelAttribute("Registration") Registration registration,@RequestParam(required = false) Integer registrationId,ModelMap model) {
		if (registration!= null) {
			boolean status = false;
			status = profileService.saveChangePassword(registration);
			if (status) {
				model.addAttribute("message", IConstant.CHANGE_PASSWORD_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.CHANGE_PASSWORD_FAILUR_MESSAGE);
			}

	}
		return "redirect:/viewProfile.do";
}
}