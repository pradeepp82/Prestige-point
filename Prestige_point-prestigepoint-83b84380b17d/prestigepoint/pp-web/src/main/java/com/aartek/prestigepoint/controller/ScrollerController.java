/*package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.service.ScrollerService;

@Controller
public class ScrollerController {
	@Autowired
	private ScrollerService scrollerService;

	//@SuppressWarnings("unchecked")
	//@RequestMapping("/scrollerView")
	public String showScrollerPage(@SuppressWarnings("rawtypes") Map map,
			@RequestParam(required = false) String message, Model model) {
List<Scroller> scrollers =null;
scrollers= scrollerService.getAllScrollImages();
 model.addAttribute("allImages",scrollers);		
	System.out.println("scroller value is"+scrollers.get(1));	
		return "scroller";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Map<String, Object> map, Model model) {
		List<Scroller> scrollers =null;
		scrollers= scrollerService.getAllScrollImages();
		 model.addAttribute("allImages",scrollers);		
			System.out.println("scroller value is"+scrollers.get(1));	
				return "welcome";
}
}*/