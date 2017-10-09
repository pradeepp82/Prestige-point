package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.StudentRegistrationRepository;
import com.aartek.prestigepoint.util.IConstant;

/**
 * @author deepak
 * 
 */
@SuppressWarnings("all")
@Repository
public class StudentRegistrationRepositoryImpl implements StudentRegistrationRepository {

	private static final Logger logger = Logger.getLogger(StudentRegistrationRepositoryImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Registration saveStudent(Registration registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
			return registration;
		} else {
			return null;
		}
	}

	public Registration editStuRegs(Integer registrationId) {
		Registration registration = hibernateTemplate.get(Registration.class, registrationId);
		registration.setIsDeleted(IConstant.IS_DELETED);
		hibernateTemplate.saveOrUpdate(registration);
		return registration;
	}

	public List<Object> studentSignIn(String emailId, String password) {
		List<Object> stuLogin = hibernateTemplate.find(
				"from Registration r where r.emailId = ? and r.password = ? and r.isDeleted=?", emailId, password,
				IConstant.IS_DELETED);
		return stuLogin;
	}

	public boolean verifyUserEmailId(String emailId) {
		List list = hibernateTemplate.find("from Registration re where re.emailId = ? and re.isDeleted=?", emailId,
				IConstant.IS_DELETED);
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}

	public Registration getStudentLogin(String emailId, String password) {
		List<Registration> stuLogin = hibernateTemplate.find(
				"from Registration r where r.emailId = ? and r.password = ? and r.isDeleted=?", emailId, password,
				IConstant.IS_DELETED);
		if (stuLogin != null) {
			return stuLogin.get(0);
		} else {
			return null;
		}
	}

	public Registration userIdVerify(Integer registrationId) {
		List<Registration> userList = hibernateTemplate.find(
				"from Registration id where id.registrationId = ? and id.isDeleted=?", registrationId,
				IConstant.IS_DELETED);
		if (!userList.isEmpty() && userList != null) {
			return userList.get(0);
		} else {
			return null;
		}
	}

	/*public List<Registration> getAllStudentImages() {
		List<Registration> userList = hibernateTemplate.find("from Registration img where img.isDeleted=?",IConstant.IS_DELETED);
		if(userList!=null){
		return userList;
		}else{
		return null;
		}
	}*/
}
