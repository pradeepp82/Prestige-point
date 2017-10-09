package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.AssignmentDoc;
import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.BatchAssignment;
import com.aartek.prestigepoint.repository.AssignmentRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class AssignmentRepositoryImpl implements AssignmentRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public AssignmentDoc saveAssignment(AssignmentDoc assignmentDoc) {
		if (assignmentDoc != null) {
			hibernateTemplate.save(assignmentDoc);
			return assignmentDoc;
		} else {
			return null;
		}
	}

	public List<AddAssignment> getAllAssignment() {
		List<AddAssignment> list = hibernateTemplate.find("from AddAssignment a where a.isDeleted="
				+ IConstant.IS_DELETED);
		return list;
	}

	public List<String> getAllEmailId(int batchId) {
		List<String> list = hibernateTemplate.find(
				"select r.emailId from Registration r where r.batch.batchId = ? and r.isDeleted=?", batchId,
				IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public List<String> getAllDocName(Integer assignmentId) {
		List<String> list = hibernateTemplate
				.find("select an.assignmentDocName from AssignmentDoc an where an.addAssignment.assignmentId = ? and an.isDeleted=?",
						assignmentId, IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return list;
		}
		return null;
	}

	public AddAssignment getAssignment(Integer assignmentId) {
		AddAssignment addAssignment = hibernateTemplate.get(AddAssignment.class, assignmentId);
		return addAssignment;
	}

	public void saveAssignmentId(BatchAssignment batchassignment) {
		if (batchassignment != null) {
			hibernateTemplate.save(batchassignment);
		}
	}

	public Batch getBatchId(int batchId) {
		Batch batch = hibernateTemplate.get(Batch.class, batchId);
		return batch;
	}

	public List<AddAssignment> viewAssignmentDetails(Integer batchId) {
		List<AddAssignment> viewAssignment = hibernateTemplate.find("from BatchAssignment ass where ass.batch.batchId="
				+ batchId);
		return viewAssignment;
	}

	public List<AddAssignment> getAllTopic(Integer subjectId) {
		List<AddAssignment> viewAssignmentTopic = hibernateTemplate.find("from AddAssignment abs where abs.subject.subjectId = ? and abs.isDeleted=?",
				subjectId, IConstant.IS_DELETED);
		return viewAssignmentTopic;
	}
	
	public List<Object> displyAllDetailsBatchWise(Integer assignmentId) {
		List<Object> getAllDetailsBatchWise = hibernateTemplate.find("from AddAssignment assign where assign.assignmentId = ? and assign.isDeleted=?",
				assignmentId, IConstant.IS_DELETED);
		
		return getAllDetailsBatchWise;
	}

	public List<AssignmentDoc> updateAssignmentDetails(Integer assignmentId) {
		List<AssignmentDoc> list = hibernateTemplate.find("from AssignmentDoc aId where aId.addAssignment.assignmentId=" + assignmentId);
		if(list!=null){
		return list;
		}else{
			return null;
		}
		
	}

	public void deleteAssignment(Integer assignmentId) {
		AddAssignment addAssignment = (AddAssignment) hibernateTemplate.get(AddAssignment.class, assignmentId);
		addAssignment.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != addAssignment) {
			hibernateTemplate.update(addAssignment);
		}
	}
		
	}
