package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "question_comment")
public class Comments implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "QUESTION_COMMENT_ID")
	private Integer QuestionCommentId;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@ManyToOne
    @JoinColumn(name="QUESTION_ID")
    private QuestionAnswer questionAnswer;

	public Integer getQuestionCommentId() {
		return QuestionCommentId;
	}

	public void setQuestionCommentId(Integer questionCommentId) {
		QuestionCommentId = questionCommentId;
	}

	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public QuestionAnswer getQuestionAnswer() {
		return questionAnswer;
	}

	public void setQuestionAnswer(QuestionAnswer questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
