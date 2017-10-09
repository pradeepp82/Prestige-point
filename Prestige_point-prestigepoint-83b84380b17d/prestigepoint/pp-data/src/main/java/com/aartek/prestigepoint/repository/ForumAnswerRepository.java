/**
 * 
 */
package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.ForumAnswer;
import com.aartek.prestigepoint.model.ForumQuestion;

/**
 * @author deepak
 * 
 */
public interface ForumAnswerRepository {

	public boolean addAnswer(ForumAnswer forumAnswer);

	public List<Object> updateAnswer(Integer forumAnswerId);
}