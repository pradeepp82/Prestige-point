package com.aartek.prestigepoint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "add_assignment")
public class AddAssignment implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ASSIGNMENT_ID")
	private Integer assignmentId;
	
	@Column(name = "TOPIC")
	private String topic;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Transient
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_ID")
	private Batch batch;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
	@JoinColumn(name = "ASSIGNMENT_ID",updatable=false)
	private List<AssignmentDoc> assignmentDocList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_ASSIGNMENT_ID",updatable=false)
	private List<BatchAssignment> batchAssignmentList;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<AssignmentDoc> getAssignmentDocList() {
		return assignmentDocList;
	}

	public void setAssignmentDocList(List<AssignmentDoc> assignmentDocList) {
		this.assignmentDocList = assignmentDocList;
	}

	public Integer getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Integer assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public List<BatchAssignment> getBatchAssignmentList() {
		return batchAssignmentList;
	}

	public void setBatchAssignmentList(List<BatchAssignment> batchAssignmentList) {
		this.batchAssignmentList = batchAssignmentList;
	}
}
