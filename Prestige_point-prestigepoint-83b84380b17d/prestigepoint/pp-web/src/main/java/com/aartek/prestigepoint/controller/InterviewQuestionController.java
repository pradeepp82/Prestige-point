package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.QuestionAnswerService;

@Controller
public class InterviewQuestionController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(InterviewQuestionController.class);

	@Autowired
	private QuestionAnswerService questionAnswerService;

	/**
	 * show interview question answer page
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/interviewQuestion")
	public String showInterviewQuestionPage(Map<String, Object> map, Model model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		return "interviewQuestion";
	}

	/**
	 * get question and answer according to subject.
	 * 
	 * @param questionAnswer
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value = "/QuestionAndAnswer", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBatchInfo(@ModelAttribute("QuestionAnswer") QuestionAnswer questionAnswer, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) Integer subjectId) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		List<QuestionAnswer> questionAndAnswerList= questionAnswerService.getQuestionAndAnswer(subjectId);
		model.addAttribute("questionAndAnswerList", questionAndAnswerList);
		return "interviewQuestion";
	}

}
