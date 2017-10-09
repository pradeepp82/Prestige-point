package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.Enquiry;

@Component
public class EnquiryValidator {

	public boolean supports(Class<?> clazz) {
		return Enquiry.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Enquiry enquiry = (Enquiry) target;
		ValidationUtils.rejectIfEmpty(errors, "date", "error.enquiry.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "mobileNo", "error.mobileNo.empty");
		ValidationUtils.rejectIfEmpty(errors, "referenceMobileNo", "error.referenceMobileNo.empty");

		if (enquiry.getMobileNo() != null && enquiry.getMobileNo() != "") {
			if (enquiry.getMobileNo().length() < 10) {
				errors.rejectValue("mobileNo", "error.mobileNoEnquiry.length");
			}
		}
		if (enquiry.getTrainingType() != null) {
			if (enquiry.getTrainingType() == 0) {
				errors.rejectValue("trainingType", "error.trainingType.rule");
			}
		}
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
		if (enquiry.getReferenceMobileNo() != null && enquiry.getReferenceMobileNo() != "") {
			if (enquiry.getMobileNo().length() < 10) {
				errors.rejectValue("referenceMobileNo", "error.ReferenceMobileNo.length");
			}
			if (enquiry.getReference() != null) {
				if (enquiry.getReference().getReferenceId() == 0) {
					errors.rejectValue("reference.referenceId", "error.reference.rule");
				}

			}
		}
	}
}
