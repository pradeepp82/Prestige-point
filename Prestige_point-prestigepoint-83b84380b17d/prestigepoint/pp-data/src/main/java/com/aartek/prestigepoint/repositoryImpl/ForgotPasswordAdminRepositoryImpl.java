package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.repository.ForgotPasswordAdminRepository;
@SuppressWarnings("unchecked")
@Repository
public class ForgotPasswordAdminRepositoryImpl implements ForgotPasswordAdminRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ForgotPasswordAdminRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<AdminLogin> getPassword(String emailId) {
		List<AdminLogin> list = hibernateTemplate.find("from AdminLogin a where a.emailId='" + emailId + "' ");
		return list;
	}

}
