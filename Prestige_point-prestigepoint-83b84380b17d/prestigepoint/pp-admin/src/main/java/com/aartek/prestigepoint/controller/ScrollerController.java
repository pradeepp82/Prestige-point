
package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.service.ScrollerService;
import com.aartek.prestigepoint.util.IConstant;
/**
 * 
 * @author Meenal Pathre
 *
 */
@SuppressWarnings("unchecked")
@Controller
public class ScrollerController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ScrollerController.class);

	@Autowired
	private ScrollerService scrollerService;

	/**
	 * use for view jsp of scrollerView
	 * 
	 * @param map
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/scrollerView")
	public String showScrollerPage(@SuppressWarnings("rawtypes") Map map,
			@RequestParam(required = false) String message, Model model) {
		List<Scroller> scrollerPhotoList = scrollerService.getAllImage();
		if(scrollerPhotoList!=null){
		model.addAttribute("scrollerPhotoList", scrollerPhotoList);
		}
		map.put("Scroller", new Scroller());
		model.addAttribute("message", message);
		return "scroller";
	}

	/**
	 * use for addimageForScroller
	 * 
	 * @param map
	 * @param scroller
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/saveScoller")
	public String addimageForScroller(@ModelAttribute("Scroller") Scroller scroller, ModelMap model) {
		boolean status = false;
		status = scrollerService.saveScrollerPhoto(scroller);
		if (status) {
			model.addAttribute("message", IConstant.UPLOAD_IMAGE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.UPLOAD_IMAGE_FAILURE_MESSAGE);
		}
		return "redirect:/scrollerView.do";
	}

	@RequestMapping(value = "/changeScrollerStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public String changeScrollerStatus(@ModelAttribute("Scroller") Scroller scroller,
			@RequestParam(required = false) String imageId, @RequestParam(required = false) String checkedValue) {
		List<Scroller> scrollers = scrollerService.getSingleScrollDetail(imageId);
		scroller = scrollers.get(0);
		if (checkedValue.equals("checked")) {
			scrollerService.changeStatusByImageId(scroller);
		} else {
			scrollerService.uncheckStatusByImageId(scroller);

		}
		return "redirect:/addFooterPhoto";
	}

	/**
	 * use for deleteScroller
	 * 
	 * @param scroller
	 * @param model
	 * @param imageId
	 * @return
	 */
	@RequestMapping(value = "/deleteScroller", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteScrollerImage(ModelMap model, @RequestParam(required = false) Integer imageId) {
		scrollerService.deleteScrollerImage(imageId);
		model.addAttribute("message", IConstant.SCROLLER_IMAGE_DELETE_MESSAGE);
		return "redirect:/scrollerView.do";
	}
}
