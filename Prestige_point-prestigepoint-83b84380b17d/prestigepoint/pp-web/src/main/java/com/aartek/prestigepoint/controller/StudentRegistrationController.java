/**
 * 
 */
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.service.FooterPhotoService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.service.StudentRegistrationService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.StudentRegistrationValidator;

/**
 * @author deepak
 * 
 */
@Controller
public class StudentRegistrationController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(StudentRegistrationController.class);
	@Autowired
	private StudentRegistrationService stuRegService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentRegistrationValidator registrationValidator;

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@Autowired
	private FooterPhotoService footerPhotoService;

	@RequestMapping("/stuRegistration")
	public String showStuRegistrationPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String message, HttpServletRequest request) {
		map.put("Registration", new Registration());
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		List<Course> courseList = courseService.getCourses();
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		model.addAttribute("course", courseList);
		List<Year> yearList = courseService.getAllYearName();
		model.addAttribute("year", yearList);
		model.addAttribute("message", message);
		return "stuRegistration";
	}

	@RequestMapping(value = "/registration", method = { RequestMethod.GET, RequestMethod.POST })
	public String signUp(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request) {
		boolean status = false;
		if (registration != null && !registration.equals("null")) {
		registrationValidator.validate(registration, result);
		if (result.hasErrors()) {
			List<Course> courseList = courseService.getCourses();
			model.addAttribute("course", courseList);
			List<Year> yearList = courseService.getAllYearName();
			model.addAttribute("year", yearList);
			return "stuRegistration";
		}
		status = stuRegService.saveStudent(registration);
		if (status) {
			model.addAttribute("message", IConstant.REGISTRATION_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.REGISTRATION_FAILURE_MESSAGE);
		}
		return "redirect:/stuRegistration.do";
	}else{
		return "redirect:/stuRegistration.do";
	}
	}
	

	@RequestMapping(value = "/verify", method = { RequestMethod.GET, RequestMethod.POST })
	public String verifyUser(@ModelAttribute("Registration") Registration registration, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) Integer registrationId) {
		registration = stuRegService.editStuRegs(registrationId);
		return "redirect:/login.do";
	}

	@RequestMapping(value = "/verifyUserEmailId", method = { RequestMethod.GET })
	@ResponseBody
	public boolean verifyUserEmailId(@RequestParam(required = false) String emailId) {
		boolean status = false;
		status = stuRegService.verifyUserEmailId(emailId);
		return status;

	}

}
