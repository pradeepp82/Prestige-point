package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Comments;

public interface CommentRepository {

	 public boolean saveComment(Comments comment);

	public boolean verifyQuestionId(Integer questionId);

	public List<Comments> getAllComments(Integer questionId);

	

}
