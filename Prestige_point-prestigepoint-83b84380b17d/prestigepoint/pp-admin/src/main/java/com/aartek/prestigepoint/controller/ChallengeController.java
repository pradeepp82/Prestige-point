package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.service.ChallengeService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Meenal
 *
 */
@Controller
public class ChallengeController {

	private static final Logger logger = Logger.getLogger(ChallengeController.class);

	@Autowired
	private ChallengeService challengeService;

	/**
	 * display addChallenge jsp for add Challenge.
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @return
	 */

	@RequestMapping("/challenge")
	private String showChallengePage(Map<String, Object> map, ModelMap model,
			@RequestParam(required = false) String message) {
		logger.info("start the showChallengePage method !");
		map.put("AddChallenge", new AddChallenge());
		List<AddChallenge> getAllchallenge = challengeService.getAllchallenge();
		model.addAttribute("getAllchallenge", getAllchallenge);
		model.addAttribute("message", message);
		return "challenge";
	}

	/**
	 * Use for save ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @return
	 */

	@RequestMapping(value = "/saveChallenge.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String saveChallenge(@ModelAttribute("AddChallenge") AddChallenge addChallenge, ModelMap model,
			BindingResult result) {
		if (addChallenge.getChallengeId() != null) {
			challengeService.saveChallenge(addChallenge);
			model.addAttribute("message", IConstant.CHALLENGE_UPDATE_MESSAGE);
		} else {
			challengeService.saveChallenge(addChallenge);
			model.addAttribute("message", IConstant.CHALLENGE_SUCCESS_MESSAGE);
		}
		return "redirect:/challenge.do";
	}

	/**
	 * Use for update ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @param map
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/editChallenge")
	public String editChallengeDetails(@ModelAttribute("AddChallenge") AddChallenge addChallenge,
			Map<String, Object> map, @RequestParam(required = false) Integer challengeId) {
		addChallenge = challengeService.editChallengeDetails(challengeId);
		map.put("AddChallenge", addChallenge);
		return "challenge";
	}

	/**
	 * Use for delete ChallengeInformation.
	 * 
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/deleteChallenge", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteChallenge(@RequestParam(required = false) Integer challengeId,ModelMap model) {
		challengeService.deleteChallenge(challengeId);
		model.addAttribute("message", IConstant.CHALLENGE_DELETE_MESSAGE);
		return "redirect:/challenge.do";
	}

	/**
	 * Use for view the ChallengeInformation.
	 * 
	 * @param addChallenge
	 * @param model
	 * @param map
	 * @param challengeId
	 * @return
	 */
	@RequestMapping(value = "/getChallengeDetails")
	public String getChallengeDetails(@ModelAttribute("AddChallenge") AddChallenge addChallenge,
			Map<String, Object> map, @RequestParam(required = false) Integer challengeId) {
		addChallenge = challengeService.editChallengeDetails(challengeId);
		map.put("AddChallenge", addChallenge);
		return "viewChallenge";
	}

	/**
	 * Use for ActiveStatus.
	 * 
	 * @param challengeIdValue
	 * @param challengeValue
	 */
	@RequestMapping(value = "activeChallengeStatus", method = RequestMethod.GET)
	@ResponseBody
	public void activeChallengeStatus(@RequestParam(required = false) String challengeIdValue, Integer challengeValue) {
		challengeService.changeChallengeStatus(challengeIdValue, challengeValue);
	}
}
