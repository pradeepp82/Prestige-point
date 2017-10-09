package com.aartek.prestigepoint.repositoryImpl;


import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.Param;

import com.aartek.prestigepoint.model.City;
import com.aartek.prestigepoint.model.Reference;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.RegistrationRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class RegistrationRepositoryImpl implements RegistrationRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(RegistrationRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Registration saveStudentDeatils(Registration registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
		
			return registration;
		} else {
			return null;
		}
	}

	public List<Registration> getAllStudentDetails() {
		List<Registration> studentList = hibernateTemplate.find("from Registration  where IS_DELETED="
				+ IConstant.IS_DELETED + "order by firstName");
		return studentList;
	}

	public List<Registration> getStudentDetailsByName(String firstName) {

		List<Registration> studentList = hibernateTemplate.find("from Registration r  where  (r.firstName='"
				+ firstName + "' or  r.firstName LIKE '%" + firstName + "%') and  r.isDeleted=" + IConstant.IS_DELETED
				+ "order by firstName");
		return studentList;
	}

	public List<Registration> getCourseWiseStudentDetails(Integer courseId) {
		List<Registration> studentList = hibernateTemplate.find("from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED + " and r.course.courseId=" + courseId +"order by firstName");
		return studentList;
	}

	public List<Registration> getBatchWiseStudentDetails(Integer batchId) {
		List<Registration> studentList = hibernateTemplate.find("from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED + " and r.batch.batchId=" + batchId +"order by firstName");
		return studentList;
	}

	public List<String> getallStudentEmailId() {
		List<String> emailList = hibernateTemplate.find("select r.emailId from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED);
		return emailList;
	}

	public List<String> getallEnquiryEmailId() {
		List<String> emailList = hibernateTemplate.find("select e.emailId from Enquiry e where e.isDeleted="
				+ IConstant.IS_DELETED);
		return emailList;
	}

	public List<Registration> makeAsPaidUser(Integer registrationId) {
		List<Registration> student = hibernateTemplate.find("from Registration r where r.isDeleted=" + IConstant.IS_DELETED
				+ " and r.registrationId=" + registrationId);
		return student;
	}

	public Registration updateStudentAsPaid(Registration registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
			return registration;
		} else {
			return null;
		}
	}

	public List<Registration> editStudentDetails(Integer registrationId) {
		List<Registration> list = hibernateTemplate
				.find("from Registration r where r.registrationId=" + registrationId);
		return list;
	}

	public void deleteStudentDetails(Integer registrationId) {
		Registration registration = (Registration) hibernateTemplate.get(Registration.class, registrationId);
		registration.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != registration) {
			hibernateTemplate.update(registration);
		}
	}

	public boolean verifyUserEmailId(String emailId) {
		@SuppressWarnings("rawtypes")
		List list = hibernateTemplate.find("from Registration re where re.emailId = ? and re.isDeleted=?", emailId,
				IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<Registration> getStudentDetails(String emailId) {
		List<Registration> list = hibernateTemplate.find("from Registration e where e.emailId = ? and e.isDeleted=?",
				emailId, IConstant.IS_DELETED);
		if (list != null)
			return list;
		else
			return null;
	}

	public List<Reference> getAllReference() {
		
		
		List<Reference> referenceList = hibernateTemplate.find("from Reference");
		if(referenceList!=null)
		return referenceList;
		else
			return null;
		
	}

	/*public List<Registration> getByCurrentStatus(Integer current_status_Id) {
		List<Registration> studentList = hibernateTemplate.find("from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED + " and r.currentStatus.current_status_Id=" + current_status_Id +"order by firstName");
		return studentList;
	}*/

	/**
	 * @author patidar
	 * @param enrollmentNo
	 * {@link Return} boolean
	 */
	public boolean verifyUserenrollmentNo(String enrollmentNo) {
		@SuppressWarnings("rawtypes")
		List list = hibernateTemplate.find("from Registration re where re.enrollmentNo = ? and re.isDeleted=?", enrollmentNo,
				IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * @author patidar
	 * {@link Param} contactNo
	 * {@link Return} Boolean
	 */
	public boolean verifyUserContactNo(String contactNo) {
		@SuppressWarnings("rawtypes")
		List list = hibernateTemplate.find("from Registration re where re.contact = ? and re.isDeleted=?", contactNo,
				IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return true;
		}
		return false;
}

	public List<Registration> getPersuingStudent(String persuing) {
		List<Registration>persuingList=hibernateTemplate.find("from Registration re where re.persuing =? and re.isDeleted =?" ,IConstant.IS_PERSUING,IConstant.IS_DELETED);
		
				return persuingList;
	}

	/*public List<Registration> getCourseAndBatchWise(Course course, Batch batch) {
		List<Registration> studentDetails =hibernateTemplate.find("from Registration re where re.course =? ,re.batch =?and re.isDeleted =?",batch,course,IConstant.IS_DELETED);
		return studentDetails;
	}
*/
	public List<Registration> getCourseAndBatchWise(Integer courseId,
			Integer batchId) {
		
		List<Registration> studentDetails = hibernateTemplate.find("from Registration r where r.isDeleted="
				+ IConstant.IS_DELETED + " and r.course.courseId=" + courseId + " and r.batch.batchId=" + batchId + "order by firstName");
		return studentDetails;
		
	}

	public List<City> getAllCity() {
		List<City> cityList = hibernateTemplate.find("from City");
		if(cityList!=null)
		return cityList;
		else
			return null;
		
	}

	/*public List<Qualification> getAllQualification() {
		List<Qualification> qualificationList = hibernateTemplate.find("from Qualification qs where qs.isDeleted="+ IConstant.IS_DELETED);
		return qualificationList;
	}*/
}
