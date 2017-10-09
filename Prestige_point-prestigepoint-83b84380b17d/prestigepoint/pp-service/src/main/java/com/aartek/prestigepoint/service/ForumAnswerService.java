/**
 * 
 */
package com.aartek.prestigepoint.service;

import com.aartek.prestigepoint.model.ForumAnswer;

/**
 * @author deepak
 * 
 */
public interface ForumAnswerService {

	public boolean addAnswer(ForumAnswer forumAnswer);

	public ForumAnswer updateAnswer(Integer forumAnswerId);

}
