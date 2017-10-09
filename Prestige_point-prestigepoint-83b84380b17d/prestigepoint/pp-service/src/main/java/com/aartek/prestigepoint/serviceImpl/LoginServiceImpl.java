package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.repository.LoginRepository;
import com.aartek.prestigepoint.service.LoginService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class LoginServiceImpl implements LoginService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginRepository loginRepository;

	public AdminLogin userSignIn(AdminLogin login) {
		List<AdminLogin> list = loginRepository.adminSignIn(login.getEmailId(), login.getPassword());
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public boolean signUp(AdminLogin login) {
		boolean status = false;
		if (login != null) {
			login.setIsDeleted(IConstant.IS_DELETED);
			login.setStatusId("1");
			status = loginRepository.signUp(login);
			return status;
		} else {
			return status;
		}
	}
}
