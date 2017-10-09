/**
 * 
 */
package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.ForumQuestion;
import com.aartek.prestigepoint.repository.ForumQuestionRepository;
import com.aartek.prestigepoint.service.ForumQuestionService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author dell
 * 
 */
@Service
public class ForumQuestionServiceImpl implements ForumQuestionService {
	@Autowired
	private ForumQuestionRepository forumQuestionRepository;

	public boolean addQuestion(ForumQuestion forumQuestion) {
		boolean status = false;
		if (forumQuestion != null) {
			forumQuestion.setIsDeleted(IConstant.IS_DELETED);
			status = forumQuestionRepository.addQuestion(forumQuestion);
			return status;
		} else {
			return status;
		}
	}

	public List<ForumQuestion> getAllSubjects() {
		List<ForumQuestion> list = new ArrayList<ForumQuestion>();
	    list = forumQuestionRepository.getAllSubjects();
	    return list;
	}

	public List<ForumQuestion> getAllQuestion() {
		List<ForumQuestion> questionList = new ArrayList<ForumQuestion>();
		questionList = forumQuestionRepository.getAllQuestion();
	    return questionList;
	}

	public List<ForumQuestion> findQuestion(ForumQuestion forumQuestion) {
		List<ForumQuestion> findQuestionContent=new ArrayList<ForumQuestion>();
		findQuestionContent=forumQuestionRepository.findQuestion(forumQuestion);
		return findQuestionContent;
	}

	public List<ForumQuestion> searchAllQuestion(String searchValue) {
		List<ForumQuestion> findQuestionContent=new ArrayList<ForumQuestion>();
		findQuestionContent=forumQuestionRepository.searchAllQuestion(searchValue);
		return findQuestionContent;
	}

}