package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.repository.LoginRepository;

@SuppressWarnings("unchecked")
@Repository
public class LoginRepositoryImpl implements LoginRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LoginRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<AdminLogin> adminSignIn(String emailId, String password) {
		if (emailId != null && password != null) {
			List<AdminLogin> login = hibernateTemplate.find(
					"from AdminLogin al where al.emailId = ? and al.password = ?", emailId, password);
			return login;
		} else {
			return null;
		}
	}

	public boolean signUp(AdminLogin login) {
		if (login != null) {
			hibernateTemplate.saveOrUpdate(login);
			return true;
		} else {
			return false;
		}
	}

}
