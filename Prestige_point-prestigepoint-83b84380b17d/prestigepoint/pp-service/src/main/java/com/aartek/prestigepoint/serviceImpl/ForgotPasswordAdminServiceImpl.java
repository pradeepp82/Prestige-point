package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AdminLogin;
import com.aartek.prestigepoint.repository.ForgotPasswordAdminRepository;
import com.aartek.prestigepoint.service.ForgotPasswordAdminService;
import com.aartek.prestigepoint.util.SendMail;

@SuppressWarnings("unused")
@Service
public class ForgotPasswordAdminServiceImpl implements ForgotPasswordAdminService {

	private static final Logger logger = Logger.getLogger(ForgotPasswordAdminServiceImpl.class);

	@Autowired
	private ForgotPasswordAdminRepository forgotPasswordRepository;

	public boolean getPassword(String emailId) {
		List<AdminLogin> list = forgotPasswordRepository.getPassword(emailId);
		if (list != null && !list.isEmpty()) {
			AdminLogin adminLogin = list.get(0);
			SendMail.forgotPasswordAdmin(adminLogin.getEmailId(), adminLogin.getPassword());
			return true;
		} else {
			return false;
		}
	}
}
