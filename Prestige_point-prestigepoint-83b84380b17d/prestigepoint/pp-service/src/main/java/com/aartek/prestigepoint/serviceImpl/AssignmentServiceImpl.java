package com.aartek.prestigepoint.serviceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aartek.prestigepoint.model.AddAssignment;
import com.aartek.prestigepoint.model.AssignmentDoc;
import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.model.BatchAssignment;
import com.aartek.prestigepoint.repository.AssignmentRepository;
import com.aartek.prestigepoint.service.AssignmentService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class AssignmentServiceImpl implements AssignmentService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private AssignmentRepository addAssignmentRepository;
	
	@Value("${pp.uploadAssignmentDoc}")
	private String uploadAssignmentDoc;

	@SuppressWarnings("resource")
	public boolean saveAssignment(String assignmentDocName, MultipartFile filePart, CommonsMultipartFile[] fileUpload,
			AssignmentDoc assignmentDoc, Integer assignmentId)throws MultipartException {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		if (assignmentDoc != null) {
			if (fileUpload != null && fileUpload.length > 0) {
				for (CommonsMultipartFile multipartFile : fileUpload) {
					
					assignmentDocName = multipartFile.getOriginalFilename();
					try {
						inputStream = multipartFile.getInputStream();
						File newFile = new File(uploadAssignmentDoc);
						assignmentDoc.setAssignmentDocName(assignmentDocName);
						assignmentDoc.setIsDeleted(IConstant.IS_DELETED);
						assignmentDoc.getAddAssignment().setIsDeleted(IConstant.IS_DELETED);
						AssignmentDoc assignmentDoc2 = addAssignmentRepository.saveAssignment(assignmentDoc);
						if(assignmentDoc2.getAssignmentDocName()!=null && assignmentDoc2.getAssignmentDocName()!= ""){
						File filePath = new File(newFile + File.separator
								+ assignmentDoc2.getAddAssignment().getAssignmentId() + "_" + assignmentDocName);
						
						if (!newFile.exists()) {
							newFile.mkdir();
							filePath.createNewFile();
						}
						outputStream = new FileOutputStream(filePath);
						int read = 0;
						int length = (int) assignmentDocName.length();
						byte[] bytes = new byte[length];
						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
						}
					}
					
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public List<AddAssignment> getAllAssignment() {
		List<AddAssignment> list = addAssignmentRepository.getAllAssignment();
		return list;

	}

	public boolean getAllEmailId(String batchId, final String subject,  final String description, final Integer assignmentId)
			throws MessagingException {
		String batch[] = batchId.split(",");
		for (String id : batch) {
			BatchAssignment batchassignment = new BatchAssignment();
			AddAssignment addAssignment  = addAssignmentRepository.getAssignment(assignmentId);
			batchassignment.setAddAssignment(addAssignment);
			if(batchId!= null && batchId!= " "){
			Batch addBatch  = addAssignmentRepository.getBatchId(Integer.parseInt(id));
			batchassignment.setBatch(addBatch);
			addAssignmentRepository.saveAssignmentId(batchassignment);
			List<String> registrations = addAssignmentRepository.getAllEmailId(Integer.parseInt(id));
			final String[] email = registrations.toArray(new String[registrations.size()]);
			InternetAddress[] addressTo = new InternetAddress[email.length];
			for (int i = 0; i < email.length; i++) {
				addressTo[i] = new InternetAddress(email[i]);
			}
			final List<String> doc = addAssignmentRepository.getAllDocName(assignmentId);
			mailSender.send(new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
					
					for (final String doc1 : doc) {
					if(!doc1.isEmpty() && !doc1.equals("")){
					FileSystemResource file = new FileSystemResource(uploadAssignmentDoc+assignmentId+"_"+doc1);
					messageHelper.addAttachment(file.getFilename(), file);
					}
					}
					messageHelper.setTo(email);
					messageHelper.setSubject(subject);
					messageHelper.setText(description);
					messageHelper.setFrom("hrd@prestigepoint.in");
					System.out.println("Done");
				}
			});
		}
		}
		return true;
	}

	public List<AddAssignment> viewAssignmentDetails(Integer batchId) {
		List<AddAssignment> getAssignment = new ArrayList<AddAssignment>();
		getAssignment = addAssignmentRepository.viewAssignmentDetails(batchId);
		return getAssignment;
	}

	public List<AddAssignment> getAllTopic(Integer subjectId) {
		List<AddAssignment> getAllTopic = new ArrayList<AddAssignment>();
		getAllTopic = addAssignmentRepository.getAllTopic(subjectId);
		return getAllTopic;
	}
	
	public AddAssignment displyAllDetailsBatchWise(Integer assignmentId) {
		List<Object> allAssignmentList = new ArrayList<Object>();
		AddAssignment addAssignment1 = null;
		allAssignmentList = addAssignmentRepository.displyAllDetailsBatchWise(assignmentId);
		for (Object object : allAssignmentList) {
			addAssignment1 = (AddAssignment) object;
		}
		return addAssignment1;
	}

	public List<String> getAllDocName(Integer assignmentId) {
	 List<String> docName = addAssignmentRepository.getAllDocName(assignmentId);
		return docName;
	}

	public AssignmentDoc editAssignmentDetails(Integer assignmentId) {
		List<AssignmentDoc> assignmentDocList = new ArrayList<AssignmentDoc>();
		AssignmentDoc assignmentDoc = null;
		assignmentDocList = addAssignmentRepository.updateAssignmentDetails(assignmentId);
	    if (assignmentDocList != null && !assignmentDocList.isEmpty()){
	    	for (AssignmentDoc assignment : assignmentDocList) {
	    		assignmentDoc = (AssignmentDoc) assignment;
	    	}
	    	return assignmentDoc;
	    }
	    return null;
	}

	public void deleteAssignment(Integer assignmentId) {
		addAssignmentRepository.deleteAssignment(assignmentId);
		
	}
	
	
}
