package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Comments;
import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.repository.CommentRepository;
import com.aartek.prestigepoint.util.IConstant;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public boolean saveComment(Comments comment) {
		if (comment != null) {
			hibernateTemplate.save(comment);
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public boolean verifyQuestionId(Integer questionId) {
	if(questionId!=null){
	List<QuestionAnswer> list = hibernateTemplate.find("from QuestionAnswer c where c.isDeleted="+ IConstant.IS_DELETED + "and c.questionId=" + questionId);
	if(list!=null && !list.isEmpty()){
		return true;
	}else{
		return false;
	}
	}
	return false;
	}

	@SuppressWarnings("unchecked")
	public List<Comments> getAllComments(Integer questionId) {
		List<Comments> list = hibernateTemplate.find("from Comments cm where cm.questionAnswer.questionId=" + questionId);
		if(list!=null){
			return list;
		}else{
		return null;
		}
	}
}
