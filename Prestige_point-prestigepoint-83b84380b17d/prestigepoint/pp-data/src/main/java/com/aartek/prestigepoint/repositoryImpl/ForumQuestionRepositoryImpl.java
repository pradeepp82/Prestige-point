/**
 * 
 */
package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.ForumQuestion;
import com.aartek.prestigepoint.repository.ForumQuestionRepository;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author deepak
 * 
 */
@Repository
@SuppressWarnings("all")
public class ForumQuestionRepositoryImpl implements ForumQuestionRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean addQuestion(ForumQuestion forumQuestion) {
		if (forumQuestion != null) {
			hibernateTemplate.saveOrUpdate(forumQuestion);
			return true;
		} else {
			return false;
		}
	}

	public List<ForumQuestion> getAllSubjects() {
		List<ForumQuestion> subjectList = hibernateTemplate.find("from Subject where IS_DELETED=" + IConstant.IS_DELETED);
	    return subjectList;
	}

	public List<ForumQuestion> getAllQuestion() {
		hibernateTemplate.setMaxResults(5);
		List<ForumQuestion> questionContent = hibernateTemplate.find("from ForumQuestion fq ORDER BY fq.forumQuestionId desc");
	    return questionContent;
	}


	public List<ForumQuestion> findQuestion(ForumQuestion forumQuestion) {
		String question=forumQuestion.getForumQuestion();
		List<ForumQuestion> findQuestionContent=hibernateTemplate.find("from ForumQuestion fq where fq.forumQuestion LIKE '%"+question+"%'");
		return findQuestionContent;
	}

	public List<ForumQuestion> searchAllQuestion(String searchValue) {
		List<ForumQuestion> findQuestionContent=hibernateTemplate.find("from ForumQuestion fq where fq.forumQuestion LIKE '%"+searchValue+"%'");
		return findQuestionContent;
	}

}
