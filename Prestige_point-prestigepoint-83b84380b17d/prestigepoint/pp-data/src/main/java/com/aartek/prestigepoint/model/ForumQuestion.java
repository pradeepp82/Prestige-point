/**
 * 
 */
package com.aartek.prestigepoint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author deepak
 * 
 */
@Entity
@Table(name = "forum_question")
public class ForumQuestion implements Serializable {

	private static final long serialVersionUID = 3443434433111660762L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FORUM_QUESTION_ID")
	private Integer forumQuestionId;

	@Column(name = "FORUM_QUESTION")
	private String forumQuestion;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "FORUM_QUESTION_ID")
	private List<ForumAnswer> forumAnswerList;
	
	public Integer getForumQuestionId() {
		return forumQuestionId;
	}

	public String getForumQuestion() {
		return forumQuestion;
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

	public void setForumQuestionId(Integer forumQuestionId) {
		this.forumQuestionId = forumQuestionId;
	}

	public void setForumQuestion(String forumQuestion) {
		this.forumQuestion = forumQuestion;
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
	 * @return the subject
	 */
//	@JsonIgnore
	public Subject getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * @return the forumAnswerList
	 */
	@JsonIgnore
	public List<ForumAnswer> getForumAnswerList() {
		return forumAnswerList;
	}

	/**
	 * @param forumAnswerList
	 *            the forumAnswerList to set
	 */
	public void setForumAnswerList(List<ForumAnswer> forumAnswerList) {
		this.forumAnswerList = forumAnswerList;
	}

}