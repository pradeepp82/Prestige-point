package com.aartek.prestigepoint.controller.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
import com.aartek.prestigepoint.util.ImageFormatWS;

@Controller
public class LoginWSController {

	@Autowired
	private StudentRegistrationService stuRegService;
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> userLogin(@RequestBody Registration registration,
			HttpServletResponse response) throws IOException {
		Map<Object, Object> map = new HashMap<Object, Object>();
		 Registration userRegistration = stuRegService.userLogin(registration);
		 if(userRegistration!=null){
		 String imagePath = ImageFormatWS.readImage(userRegistration.getRegistrationId(),userRegistration.getImagePath());
		 userRegistration.setImagePath(imagePath);
		 }
		if (userRegistration==null) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.FAILUR_GCM_MESSAGE);
		} else {
			userRegistration.setAddPlacedStudentList(null);
			userRegistration.setEmiList(null);
			userRegistration.setCurrentStatus(null);
			userRegistration.setCourse(null);
			userRegistration.setYear(null);
			userRegistration.setReference(null);
			userRegistration.setBatch(null);
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.DATA, userRegistration);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_GCM_MESSAGE);
		}
		return map;
	}
	
	/*@RequestMapping(value = "/studentsImage", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> studentsImage(@RequestBody Registration registration,
			HttpServletResponse response) throws IOException {
		Map<Object, Object> map = new HashMap<Object, Object>();
        List<Registration> studentImages = stuRegService.getAllStudentImages();
		if (studentImages==null) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.DATA, studentImages);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
		}
		return map;
	}*/
}
