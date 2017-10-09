package com.aartek.prestigepoint.controller.ws;

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

import com.aartek.prestigepoint.model.Comments;
import com.aartek.prestigepoint.service.CommentService;
import com.aartek.prestigepoint.util.IConstant;

@Controller
public class CommentWSController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> saveComment(@RequestBody Comments comment,
			HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean status = false;
		status = commentService.saveComment(comment);
		if (status) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.COMMENT_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.COMMENT_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getAllComments", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllComments(@RequestBody Comments comments, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Comments> commentList = commentService.getAllComments(comments.getQuestionAnswer().getQuestionId());
		if (comments != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, commentList);
			map.put(IConstant.MESSAGE, IConstant.ALL_COMMENT_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, IConstant.NO_COMMENT_FOUND);
		}
		return map;
	}

}
