/**
 * 
 */
package com.aartek.prestigepoint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.ForumAnswer;
import com.aartek.prestigepoint.model.ForumQuestion;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.ForumAnswerService;
import com.aartek.prestigepoint.service.ForumQuestionService;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author deepak
 * 
 */
@Controller
public class ForumController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ForumController.class);

	@Autowired
	private ForumQuestionService forumQuestionService;

	@Autowired
	private ForumAnswerService forumAnswerService;

	static List<ForumQuestion> questionList = null;

	@Autowired
	private QuestionAnswerService questionAnswerService;
	/**
	 * This method is used for displaying forum page
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/forum", method = { RequestMethod.GET, RequestMethod.POST })
	public String forum(@ModelAttribute("ForumAnswer") ForumAnswer forumAnswer, Map<String, Object> map,
			ModelMap model, @RequestParam(required = false) String message, Integer forumAnswerId,
			Integer forumQuestionId, HttpServletRequest request, HttpServletResponse response) {
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		if (forumAnswerId != null && forumQuestionId == null) {
			forumAnswer = forumAnswerService.updateAnswer(forumAnswerId);
			model.put("ForumAnswer", forumAnswer);
			model.addAttribute("questionList", questionList);
		} else {
			map.put("ForumAnswer", new ForumAnswer());
			questionList = forumQuestionService.getAllQuestion();
			model.addAttribute("questionList", questionList);
			return "forum";
		}
		return "forum";
	}

	@RequestMapping(value = "/usersQueriesReviews", method = { RequestMethod.GET, RequestMethod.POST })
	public String userAnswersViews(@ModelAttribute("ForumAnswer") ForumAnswer forumAnswer, BindingResult result,
			ModelMap model, Map<String, Object> map, @RequestParam(required = false) String message) {
		if (forumAnswer.getForumQuestion().getForumQuestionId() == null) {
			questionList = forumQuestionService.findQuestion(forumAnswer.getForumQuestion());
			model.addAttribute("questionList", questionList);
		} else {
			boolean status = false;
			status = forumAnswerService.addAnswer(forumAnswer);
			if (status) {
				model.addAttribute("message", IConstant.FORUM_SUCCESS_MESSAGE);
			} else {
				model.addAttribute("message", IConstant.FORUM_FAILURE_MESSAGE);
			}
			map.put("ForumAnswer", new ForumAnswer());
			return "redirect:/forum.do";
		}

		return "forum";
	}

	/**
	 * this method is used to view the Ask Queries Page
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/askQueries", method = RequestMethod.GET)
	public String askQueries(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		List<ForumQuestion> forumList = null;
		map.put("ForumQuestion", new ForumQuestion());
		forumList = forumQuestionService.getAllSubjects();
		model.addAttribute("forumList", forumList);
		model.addAttribute("message", message);
		return "askQueries";
	}

	@RequestMapping(value = "/askQuestions", method = RequestMethod.POST)
	public String askQuestions(@ModelAttribute("ForumQuestion") ForumQuestion forumQuestion, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
		map.put("ForumAnswer", new ForumAnswer());
		boolean status = false;
		status = forumQuestionService.addQuestion(forumQuestion);
		if (status) {
			model.addAttribute("message", IConstant.FORUM_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.FORUM_FAILURE_MESSAGE);
		}

		model.put("ForumQuestion", new ForumQuestion());
		return "redirect:/forum.do";
	}

	@RequestMapping(value = "/searchQuestion", method = RequestMethod.GET)
	@ResponseBody
	public List<ForumQuestion> searchQuestion(@RequestParam String searchValue) {
		List<ForumQuestion> searchList = new ArrayList<ForumQuestion>();
		if (!searchValue.isEmpty()) {
			searchList = forumQuestionService.searchAllQuestion(searchValue);
		}
		return searchList;
	}

}
