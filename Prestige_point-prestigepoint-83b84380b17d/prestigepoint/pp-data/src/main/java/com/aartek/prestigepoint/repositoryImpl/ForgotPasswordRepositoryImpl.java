package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.ForgotPasswordRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class ForgotPasswordRepositoryImpl implements ForgotPasswordRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ForgotPasswordRepositoryImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Registration> getPassword(String emailId) {
		List<Registration> list = hibernateTemplate.find("from Registration r where r.emailId='" + emailId
				+ "' and r.isDeleted=" + IConstant.IS_DELETED);
		return list;
	}
}
