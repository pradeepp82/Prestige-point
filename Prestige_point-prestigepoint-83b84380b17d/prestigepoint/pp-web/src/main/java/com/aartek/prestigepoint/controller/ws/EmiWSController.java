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
import com.aartek.prestigepoint.service.EmiService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class EmiWSController {

	@Autowired
	private EmiService emiService;

	@RequestMapping(value = "/getStudentEmiDetails", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getStudentEmiDetails(@RequestBody Registration registration,
			HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Registration emidetails = emiService.getUserFeesDetails(registration.getRegistrationId());
		if (emidetails ==null) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.INVALID_DETAILS);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.DATA, emidetails);
			map.put(IConstant.MESSAGE, IConstant.STUDENT_DETAILS_MESSAGE);
		}
		return map;
	}
}
