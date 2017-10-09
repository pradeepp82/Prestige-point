package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.prestigepoint.model.Registration;

@Component
public class ProfileValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		if (registration.getEmailId() != null && registration.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(registration.getEmailId());
			if (registration.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (registration.getEmailId().contains(".com") != true
					&& registration.getEmailId().contains(".net") != true && !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
		if (registration.getContact() != null && registration.getContact() != "") {
			if (registration.getContact().length() < 10) {
				errors.rejectValue("contact", "error.contactNo.length");
			}
		}
	}

}

