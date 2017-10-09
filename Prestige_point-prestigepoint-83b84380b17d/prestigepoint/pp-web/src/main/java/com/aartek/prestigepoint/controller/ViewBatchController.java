package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.service.CurrentBatchService;
import com.aartek.prestigepoint.service.FooterPhotoService;

@Controller
public class ViewBatchController {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ViewBatchController.class);

	@Autowired
	private FooterPhotoService footerPhotoService;

	@Autowired
	private CurrentBatchService currentBatchService;

	@RequestMapping("/viewCurrentBatch")
	public String vieCurrentBatch(Map<String, Object> map, Model model) {

		map.put("CurrentBatch", new CurrentBatch());
		List<PhotoInFooter> listOfSelectedStudent = footerPhotoService.listOfSelectedStudent();
		model.addAttribute("allStudentDetail", listOfSelectedStudent);
		List<CurrentBatch> currentBatchList = currentBatchService.getAllCurrentBatch();
		if (currentBatchList != null) {
			model.addAttribute("currentBatchList", currentBatchList);
		}

		return "viewCurrentBatch";
	}

}
