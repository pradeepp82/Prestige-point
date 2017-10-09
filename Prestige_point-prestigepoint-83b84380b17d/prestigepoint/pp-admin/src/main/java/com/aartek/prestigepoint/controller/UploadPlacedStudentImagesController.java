package com.aartek.prestigepoint.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;
import com.aartek.prestigepoint.service.UploadPlacedStudentImagesService;
import com.aartek.prestigepoint.util.IConstant;
/**
 * 
 * @author Meenal pathre
 *
 */
@Controller
public class UploadPlacedStudentImagesController {

	@Autowired
	private UploadPlacedStudentImagesService uploadPlacedStudentImagesService;

	/**
	 * show the uploadPlacedStudentImages page
	 * 
	 */
	@RequestMapping("/uploadPlacedStudentImages")
	private String uploadPlacedStudentImages(Map<String, Object> map, ModelMap model,
			@RequestParam(required = false) String message) {
		map.put("UploadPlacedStudentImages", new UploadPlacedStudentImages());
		model.addAttribute("message", message);
		return "uploadPlacedStudentImages";
	}

	/**
	 * use for upload the image for web service
	 * 
	 */
	@RequestMapping(value = "/savePlacedStudentImages.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String savePlacedStudentImages(
			@ModelAttribute("UploadPlacedStudentImages") UploadPlacedStudentImages uploadPlacedStudentImages,
			ModelMap model) {
		boolean status = false;
		status = uploadPlacedStudentImagesService.savePlacedStudentImages(uploadPlacedStudentImages);
		if (status) {
			model.addAttribute("message", IConstant.UPLOAD_IMAGE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.UPLOAD_IMAGE_FAILURE_MESSAGE);
		}
		return "redirect:/uploadPlacedStudentImages.do";
	}
}
