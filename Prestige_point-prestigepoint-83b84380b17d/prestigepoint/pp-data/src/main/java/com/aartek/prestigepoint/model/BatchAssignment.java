package com.aartek.prestigepoint.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "batch_assignment")
public class BatchAssignment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BATCH_ASSIGNMENT_ID")
	private Integer batchassignmentId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BATCH_ID")
	private Batch batch;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ASSIGNMENT_ID")
	private AddAssignment addAssignment;

	public Integer getBatchassignmentId() {
		return batchassignmentId;
	}

	public void setBatchassignmentId(Integer batchassignmentId) {
		this.batchassignmentId = batchassignmentId;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public AddAssignment getAddAssignment() {
		return addAssignment;
	}

	public void setAddAssignment(AddAssignment addAssignment) {
		this.addAssignment = addAssignment;
	}
}
