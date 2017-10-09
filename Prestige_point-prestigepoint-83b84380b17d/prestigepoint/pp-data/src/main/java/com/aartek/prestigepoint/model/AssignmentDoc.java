package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "assignment_doc")
public class AssignmentDoc implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ASSIGNMENT_DOC_ID")
	private Integer assignmentDocId;

	@Column(name = "ASSIGNMENT_DOC_NAME")
	private String assignmentDocName;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSIGNMENT_ID")
	private AddAssignment addAssignment;

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getAssignmentDocId() {
		return assignmentDocId;
	}

	public void setAssignmentDocId(Integer assignmentDocId) {
		this.assignmentDocId = assignmentDocId;
	}

	public String getAssignmentDocName() {
		return assignmentDocName;
	}

	public void setAssignmentDocName(String assignmentDocName) {
		this.assignmentDocName = assignmentDocName;
	}

	public AddAssignment getAddAssignment() {
		return addAssignment;
	}

	public void setAddAssignment(AddAssignment addAssignment) {
		this.addAssignment = addAssignment;
	}

}
