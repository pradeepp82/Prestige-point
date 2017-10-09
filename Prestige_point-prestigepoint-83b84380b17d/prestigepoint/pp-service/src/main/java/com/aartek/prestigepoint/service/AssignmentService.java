package com.aartek.prestigepoint.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.AssignmentDoc;

public interface AssignmentService {

public boolean saveAssignment(String assignmentDocName, MultipartFile filePart,CommonsMultipartFile[] fileUpload, AssignmentDoc assignmentDoc,
		Integer assignmentId);

public List<AddAssignment> getAllAssignment();

public boolean getAllEmailId(String batchId, String subject,String description, Integer assignmentId)throws MessagingException;

public List<AddAssignment> viewAssignmentDetails(Integer batchId);

public List<AddAssignment> getAllTopic(Integer subjectId);

public AddAssignment displyAllDetailsBatchWise(Integer assignmentId);

public List<String> getAllDocName(Integer assignmentId);

public AssignmentDoc editAssignmentDetails(Integer assignmentId);

public void deleteAssignment(Integer assignmentId);



}
 