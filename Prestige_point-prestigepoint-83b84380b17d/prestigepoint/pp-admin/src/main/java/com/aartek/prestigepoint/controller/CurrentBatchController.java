package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.service.CurrentBatchService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.CurrentBatchValidator;

/**
 * 
 * @author meenal
 *
 */
@Controller
public class CurrentBatchController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private CurrentBatchService currentBatchService;

	@Autowired
	private CurrentBatchValidator currentBatchValidator;
	
	@Autowired
	private CourseService courseService;

	/**
	 * Show the current batch page
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/currentBatch")
	public String showCurrentbatch(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		map.put("CurrentBatch", new CurrentBatch());
		List<Batch> batchList = batchService.getAllBatchName();
		if (batchList != null) {
			model.addAttribute("batch", batchList);
		}
		List<Year> yearList = courseService.getAllYearName();
		if (yearList != null) {
			model.addAttribute("year", yearList);
		}
		List<CurrentBatch> currentBatchList = currentBatchService.getAllCurrentBatch();
		if (currentBatchList != null) {
			model.addAttribute("currentBatchList", currentBatchList);
		}
		model.addAttribute("message", message);
		return "currentBatch";
	}

	/**
	 * Add current batch information
	 * 
	 * @param currentBatch
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/saveCurrentBatch", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveCurrentBatch(@ModelAttribute("CurrentBatch") CurrentBatch currentBatch, BindingResult result,
			ModelMap model, Map<String, Object> map, HttpServletRequest request,
			@RequestParam(required = false) Integer currentBatchId) {
		List<Batch> batchList = batchService.getAllBatchName();
		if (batchList != null) {
			model.addAttribute("batch", batchList);
		}
		List<Year> yearList = courseService.getAllYearName();
		if (yearList != null) {
			model.addAttribute("year", yearList);
		}
		List<CurrentBatch> currentBatchList = currentBatchService.getAllCurrentBatch();
		if (currentBatchList != null) {
			model.addAttribute("currentBatchList", currentBatchList);
		}
		if (currentBatch != null) {
			currentBatchValidator.validate(currentBatch, result);
			if (result.hasErrors()) {
				return "currentBatch";
			}
			else{
		String method = request.getMethod();
		if (("GET").equals(method)) {
			currentBatch = currentBatchService.updateCurrentBatch(currentBatchId);
			model.addAttribute("currentBatchList", currentBatchList);
			if (currentBatch != null) {
				map.put("CurrentBatch", currentBatch);
			} else {
				map.put("CurrentBatch", new CurrentBatch());
			}
			return "currentBatch";
		}
			
		}
			if (currentBatch.getCurrentBatchId() != null) {
				boolean status = currentBatchService.saveCurrentBatch(currentBatch);
				if (status) {
					model.addAttribute("message", IConstant.UPDATE_CURRENT_BATCH_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.CURRENT_BATCH_FAILURE_MESSAGE);
				}
			} else {
				boolean status = currentBatchService.saveCurrentBatch(currentBatch);
				if (status) {
					model.addAttribute("message", IConstant.CURRENT_BATCH_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.CURRENT_BATCH_FAILURE_MESSAGE);
				}
			}
		}
		return "redirect:/currentBatch.do";
	}

	/**
	 * Delete current batch.
	 * 
	 * @param currentBatch
	 * @param result
	 * @param model
	 * @param request
	 * @param currentBatchId
	 * @return
	 */
	@RequestMapping(value = "/deleteCurrentBatch", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCurrentBatch(ModelMap model, @RequestParam(required = false) Integer currentBatchId) {
		boolean status= false;
		status = currentBatchService.deleteCurrentBatch(currentBatchId);
		if(status){
		model.addAttribute("message", IConstant.CURRENT_BATCH_DELETE_MESSAGE);
		}else{
			model.addAttribute("message", IConstant.CURRENT_BATCH_FAILUR_DELETE_MESSAGE);
		}
		return "redirect:/currentBatch.do";
	}

}
