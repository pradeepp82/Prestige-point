package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;

@Component
public class PlacedStudentFeeStructureValidator {
	
	
	public boolean supports(Class<?> clazz) {
		return PlacedStudentFeeStructure.class.isAssignableFrom(clazz);
	}

	public static void validate(Object target, Errors errors) {
		PlacedStudentFeeStructure placedStudentFeeStructure = (PlacedStudentFeeStructure) target;
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "contactNumber", "error.contactNumber.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "totalFee", "error.totalFee.empty");
		ValidationUtils.rejectIfEmpty(errors, "submittedFee", "error.submittedFee.empty");
		ValidationUtils.rejectIfEmpty(errors, "studentPackage", "error.studentPackage.empty");
		
		if (placedStudentFeeStructure.getEmail() != null && placedStudentFeeStructure.getEmail().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(placedStudentFeeStructure.getEmail());
			if (placedStudentFeeStructure.getEmail().contains("@") != true && !b) {
				errors.rejectValue("email", "error.email.first.rule");
			} else if (placedStudentFeeStructure.getEmail().contains(".com") != true
					&& placedStudentFeeStructure.getEmail().contains(".net") != true
					&& placedStudentFeeStructure.getEmail().contains(".co.in") != true && !b) {
				errors.rejectValue("email", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("email", "error.email.required");
			}
		}
		if (placedStudentFeeStructure.getContactNumber() != null && placedStudentFeeStructure.getContactNumber() != "") {
			if (placedStudentFeeStructure.getContactNumber().length() < 10) {
				errors.rejectValue("contactNumber", "error.contactNo.length");
			}
		}
	
	
	}
}


