package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Comments;

public interface CommentService {

	public boolean saveComment(Comments comment);

	public List<Comments> getAllComments(Integer questionId);
}
