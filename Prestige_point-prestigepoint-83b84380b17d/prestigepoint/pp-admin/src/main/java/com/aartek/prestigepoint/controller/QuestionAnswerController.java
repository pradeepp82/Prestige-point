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

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.QuestionAndAnswerValidator;

@Controller
public class QuestionAnswerController {

	private static final Logger log = Logger.getLogger(QuestionAnswerController.class);

	@Autowired
	private QuestionAnswerService questionAnswerService;

	@Autowired
	private QuestionAndAnswerValidator questionAndAnswerValidator;

	/**
	 * show question answer page
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/questionAndAnswer")
	public String questionAndAnswer(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		map.put("QuestionAnswer", new QuestionAnswer());
		model.addAttribute("message", message);
		List<QuestionAnswer> questionAnswerList = questionAnswerService.getAllQuestionAswerList();
		model.addAttribute("questionAnswerList", questionAnswerList);
		return "questionAndAnswer";
	}

	@RequestMapping(value = "/saveQuestionAnwser", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveQuestionAnwser(@ModelAttribute("QuestionAnswer") QuestionAnswer questionAnswer,
			BindingResult result, ModelMap model) {
		boolean status = false;
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		if (questionAnswer != null && !questionAnswer.equals("null")) {
			questionAndAnswerValidator.validate(questionAnswer, result);
			if (result.hasErrors()) {
				model.addAttribute("subjectList", subjects);
				return "questionAndAnswer";
			}
			status = questionAnswerService.saveQuestionAndAnswer(questionAnswer);
			if (status) {
				model.addAttribute("message", "Your question answer add successfully");
			} else {
				model.addAttribute("message", "Please try again");
			}
			return "redirect:/questionAndAnswer.do";
		} else {
			return "redirect:/questionAndAnswer.do";
		}
	}

	@RequestMapping("/differenceQuestionAndAnswer")
	public String showDiffernceQuestionPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String message) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		map.put("QuestionAnswer", new QuestionAnswer());
		model.addAttribute("message", message);
		return "differenceQuestion";
	}

	@RequestMapping(value = "/saveDifferenceQuestionAndAnswer", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveDifferenceQuestionAndAnswer(@ModelAttribute("QuestionAnswer") QuestionAnswer questionAnswer,
			BindingResult result, ModelMap model) {
		boolean status = false;
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		questionAndAnswerValidator.validate(questionAnswer, result);
		if (result.hasErrors()) {
			model.addAttribute("subjectList", subjects);
			return "differenceQuestion";
		}
		status = questionAnswerService.saveQuestionAndAnswer(questionAnswer);
		if (status) {
			model.addAttribute("message", "Your question answer add successfully");
		} else {
			model.addAttribute("message", "Please try again");
		}
		return "redirect:/differenceQuestionAndAnswer.do";
	}

	@RequestMapping(value = "/deleteQuestionAnswer", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteQuestion(ModelMap model, @RequestParam(required = false) Integer questionId) {
		boolean status = false;
		status = questionAnswerService.deleteQuestion(questionId);
		if (status) {
			model.addAttribute("message", IConstant.QUESTION_SUCCESS_DELETE_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.QUESTION_FAILED_DELETE_MESSAGE);
		}
		return "redirect:/questionAndAnswer.do";
	}

	/*@RequestMapping(value = "/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchQuestion(@ModelAttribute("QuestionAnswer") QuestionAnswer questionAnswer, ModelMap model,
			HttpServletRequest request, @RequestParam(required = false) Integer questionId) {
		String question = request.getParameter("questionAnswer");
		model.addAttribute("question", question);

		List<QuestionAnswer> questionList = questionAnswerService.getsearchQuestion(question);
		model.addAttribute("questionList", questionList);
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);

		log.info("question is=" + question);
		return "questionAndAnswer";
	}*/

	@RequestMapping(value ="getQuestionList", method={RequestMethod.GET, RequestMethod.POST})
	public String getQuestion(@ModelAttribute("QuestionAnswer") QuestionAnswer questionAnswer, ModelMap model) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		  if (questionAnswer.getSubject() != null) {
			  
					if (!(questionAnswer.getSubject().getSubjectId() == 0)
							&& (questionAnswer.getSubject().getSubjectId() != null)) {
						List<QuestionAnswer> questionList = questionAnswerService
								.getSubjectWiseQuestion(questionAnswer
										.getSubject().getSubjectId());
						model.addAttribute("questionList", questionList);
					}
				}
			
			return "questionAndAnswer";
	}
	
}
						