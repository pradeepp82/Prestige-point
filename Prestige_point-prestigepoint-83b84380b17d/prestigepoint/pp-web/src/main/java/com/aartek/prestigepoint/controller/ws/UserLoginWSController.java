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
import com.aartek.prestigepoint.service.StudentRegistrationService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class UserLoginWSController {

	@Autowired
	private StudentRegistrationService stuRegistrationService;
	
	@RequestMapping(value = "/getStudentLoginDetail" , method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getStudentLoginDetail(@RequestBody Registration registration,
					HttpServletResponse response)
	{
		Map<Object, Object> map = new HashMap<Object, Object>();
		registration = stuRegistrationService.stuSignIn(registration);
		if (registration != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, registration);
			map.put(IConstant.MESSAGE, IConstant.STUDENT_LOGIN_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, registration);
			map.put(IConstant.MESSAGE, IConstant.STUDENT_INVALID_LOGIN);
		}
		return map;
	}
	
	@RequestMapping(value = "/getStudentLogin", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getStudentLogin(@RequestBody Registration registration,
					HttpServletResponse response)
	{
		Map<Object, Object> map = new HashMap<Object, Object>();
		int registrationId;
		registrationId = stuRegistrationService.getStudentLogin(registration);
		if (registrationId == 0) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, registrationId);
			map.put(IConstant.MESSAGE, IConstant.STUDENT_INVALID_LOGIN);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, registrationId);
			map.put(IConstant.MESSAGE, IConstant.STUDENT_LOGIN_MESSAGE);
		}
		return map;
	}
}
