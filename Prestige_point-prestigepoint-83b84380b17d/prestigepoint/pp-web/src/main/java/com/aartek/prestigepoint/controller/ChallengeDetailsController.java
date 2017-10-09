package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.service.ChallengeService;
import com.aartek.prestigepoint.service.QuestionAnswerService;

/**
 * 
 * @author Meenal pathre
 *
 */
@Controller
public class ChallengeDetailsController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChallengeDetailsController.class);
	
	@Autowired
	private ChallengeService addChallengeService;
	
	@Autowired
	private QuestionAnswerService questionAnswerService;

	/**
	 * use for disply the jsp of ChallengeDetails
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */
	@RequestMapping("/viewChallengeDetails")
	private String addChallenge(Map<String, Object> map, ModelMap model, @RequestParam(required = false) String message) {
		map.put("AddChallenge", new AddChallenge());
		List<Subject> subjects = questionAnswerService.getAllSubjectName();
		model.addAttribute("subjectList", subjects);
		List<AddChallenge> getChallengeDetails = addChallengeService.viewChallengeDetails();
		model.addAttribute("allAddChallengeList", getChallengeDetails);
		model.addAttribute("message", message);
		return "viewChallengeDetails";
	}

	/**
	 * use for view the ChallengeList
	 * 
	 * @param addChallenge
	 * @param model
	 * @param map
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/displyChallengeDetails")
	public String viewChallengeList(@ModelAttribute("AddChallenge") AddChallenge addChallenge, ModelMap model,
			Map<String, Object> map, @RequestParam(required = false) Integer challengeId) {
		addChallenge = addChallengeService.editChallengeDetails(challengeId);
		map.put("AddChallenge", addChallenge);
		return "displyChallengeDetails";

	}
}
