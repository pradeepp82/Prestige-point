/**
 * 
 */
package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.ForumAnswer;
import com.aartek.prestigepoint.repository.ForumAnswerRepository;
import com.aartek.prestigepoint.service.ForumAnswerService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author deepak
 * 
 */
@Service
public class ForumAnswerServiceImpl implements ForumAnswerService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ForumAnswerServiceImpl.class);
	@Autowired
	private ForumAnswerRepository forumAnswerRepository;

	public boolean addAnswer(ForumAnswer forumAnswer) {
		boolean status = false;
		if (forumAnswer != null) {
	        forumAnswer.toString().trim();
			forumAnswer.setIsDeleted(IConstant.IS_DELETED);
			status = forumAnswerRepository.addAnswer(forumAnswer);
			return status;
		} else {
			return status;
		}
	}

	public ForumAnswer updateAnswer(Integer forumAnswerId) {
		List<Object> forumAnswer = new ArrayList<Object>();
		ForumAnswer updateAnswer = new ForumAnswer();
		forumAnswer = forumAnswerRepository.updateAnswer(forumAnswerId);
		for (Object object : forumAnswer) {
			updateAnswer = (ForumAnswer) object;

		}
		return updateAnswer;
	}
}
