//package com.aartek.prestigepoint.repositoryImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate3.HibernateTemplate;
//import org.springframework.stereotype.Service;
//
//import com.aartek.prestigepoint.model.Reference;
//import com.aartek.prestigepoint.model.Registration;
//import com.aartek.prestigepoint.repository.RegistrationRepository;
//import com.aartek.prestigepoint.repository.SendMessageRepository;
//import com.aartek.prestigepoint.util.IConstant;
//
//@Service
//public class SendMessageRepositoryImpl implements 
//		RegistrationRepository {
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
//
//	public Registration saveStudentDeatils(Registration registration) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Registration> getAllStudentDetails() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Registration> getCourseWiseStudentDetails(Integer courseId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Registration> getBatchWiseStudentDetails(Integer batchId) {
//		List<Registration> studentList = hibernateTemplate.find("from Registration r where r.isDeleted="
//				+ IConstant.IS_DELETED + " and r.batch.batchId=" + batchId);
//		return studentList;
//}
//
//
//	public List<String> getallStudentEmailId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<String> getallEnquiryEmailId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Registration> makeAsPaidUser(Integer registrationId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Registration updateStudentAsPaid(Registration registration) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Registration> editStudentDetails(Integer registrationId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void deleteStudentDetails(Integer registrationId) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public List<Registration> getStudentDetailsByName(String firstName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public boolean verifyUserEmailId(String emailId) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public List<Registration> getStudentDetails(String emailId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Reference> getAllReference() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//
///