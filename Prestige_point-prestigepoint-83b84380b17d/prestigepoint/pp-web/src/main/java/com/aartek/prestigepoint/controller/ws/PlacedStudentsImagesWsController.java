package com.aartek.prestigepoint.controller.ws;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;
import com.aartek.prestigepoint.service.UploadPlacedStudentImagesService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class PlacedStudentsImagesWsController {

	@Autowired
	private UploadPlacedStudentImagesService uploadPlacedStudentImagesService; 
	
	@RequestMapping(value = "/studentsImage", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> studentsImage(@RequestBody UploadPlacedStudentImages uploadPlacedStudentImages,
			HttpServletResponse response) throws IOException {
		Map<Object, Object> map = new HashMap<Object, Object>();
        List<UploadPlacedStudentImages> studentImages = uploadPlacedStudentImagesService.getAllPlacedStudentImages();
		if (studentImages==null) {
			map.put(IConstant.RESPONSE, IConstant.NO_DATA_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.SUCCESS_MESSAGE);
			map.put(IConstant.DATA, studentImages);
			map.put(IConstant.MESSAGE, IConstant.SUCCESS_MESSAGE);
		}
		return map;
	}
}
