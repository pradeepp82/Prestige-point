//THIS CONTROLLER IS CREATED BY MAYANK SHUKLA
package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.service.FooterPhotoService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author MAYANK SHUKLA
 *
 */
@SuppressWarnings("unchecked")
@Controller
public class FooterPhotoController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(FooterPhotoController.class);

	@Autowired
	private FooterPhotoService footerPhotoService;

	/**
	 * use for view the jsp of footerPhoto.
	 * 
	 * @param map
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/getFooterPhotoPage")
	public String getFooterPhotoPage(@SuppressWarnings("rawtypes") Map map,
			@RequestParam(required = false) String message, Model model) {
		List<PhotoInFooter> photoInFooterList = footerPhotoService.getAllStudentName();
		model.addAttribute("photoInFooterList", photoInFooterList);
		map.put("PhotoInFooter", new PhotoInFooter());
		model.addAttribute("message", message);
		return "getFooterPhotoPage";
	}

	/*
	 * use for add and edit the footerPhoto.
	 * 
	 * @param photoInFooter
	 * @param request
	 * @param studentId
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveFooterPhoto", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveFooterPhoto(@ModelAttribute("PhotoInFooter") PhotoInFooter photoInFooter,
			HttpServletRequest request, @RequestParam(required = false) Integer studentId,
			@SuppressWarnings("rawtypes") Map map, ModelMap model) {
		@SuppressWarnings("unused")
		String imagePath = photoInFooter.getImgPath();
		boolean status = false;
		List<PhotoInFooter> photoInFooterList = footerPhotoService.getAllStudentName();
		String method = request.getMethod();
		// Below if condition is for edit functionality
		if (("GET").equals(method)) {

			photoInFooter = footerPhotoService.editSingleStudentDetail(studentId);
			model.addAttribute("photoInFooterList", photoInFooterList);
			map.put("PhotoInFooter", photoInFooter);
			return "getFooterPhotoPage";
		} else {

			model.addAttribute("photoInFooterList", photoInFooterList);
			if (photoInFooter.getStudentId() != null) {
				status = footerPhotoService.saveFooterPhoto(photoInFooter);
				if (status) {
					model.addAttribute("message", IConstant.STUDENT_EDIT_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.STUDENT_EDIT_FAILURE_MESSAGE);
				}
			} else {
				status = footerPhotoService.saveFooterPhoto(photoInFooter);
				if (status) {
					model.addAttribute("message", IConstant.PLACED_STUDENT_SUCCESS_MESSAGE);
				} else {
					model.addAttribute("message", IConstant.PLACED__STUDENT_FAILURE_MESSAGE);
				}
			}

			return "redirect:/getFooterPhotoPage.do";
		}
	}

	@RequestMapping(value = "/changeStudentStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public String changeStudentStatus(@ModelAttribute("PhotoInFooter") PhotoInFooter photoInFooter,
			@RequestParam(required = false) String studentId, @RequestParam(required = false) String checkedValue) {

		List<PhotoInFooter> photoInFooter2 = footerPhotoService.getSingleStudentDetail(studentId);
		photoInFooter = photoInFooter2.get(0);
		if (("checked").equals(checkedValue)) {
			footerPhotoService.changeStatusByStudentId(photoInFooter);
		} else {
			footerPhotoService.uncheckStatusByStudentId(photoInFooter);
		}
		return "redirect:/getFooterPhotoPage";
	}
	/**
	 * use for delete the student information
	 * @param photoInFooter
	 * @param model
	 * @param studentId
	 * @return
	 */

	@RequestMapping(value = "/deleteStudent", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteSinglePlacedStudentData(ModelMap model, @RequestParam(required = false) Integer studentId) {
		footerPhotoService.deleteStudentData(studentId);
		model.addAttribute("message", IConstant.PLACED_STUDENT_DELETE_MESSAGE);
		return "redirect:/getFooterPhotoPage.do";
	}
}
