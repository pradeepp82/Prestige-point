package com.aartek.prestigepoint.controller.ws;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.ProfileService;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class ChangePasswordWSController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> forgotPassword(@RequestBody Registration registration,
			HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Registration reg = registrationService. getStudentDetails(registration.getEmailId());
		if (reg ==null) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.ERROR_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.PASSWORD, reg.getPassword());
			map.put(IConstant.MESSAGE, IConstant.PASSWORD_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getStudentEmiDetails(@RequestBody Registration registration,
			HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = false;
		 status = profileService.studentChangePassword(registration);
		if (status ==false) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.CHECK_PASSWORD);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.CHANGE_PASSWORD_MESSAGE);
		}
		return map;
	}
}
