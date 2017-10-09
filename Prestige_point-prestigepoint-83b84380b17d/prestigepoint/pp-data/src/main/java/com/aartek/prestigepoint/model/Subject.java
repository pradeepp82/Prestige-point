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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author deepak
 * 
 */

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1637997029938040624L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBJECT_ID")
	private Integer subjectId;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@Column(name = "CREATED_DATE")
	private String createdDate;

	@Column(name = "UPDATED_DATE")
	private String updatedDate;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT_ID")
	private List<ForumQuestion> forumQuestionList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECT_ID")
	private List<AddAssignment> addAssignments;

	public Integer getSubjectId() {
		return subjectId;
	}

	public String getSubjectName() {
		return subjectName;
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

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	 * @return the forumQuestionList
	 */
	@JsonIgnore
	public List<ForumQuestion> getForumQuestionList() {
		return forumQuestionList;
	}

	/**
	 * @param forumQuestionList
	 *            the forumQuestionList to set
	 */
	@JsonIgnore
	public void setForumQuestionList(List<ForumQuestion> forumQuestionList) {
		this.forumQuestionList = forumQuestionList;
	}
	@JsonIgnore
	public List<AddAssignment> getAddAssignments() {
		return addAssignments;
	}
	@JsonIgnore
	public void setAddAssignments(List<AddAssignment> addAssignments) {
		this.addAssignments = addAssignments;
	}

}