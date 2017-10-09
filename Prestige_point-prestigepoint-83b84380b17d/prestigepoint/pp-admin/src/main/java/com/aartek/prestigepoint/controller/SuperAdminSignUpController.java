package com.aartek.prestigepoint.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.SignUpValidator;
/**
 * 
 * @author meenal pathre
 *
 */
@Controller
public class SuperAdminSignUpController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(SuperAdminSignUpController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private SignUpValidator signUpValidator;

	/**
	 * Display signup page.
	 * 
	 * @param map
	 * @param model
	 * @param invalid
	 * @return
	 */
	@RequestMapping("/signup")
	public String showSignUp(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		map.put("AdminLogin", new AdminLogin());
		model.addAttribute("message", message);
		return "signup";
	}

	/**
	 * use for SingUp
	 * 
	 * @param login
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/adminsignup")
	public String adminSignUp(@ModelAttribute("AdminLogin") AdminLogin login, BindingResult result, ModelMap model) {
		boolean status = false;
		signUpValidator.validate(login, result);
		if (result.hasErrors()) {
			return "signup";
		}
		if (login != null && !login.equals("null")) {
			status = loginService.signUp(login);
			if (status) {
				model.addAttribute("message", IConstant.USER_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.USER_FAILURE_MESSAGE);
			}
			return "redirect:/signup.do";
		} else {
			return "redirect:/signup.do";
		}
	}
}
