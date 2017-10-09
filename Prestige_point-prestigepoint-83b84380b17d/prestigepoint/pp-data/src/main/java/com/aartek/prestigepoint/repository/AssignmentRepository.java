package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.AssignmentDoc;
import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.BatchAssignment;


public interface AssignmentRepository {

	public AssignmentDoc saveAssignment(AssignmentDoc assignmentDoc);

	public List<AddAssignment> getAllAssignment();

	public List<String> getAllEmailId(int batchId);

	public List<String> getAllDocName(Integer assignmentId);

	public AddAssignment getAssignment(Integer assignmentId);

	public void saveAssignmentId(BatchAssignment batchassignment);

	public Batch getBatchId(int  batchId);

	public List<AddAssignment> viewAssignmentDetails(Integer batchId);

	public List<AddAssignment> getAllTopic(Integer subjectId);

	public List<Object> displyAllDetailsBatchWise(Integer assignmentId);

	public List<AssignmentDoc> updateAssignmentDetails(Integer assignmentId);

	public void deleteAssignment(Integer assignmentId);

}
