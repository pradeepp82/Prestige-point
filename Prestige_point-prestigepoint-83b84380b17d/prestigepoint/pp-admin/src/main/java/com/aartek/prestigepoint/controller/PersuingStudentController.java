/*package com.aartek.prestigepoint.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.PersuingStudent;
import com.aartek.prestigepoint.service.PersuingStudentService;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unused")
@Controller
public class PersuingStudentController {

	
	private static final Logger log = Logger.getLogger(PersuingStudentController.class);

	@Autowired
	private PersuingStudentService persuingStudentService;

	@Autowired
	private PersuingStudentValidator persuingStudentValidator;

	@RequestMapping("/persuingStudent")
	public String showPersuingStudentPage(Model model,Map<String, Object> map, @RequestParam(required = false) String message
			,String firstName,String lastName,String emailId,String qualification,String contact,String collageName) {
		 map.put("PersuingStudent",new PersuingStudent());
		model.addAttribute("message", message);
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("emailId", emailId);
		model.addAttribute("qualification", qualification);
		model.addAttribute("contact", contact);
		model.addAttribute("collageName", collageName);
		   
		List<PersuingStudent> persuingStudentList = persuingStudentService.getAllPersuingStudent();
		if (persuingStudentList != null) {
			model.addAttribute("persuingStudentList", persuingStudentList);
		}
		return "persuingStudent";
		else{
			return null;
		}
		return "persuingStudent";
	}

	
	@RequestMapping(value = "/savePersuingStudentDetails.do",method = {RequestMethod.GET, RequestMethod.POST})
	public String savePersuingStudentDetail(@ModelAttribute("PersuingStudent") PersuingStudent persuingStudent,
			Model model, BindingResult result) throws ParseException {
		boolean status = false;
		persuingStudentValidator.validate(persuingStudent, result);
		if (result.hasErrors()) {
			return "persuingStudent";
		}
		status = persuingStudentService.savePersuingStudentDetail(persuingStudent);
		if (status) {
			model.addAttribute("message", IConstant.PERSUING_STUDENT_DETAIL_SAVE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.PERSUING_STUDENT_DETAIL_SAVE_FAILURE_MESSAGE);
		}
		return "redirect:/persuingStudent.do";
	}

	@RequestMapping(value = "/editPersuingStudent.do", method = { RequestMethod.GET })
	public String updatePersuingStudentDetail(@ModelAttribute("PersuingStudent") PersuingStudent persuingStudent,
			Map<String, Object> map, Model model, @RequestParam(required = false) Integer persuingStudentId) {
		persuingStudent = persuingStudentService.updatePersuingStudentDetail(persuingStudentId);
		boolean status= false;
		if (persuingStudent != null) {
			map.put("PersuingStudent", persuingStudent);
			if(status){
			model.addAttribute("message", IConstant.PERSUING_STUDENT_SUCCESS_UPDATE_MESSAGE);
		}else{
			model.addAttribute("message", IConstant.PERSUING_STUDENT_FAILIURE_UPDATE_MESSAGE);
			}
		}
		return "persuingStudent";
	}
	
	@RequestMapping(value = "/deletePersuingStudent.do", method = { RequestMethod.GET })
	public String deletePersuingStudentDetail(@RequestParam(required = false) Integer persuingStudentId, Model model,
			String message) {
		persuingStudentService.deletePersuingStudentDetail(persuingStudentId);
		model.addAttribute("message", IConstant.PERSUING_STUDENT_SUCCESS_DELETE_MESSAGE);
		return "redirect:/persuingStudent.do";
	}

}*/