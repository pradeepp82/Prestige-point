package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.AssignmentDoc;
import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.AssignmentService;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.AssignmentValidator;

@Controller
public class AssignmentController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private BatchService batchService;

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@Autowired
	private AssignmentService assignmentService;

	@Autowired
	private AssignmentValidator assignmentValidator;

	@RequestMapping("/assignmentView")
	private String showAssignmentPage(Map<String, Object> map, ModelMap model,
			@RequestParam(required = false) String message) {
		map.put("AssignmentDoc", new AssignmentDoc());
		model.addAttribute("message", message);
		List<AddAssignment> assignment = assignmentService.getAllAssignment();
		model.addAttribute("assignmentList", assignment);
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		List<Batch> batchList = batchService.getAllBatchName();
		model.addAttribute("batchList", batchList);
		return "assignmentView";
	}

	@RequestMapping(value = "/saveAssignment.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String saveAssignment(@ModelAttribute("AssignmentDoc") AssignmentDoc assignmentDoc,
			@RequestParam("fileUpload") MultipartFile file, ModelMap model,
			@RequestParam CommonsMultipartFile[] fileUpload, String assignmentDocName, BindingResult result,
			@RequestParam(required = false) Integer assignmentId) {
		final MultipartFile filePart = file;
		boolean status = false;
		file.getOriginalFilename();
		List<AddAssignment> assignment = assignmentService.getAllAssignment();
		assignmentValidator.validate(assignmentDoc, result);
		if (result.hasErrors()) {
			model.addAttribute("assignmentList", assignment);
			List<Subject> subjects = questionAnswerService.getAllSubjectName();
			if (subjects != null) {
				model.addAttribute("subjectList", subjects);
			}
			return "assignmentView";
		}
		status = assignmentService.saveAssignment(assignmentDocName, filePart, fileUpload, assignmentDoc, assignmentId);
		if (status) {
			model.addAttribute("message", IConstant.ASSIGNMENT_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.ASSIGNMENT_SUCCESS_MESSAGE);
		}
		return "redirect:/assignmentView.do";
	}

	@RequestMapping(value = "/getAssignmentEmailId.do", method = RequestMethod.GET)
	@ResponseBody
	private boolean getAssignmentEmailId(@ModelAttribute("AssignmentDoc") AssignmentDoc assignmentDoc,
			Map<String, Object> map, ModelMap model, @RequestParam(required = false) String batchId, String subject,
			String description, Integer assignmentId,String topic) throws MessagingException {
		boolean status = false;
		status = assignmentService.getAllEmailId(batchId, subject, description, assignmentId);
		if(status==true){
			return true;
		}else{
		return false;
		}
	}
	
	@RequestMapping(value = "/editAssignment")
	public String editAssignmentDetails(@ModelAttribute("AssignmentDoc") AssignmentDoc assignmentDoc,
			Map<String, Object> map, @RequestParam(required = false) Integer assignmentId,ModelMap model) {
		assignmentDoc = assignmentService.editAssignmentDetails(assignmentId);
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		if(assignmentDoc!=null){
		map.put("AssignmentDoc", assignmentDoc);
		}
		model.addAttribute("subjectList", subjects);
		return "assignmentView";
	}
	
	@RequestMapping(value = "/deleteAssignment", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteAssignment(@RequestParam(required = false) Integer assignmentId,ModelMap model) {
		assignmentService.deleteAssignment(assignmentId);
		model.addAttribute("message", IConstant.ASSIGNMENT_DELETE_MESSAGE);
		return "redirect:/assignmentView.do";
	}
}
