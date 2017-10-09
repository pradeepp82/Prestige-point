package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Subject;

public interface QuestionAnswerRepository {

	public List<Subject> getAllSubjectName();

	public boolean saveQuestionAndAnswer(QuestionAnswer questionAnswer);

	public List<QuestionAnswer> getQuestionAndAnswer(Integer subjectId);

	public List<QuestionAnswer> getAllQuestionAswerList();

	public boolean deleteQuestion(Integer questionId);

	/*public List<QuestionAnswer> getsearchQuestion(String string);*/

	public List<QuestionAnswer> getsearchQuestion(Integer subjectId);

	
}
