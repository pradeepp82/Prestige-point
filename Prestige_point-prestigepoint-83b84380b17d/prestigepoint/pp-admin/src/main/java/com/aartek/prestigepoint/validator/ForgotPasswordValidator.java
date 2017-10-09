package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.aartek.prestigepoint.model.AdminLogin;

@Component
public class ForgotPasswordValidator {
	public boolean supports(Class<?> clazz) {
		return AdminLogin.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		AdminLogin login = (AdminLogin) target;
		if (login.getEmailId() != null && login.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(login.getEmailId());
			if (login.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (login.getEmailId().contains(".com") != true && login.getEmailId().contains(".net") != true
					&& login.getEmailId().contains(".co.in") != true && !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
	}
}
