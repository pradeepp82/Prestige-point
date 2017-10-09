package com.aartek.prestigepoint.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.service.SendMessageService;

/**
 * 
 * @author Neha Rajput
 *
 */
@Controller
public class SendMessageController {

	@Autowired
	private BatchService batchService;

	@Autowired
	private SendMessageService sendMessageService;
	
	// method to show the send message page

	@RequestMapping("/sendMessagePage")
	public String showSendMessagePage(Model model, Map<String, Object> map,@RequestParam(required = false) Integer batchId) {
		List<Batch> batchList = batchService.getAllBatchName();
		 model.addAttribute("batchList", batchList);
		 /*model.addAttribute("batchId", batchId);*/
		/*model.addAttribute("message", message);*/
		map.put("Batch", new Batch());
		return "sendMessage";

	}

	// method for sending message

	@RequestMapping(value = "/sendMessage",  method = { RequestMethod.GET, RequestMethod.POST })
	public String SendMessage(@ModelAttribute("Batch") Batch batch,
			Model model) 
	{
	List<Batch> studentList = sendMessageService.getAllStudentList(batch);
		
		System.out.println("message text:"+batch.getMessageText());
		
		return "sendMessage";

	}
}
