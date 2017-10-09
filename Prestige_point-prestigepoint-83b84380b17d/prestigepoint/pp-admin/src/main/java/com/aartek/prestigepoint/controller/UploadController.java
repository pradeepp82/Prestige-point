package com.aartek.prestigepoint.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.prestigepoint.model.Upload;
import com.aartek.prestigepoint.service.UploadService;

@Controller
public class UploadController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UploadController.class);

	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("/upload")
	public String getUploadPage(Map<String, Object> map, Model model,
			@RequestParam(required = false) String uploadMessage) {
		model.addAttribute("uploadMessage", uploadMessage);
		return "upload";
	}

	@RequestMapping(value = "/saveJar", method = { RequestMethod.GET, RequestMethod.POST })
	public String handleFileUpload(Model model, @RequestParam("languageType") String languageType,
			@RequestParam("file") MultipartFile file, HttpServletResponse response, Upload upload,BindingResult result) throws IOException {
		 response.setContentType("text/html;charset=UTF-8");
		 final String fileName = file.getOriginalFilename();
		   uploadService.uploadJar(upload, file, languageType);
		   model.addAttribute("uploadMessage", "New jar " + fileName + " is uploaded");
		   return "redirect:/upload.do";
	}
}
