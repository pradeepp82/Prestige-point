package com.aartek.prestigepoint.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlacedStudentEmiController {
	
	private static final Logger log = Logger.getLogger(PlacedStudentEmiController.class);
	
	@RequestMapping("/getPlacedStudentEmiDetails")
	private String getPlacedStudentEmiDetail(Map<String, Object> map, ModelMap model,@RequestParam(required = false) Integer placedStudentId) {
		

		return "placedStudentEmi";
	}
	
	

}
