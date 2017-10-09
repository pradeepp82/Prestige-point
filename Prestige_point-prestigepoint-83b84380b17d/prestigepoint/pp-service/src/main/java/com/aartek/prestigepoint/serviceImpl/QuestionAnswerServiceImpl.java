package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;
import com.aartek.prestigepoint.repository.QuestionAnswerRepository;
import com.aartek.prestigepoint.service.QuestionAnswerService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(QuestionAnswerServiceImpl.class);
	@Autowired
	private QuestionAnswerRepository questionAnswerRepository;

	public List<Subject> getAllSubjectName() {
		List<Subject> list = questionAnswerRepository.getAllSubjectName();
		return list;
	}

	public boolean saveQuestionAndAnswer(QuestionAnswer questionAnswer) {
		boolean status = false;
		questionAnswer.setIsDeleted(IConstant.IS_DELETED);
		status = questionAnswerRepository.saveQuestionAndAnswer(questionAnswer);
		return status;
	}

	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId) {
		List<QuestionAnswer> answerList = questionAnswerRepository.getQuestionAndAnswer(subjectId);
		return answerList;
	}

	public List<QuestionAnswer> getAllQuestionAswerList() {
		List<QuestionAnswer> questionAnswerList = questionAnswerRepository.getAllQuestionAswerList();
		if (questionAnswerList != null)
			return questionAnswerList;
		else
			return null;
	}

	public boolean deleteQuestion(Integer questionId) {
		if (questionId != null) {
			questionAnswerRepository.deleteQuestion(questionId);
			return true;
		} else {
			return false;
		}
	}

	/*public List<QuestionAnswer> getsearchQuestion(String question) {
		List<QuestionAnswer> questionList = new ArrayList<QuestionAnswer>();
		questionList = questionAnswerRepository.getsearchQuestion(question);
		return questionList;
	}*/

	public List<QuestionAnswer> getSubjectWiseQuestion(Integer subjectId) {
		List<QuestionAnswer> questionList = new ArrayList<QuestionAnswer>();
		questionList= questionAnswerRepository.getsearchQuestion(subjectId);
		return questionList;
	}

}
