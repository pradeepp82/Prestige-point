/*package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.PersuingStudent;

@Component
public class PersuingStudentValidator {
	public boolean supports(Class<?> clazz) {
		return PersuingStudent.class.isAssignableFrom(clazz);
	}

	public static void validate(Object target, Errors errors) {
		PersuingStudent persuingStudent = (PersuingStudent) target;
		ValidationUtils.rejectIfEmpty(errors, "name", "error.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "qualification", "error.qualification.empty");
		ValidationUtils.rejectIfEmpty(errors, "semester", "error.semester.empty");
		ValidationUtils.rejectIfEmpty(errors, "collegeName", "error.collegeName.empty");
		if (persuingStudent.getEmail() != null && persuingStudent.getEmail().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(persuingStudent.getEmail());
			if (persuingStudent.getEmail().contains("@") != true && !b) {
				errors.rejectValue("email", "error.email.first.rule");
			} else if (persuingStudent.getEmail().contains(".com") != true
							&& persuingStudent.getEmail().contains(".net") != true
							&& persuingStudent.getEmail().contains(".co.in") != true && !b) {
				errors.rejectValue("email", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("email", "error.email.required");
			}
		}
		if (persuingStudent.getContact() != null && persuingStudent.getContact() != "") {
			if (persuingStudent.getContact().length() < 10) {
				errors.rejectValue("contact", "error.contact.length");
			}
		}

	}

}
*/