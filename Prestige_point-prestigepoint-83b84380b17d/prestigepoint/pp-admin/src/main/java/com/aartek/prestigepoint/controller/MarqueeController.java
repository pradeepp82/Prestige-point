package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.AddMarquee;
import com.aartek.prestigepoint.service.MarqueeService;
import com.aartek.prestigepoint.util.IConstant;
@Controller
public class MarqueeController {

	@Autowired
	private MarqueeService addMarqueeService;
	
	@RequestMapping("/marquee")
	private String addMarquee(Map<String, Object> map, @RequestParam(required = false) String message, ModelMap model) {
		map.put("AddMarquee", new AddMarquee());
		model.addAttribute("message", message);
		List<AddMarquee> marqueeList = addMarqueeService.getAllMarqueeDescription();
		if (marqueeList != null) {
			model.addAttribute("marqueeList", marqueeList);
		}
		return "addMarquee";
	}

	@RequestMapping(value = "/saveMarquee.do", method = {RequestMethod.GET, RequestMethod.POST })
	private String saveMarquee(@ModelAttribute("AddMarquee") AddMarquee addMarquee,
			ModelMap model) {
		boolean status = false;
		status = addMarqueeService.saveMarquee(addMarquee);
		if (status) {
			model.addAttribute("message", IConstant.MARQUEE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.MARQUEE_FAILURE_MESSAGE);
		}
		return "redirect:/marquee.do";
	}
	
	@RequestMapping(value = "/editMarqueeDescription")
	public String updateMarqueeDescription(@ModelAttribute("AddMarquee") AddMarquee addMarquee,
			Map<String, Object> map, @RequestParam(required = false) Integer marqueeId) {
		addMarquee = addMarqueeService.editMarqueeDescription(marqueeId);
		if(addMarquee!=null){
		map.put("AddMarquee", addMarquee);
		}
		return "addMarquee";
	}
	
	@RequestMapping(value = "/deleteMarqueeDescription", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteMarqueeDescription(@RequestParam(required = false) Integer  marqueeId,ModelMap model) {
		boolean status = false;
		status = addMarqueeService.deleteMarqueeDescription( marqueeId);
		if(status){
		model.addAttribute("message", IConstant.MARQUEE_DELETED_MESSAGE);
		}else{
			model.addAttribute("message", IConstant.MARQUEE_FAILUR_DELETED_MESSAGE);
		}
		return "redirect:/marquee.do";
	}
	
	@RequestMapping(value = "changeMarqueeStatusAction", method = RequestMethod.GET)
	@ResponseBody
	public void changeMarqueeStatus(@RequestParam(required = false) String marqueeIdValue, Integer  marqueeValue) {
		addMarqueeService.changeMarqueeStatus(marqueeIdValue,  marqueeValue);
	}
}
