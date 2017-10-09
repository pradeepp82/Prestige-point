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

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "forum_answer")
public class ForumAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7087409499712080416L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORUM_ANSWER_ID")
	private Integer forumAnswerId;

	@Column(name = "FORUM_ANSWER")
	private String forumAnswer;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@ManyToOne
	@JoinColumn(name = "FORUM_QUESTION_ID")
	private ForumQuestion forumQuestion;

	public Integer getForumAnswerId() {
		return forumAnswerId;
	}

	public String getForumAnswer() {
		return forumAnswer;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setForumAnswerId(Integer forumAnswerId) {
		this.forumAnswerId = forumAnswerId;
	}

	public void setForumAnswer(String forumAnswer) {
		this.forumAnswer = forumAnswer;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the forumQuestion
	 */
	@JsonIgnore
	public ForumQuestion getForumQuestion() {
		return forumQuestion;
	}

	/**
	 * @param forumQuestion
	 *            the forumQuestion to set
	 */
	public void setForumQuestion(ForumQuestion forumQuestion) {
		this.forumQuestion = forumQuestion;
	}

}