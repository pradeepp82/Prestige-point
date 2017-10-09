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
public class LogoutWSController {

	@Autowired
	private StudentRegistrationService stuRegService;

	@RequestMapping(value = "/userLogout", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> userLogout(@RequestBody Registration registration,
			HttpServletResponse response) {
		boolean status = false;
		Map<Object, Object> map = new HashMap<Object, Object>();
		status = stuRegService.userIdVerify(registration);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_LOGOUT_MESSAGE);

		} else {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.FAILUR_LOGOUT_MESSAGE);
		}
		return map;
	}

}
