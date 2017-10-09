/**
 * 
 */
package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.ForumQuestion;

/**
 * @author deepak
 *
 */

public interface ForumQuestionService {

	public boolean addQuestion(ForumQuestion forumQuestion);

	public	List<ForumQuestion> getAllSubjects();

	public List<ForumQuestion> getAllQuestion();

	public List<ForumQuestion> findQuestion(ForumQuestion forumQuestion);

	public List<ForumQuestion> searchAllQuestion(String searchValue);

}
