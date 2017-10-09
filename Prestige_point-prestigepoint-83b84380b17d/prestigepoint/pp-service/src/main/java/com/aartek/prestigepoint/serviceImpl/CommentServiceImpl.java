package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Comments;
import com.aartek.prestigepoint.repository.CommentRepository;
import com.aartek.prestigepoint.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public boolean saveComment(Comments comment) {
		boolean status = false;
		if (comment.getEmailId() != null && comment.getComments() != null
				&& comment.getQuestionAnswer().getQuestionId() != null) {
			Integer questionId = comment.getQuestionAnswer().getQuestionId();
			status = commentRepository.verifyQuestionId(questionId);
			if (status) {
				commentRepository.saveComment(comment);
				return status;
			} else {
				return status;
			}
		} else {
			return status;
		}

	}

	public List<Comments> getAllComments(Integer questionId) {
		if (questionId != null) {
			List<Comments> list = commentRepository.getAllComments(questionId);
			if(list!=null && !list.isEmpty()){
				return list;
			}else{
				return null;
			}
			}
			return null;
		}
}
