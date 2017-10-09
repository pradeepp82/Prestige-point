package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.repository.QuestionAnswerRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class QuestionAnswerRepositoryImpl implements QuestionAnswerRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(QuestionAnswerRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Subject> getAllSubjectName() {
		List<Subject> list = hibernateTemplate.find("from Subject s where s.isDeleted=" + IConstant.IS_DELETED);
		return list;
	}

	public boolean saveQuestionAndAnswer(QuestionAnswer questionAnswer) {
		if (questionAnswer != null) {
			hibernateTemplate.saveOrUpdate(questionAnswer);
			return true;
		} else {
			return false;
		}
	}
	
	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId) {
		List<QuestionAnswer> list = hibernateTemplate.find("from QuestionAnswer q where q.isDeleted="
				+ IConstant.IS_DELETED + "and q.subject.subjectId=" + subjectId);
		return list;
	}

	public List<QuestionAnswer> getAllQuestionAswerList() {
		List<QuestionAnswer> questionAnswerList = hibernateTemplate.find("from QuestionAnswer qa where qa.isDeleted="
				+ IConstant.IS_DELETED );
		return questionAnswerList;
	}

	public boolean deleteQuestion(Integer questionId) {
		QuestionAnswer questionAnswer = (QuestionAnswer) hibernateTemplate.get(QuestionAnswer.class, questionId);
		if(questionAnswer!=null){
		questionAnswer.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
	    hibernateTemplate.update(questionAnswer);
	    return true;
		}else{
			return false;
		}
	}

	/*public List<QuestionAnswer> getsearchQuestion(String question) {
		List<QuestionAnswer> questionList = hibernateTemplate.find("from QuestionAnswer qa  where  (qa.question='"
					+ question + "' or  qa.question LIKE '%" + question + "%') and  qa.isDeleted=" + IConstant.IS_DELETED
					+ " order by questionId desc");
			return questionList;
		}*/

	public List<QuestionAnswer> getsearchQuestion(Integer subjectId) {
		List<QuestionAnswer> questionList = hibernateTemplate.find("from QuestionAnswer qa where qa.isDeleted=" + IConstant.IS_DELETED+ "and qa.subject.subjectId=" + subjectId);
		return questionList;
	}

	
}