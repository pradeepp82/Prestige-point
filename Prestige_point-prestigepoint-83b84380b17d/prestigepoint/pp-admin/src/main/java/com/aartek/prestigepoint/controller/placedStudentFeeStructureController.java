package com.aartek.prestigepoint.controller;

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

import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;
import com.aartek.prestigepoint.service.PlacedStudentFeeStructureService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.PlacedStudentFeeStructureValidator;

@Controller
public class placedStudentFeeStructureController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(placedStudentFeeStructureController.class);
	@Autowired
	private PlacedStudentFeeStructureValidator placedStudentFeeStructureValidator;

	@Autowired
	private PlacedStudentFeeStructureService placedStudentFeeStructureService;

	@RequestMapping("/viewPlacedStudentDetail")
	public String showPlacedStudentFeeStructurePage(
					@ModelAttribute("PlacedStudentFeeStructure") PlacedStudentFeeStructure placedStudentFeeStructure,
					Model model, @RequestParam(required = false) String message) {
		model.addAttribute("message", message);
		List<PlacedStudentFeeStructure> placedStudentList = placedStudentFeeStructureService
						.getAllPlacedStudentDetail();
		if (placedStudentList != null) {
			model.addAttribute("placedStudentList", placedStudentList);
		}
		return "viewPlacedStudentDetail";
	}

	@SuppressWarnings("static-access")
	@RequestMapping(value = "/savePlacedStudentDetail.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String savePlacedStudentDetail(
					@ModelAttribute("PlacedStudentFeeStructure") PlacedStudentFeeStructure placedStudentFeeStructure,
					Map<String, Object> map, Model model, BindingResult result) throws ParseException {
		boolean status = false;
		placedStudentFeeStructureValidator.validate(placedStudentFeeStructure, result);
		if (result.hasErrors()) {
			return "viewPlacedStudentDetail";
		}

		status = placedStudentFeeStructureService.savePlacedStudentDetail(placedStudentFeeStructure);
		if (status) {
			model.addAttribute("message", IConstant.PLACED_STUDENT_DETAIL_SAVE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.PLASED_STUDENT_DETAIL_SAVE_FAILURE_MESSAGE);
		}
		return "redirect:/viewPlacedStudentDetail.do";
	}

	@RequestMapping(value = "/editPlacedStudentDetail")
	public String updatePlacedStudentDetail(
					@ModelAttribute("PlacedStudentFeeStructure") PlacedStudentFeeStructure placedStudentFeeStructure,
					Map<String, Object> map, @RequestParam(required = false) Integer placedStudentId) {

		placedStudentFeeStructure = placedStudentFeeStructureService.updatePlacedStudentDetail(placedStudentId);
		if (placedStudentFeeStructure != null) {
			map.put("PlacedStudentFeeStructure", placedStudentFeeStructure);
		}
		return "viewPlacedStudentDetail";
	}

	@RequestMapping(value = "/deletePlacedStudentDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public String deletePlacedStudentDetail(@RequestParam(required = false) Integer placedStudentId, Model model,
					String message) {
		placedStudentFeeStructureService.deletePlacedStudentDetail(placedStudentId);
		model.addAttribute("message", IConstant.PLASED_STUDENT_SUCCESS_DELETE_MESSAGE);
		return "redirect:/viewPlacedStudentDetail.do";
	}

}
