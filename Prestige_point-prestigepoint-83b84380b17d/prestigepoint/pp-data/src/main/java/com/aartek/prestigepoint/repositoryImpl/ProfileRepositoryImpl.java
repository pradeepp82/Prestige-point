package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.ProfileRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ProfileRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Registration> getStudentDetails(int registrationId) {
		List<Registration> list = hibernateTemplate.find("from Registration r where r.registrationId=" + registrationId
				+ " and r.isDeleted=" + IConstant.IS_DELETED);
		return list;
	}

	public boolean updateProfile(Registration registration) {
		if (registration != null) {
			Registration registration1 = (Registration) hibernateTemplate.get(Registration.class,
					registration.getRegistrationId());
			registration1.setFirstName(registration.getFirstName());
			registration1.setLastName(registration.getLastName());
			registration1.setEmailId(registration.getEmailId());
			registration1.setDateOfBirth(registration.getDateOfBirth());
			registration1.setContact(registration.getContact());
			registration1.setQualification(registration.getQualification());
			registration1.setState(registration.getState());
			registration1.setCity(registration.getCity());
			hibernateTemplate.saveOrUpdate(registration1);
			return true;
		} else {
			return false;
		}
	}
	
	public List<Registration> verifyPassword(String password, Integer registrationId) {
		List<Registration> list  =hibernateTemplate.find("from Registration p where p.registrationId=" + registrationId + " and p.password= " + password + " and p.isDeleted=" + IConstant.IS_DELETED);
		if(list!=null){
			return list;
		}else{
		return null;
	}
}
	
	public boolean saveChangePassword(Registration password) {
		if(password!=null){
		hibernateTemplate.saveOrUpdate(password);
		return true;
		}else{
		return false;
		}
	}

	public List<Registration> verifyRegistrationId(Integer registrationId) {
		List<Registration> list  =hibernateTemplate.find("from Registration rg where rg.registrationId=" + registrationId
				+ " and rg.isDeleted=" + IConstant.IS_DELETED);
		if(list!=null){
			return list;
		}else{
		return null;
	}
}
}