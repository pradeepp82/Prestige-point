package com.aartek.prestigepoint.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Meenal Pathre
 *
 */
@Controller
public class LoginController {

	private static final Logger log = Logger.getLogger(LoggingInterceptor.class);

	@Autowired
	private LoginService loginService;

	/**
	 * Display login page.
	 * 
	 * @param map
	 * @param model
	 * @param invalid
	 * @return
	 */
	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map, Model model, @RequestParam(required = false) String invalid,
			@RequestParam(required = false) String forgotMessage) {
		map.put("AdminLogin", new AdminLogin());
		model.addAttribute("forgotMessage", forgotMessage);
		model.addAttribute("invalid", invalid);
		log.info("--------------login Controller----------");
		return "login";

	}

	/**
	 * Action for user is valid or invalid(login)
	 * 
	 * @param login
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public String signInAction(@ModelAttribute("AdminLogin") AdminLogin login, ModelMap model,
			HttpServletRequest request) {
		login = loginService.userSignIn(login);
		if (login == null) {
			model.addAttribute("invalid", IConstant.LOGIN_FAILURE_MESSAGE);
			return "redirect:/login.do";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			return "redirect:/welcome.do";
		}
	}

	/**
	 * Show welcome page
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/welcome")
	public String showWelcomePage(Map<String, Object> map, Model model) {
		return "welcome";
	}

	/**
	 * Method for logout.
	 * 
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String showLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login.do";
	}
}
