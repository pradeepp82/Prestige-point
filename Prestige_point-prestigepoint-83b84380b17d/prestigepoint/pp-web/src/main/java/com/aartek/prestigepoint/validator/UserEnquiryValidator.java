package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.Enquiry;

@Component
public class UserEnquiryValidator {

	public boolean supports(Class<?> clazz) {
		return Enquiry.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Enquiry enquiry = (Enquiry) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "error.name.empty");
		if (enquiry.getEmailId() != null && enquiry.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(enquiry.getEmailId());
			if (enquiry.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (enquiry.getEmailId().contains(".com") != true && enquiry.getEmailId().contains(".net") != true
					&& enquiry.getEmailId().contains(".co.in") != true && !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
		if (enquiry.getMobileNo() != null && enquiry.getMobileNo() != "") {
			if (enquiry.getMobileNo().length() < 10) {
				errors.rejectValue("mobileNo", "error.mobileNo.length");
			}
		}
	}
}
