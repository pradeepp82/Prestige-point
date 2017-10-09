package com.aartek.prestigepoint.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.BatchAssignment;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.AssignmentService;
@Controller
public class ViewAssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	
	@Value("${pp.DownloadAssignmentDoc}")
	private String DownloadAssignmentDoc;
	
	@RequestMapping("/viewAssignment")
	private String AddAssignment(Map<String, Object> map,ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		map.put("BatchAssignment", new BatchAssignment());
		Registration registration = (Registration) request.getSession().getAttribute("registration");
		Integer batchId = registration.getBatch().getBatchId();
	    if (batchId != null) {
		List<AddAssignment> getAssignment = assignmentService.viewAssignmentDetails(batchId);
		model.addAttribute("getAssignmentList", getAssignment);
	}
		return "viewAssignment";
	
}
	
	@RequestMapping(value = "/displyTopicDetails")
	public String getAllTopic(@RequestParam(required = false) Integer subjectId,ModelMap model) {
		List<AddAssignment> getAllTopic = assignmentService.getAllTopic(subjectId);
		model.addAttribute("getAllTopicList", getAllTopic);
		return "displyTopicDetails";

	}
	
	@RequestMapping(value = "/displyAllDetailsBatchWise")
	public String displyAllDetailsBatchWise(@ModelAttribute("AddAssignment") AddAssignment addAssignment,
			Map<String, Object> map, @RequestParam(required = false) Integer assignmentId,ModelMap model) {
		 List<String> docAssignmentName = assignmentService.getAllDocName(assignmentId);
		 model.addAttribute("docAssignmentName", docAssignmentName);
		addAssignment = assignmentService.displyAllDetailsBatchWise(assignmentId);
		map.put("AddAssignment", addAssignment);
		return "displyAllDetailsBatchWise";
	}
	
	@RequestMapping(value = "/displyAndDownloadDoc")
	public void displyAndDownloadDoc(HttpServletResponse response,@RequestParam(required = false) Integer assignmentId,String doc) throws IOException {
				 response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					String filename = doc;
					response.setContentType("APPLICATION/OCTET-STREAM");
					response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
					FileInputStream fileInputStream = new FileInputStream(DownloadAssignmentDoc+assignmentId+"_"+filename);
					int i;
					while ((i = fileInputStream.read()) != -1) {
						out.write(i);
					}
					fileInputStream.close();
					out.close();
				}
	}

