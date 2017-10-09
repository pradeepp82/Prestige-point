package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.AdminLogin;

@Component
public class SignUpValidator{

	public boolean supports(Class<?> clazz) {
		return AdminLogin.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		AdminLogin login = (AdminLogin) target;
	   ValidationUtils.rejectIfEmpty(errors, "contactNo", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email.empty");
		 ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");
			ValidationUtils.rejectIfEmpty(errors, "lastName", "error.firstName.empty");
			ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
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
		if (login.getContactNo() != null && login.getContactNo() != "") {
			if (login.getContactNo().length() < 10) {
				errors.rejectValue("contactNo", "error.contactAdminNo.length");
			}
		}
		if(login.getadminType()!=null)
		{
			if (login.getadminType() == 0) {
				errors.rejectValue("adminType", "error.adminType.rule");
			}
		}
	}
}