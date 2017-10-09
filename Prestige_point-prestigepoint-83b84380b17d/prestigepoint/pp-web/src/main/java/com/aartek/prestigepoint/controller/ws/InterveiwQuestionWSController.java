package com.aartek.prestigepoint.controller.ws;

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

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class InterveiwQuestionWSController {

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@RequestMapping(value = "/getAllSubject", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getSubject(
			@RequestBody Subject subject, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		if (subjects != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, subjects);
			map.put(IConstant.MESSAGE, IConstant.ALL_SUBJECT_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, subjects);
			map.put(IConstant.MESSAGE, IConstant.NO_SUBJECT_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = "/getQuestionAndAnswerWS", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getQuestionAnswers(
			@RequestBody Subject subject, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<QuestionAnswer> questionAndAnswerList = questionAnswerService
				.getQuestionAndAnswer(subject.getSubjectId());
		if (questionAndAnswerList != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, questionAndAnswerList);
			map.put(IConstant.MESSAGE, IConstant.ALL_QUESTION_ANSWER_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, questionAndAnswerList);
			map.put(IConstant.MESSAGE, IConstant.NO_QUESTION_ANSWER_FOUND);
		}
		return map;
	}
}
