package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.Registration;



@Component
public class RegistrationValidator {

	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "qualification", "error.qualification.empty");
		/*ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "error.dateOfBirth.empty");*/
		ValidationUtils.rejectIfEmpty(errors, "totalFee", "error.totalFee.empty");
		ValidationUtils.rejectIfEmpty(errors, "submittedFee", "error.submittedFee.empty");
		/*ValidationUtils.rejectIfEmpty(errors, "parentContact", "error.parentContact.empty");*/
		if (registration.getEmailId() != null && registration.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(registration.getEmailId());
			if (registration.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.email.first.rule");
			} else if (registration.getEmailId().contains(".com") != true
					&& registration.getEmailId().contains(".net") != true
					&& registration.getEmailId().contains(".co.in") != true && !b) {
				errors.rejectValue("emailId", "error.email.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
		if (registration.getCourse() != null) {
			if (registration.getCourse().getCourseId() == 0) {
				errors.rejectValue("course.courseId", "error.course.rule");
			}
		}
		/*if (registration.getYear() != null) {
			if (registration.getYear().getYearId() == 0) {
				errors.rejectValue("year.yearId", "error.year.rule");
			}
		}*/
		/*if (registration.getCurrentStatus() != null) {
			if (registration.getCurrentStatus().getCurrent_status_Id() == 0) {
				errors.rejectValue("currentStatus.current_status_Id", "error.status.rule");
			}
		}*/
		if (registration.getBatch() != null) {
			if (registration.getBatch().getBatchId() == 0) {
				errors.rejectValue("batch.batchId", "error.batch.rule");
			}
		}
		if (registration.getContact() != null && registration.getContact() != "") {
			if (registration.getContact().length() < 10) {
				errors.rejectValue("contact", "error.contactNo.length");
			}
		}
		/*if (registration.getParentContact() != null && registration.getParentContact() != "") {
			if (registration.getParentContact().length() < 10) {
				errors.rejectValue("parentContact", "error.parentContact.length");
			}
		}*/
		
		if (registration.getReference() != null) {
			if (registration.getReference().getReferenceId() == 0) {
				errors.rejectValue("reference.referenceId", "error.reference.rule");
			}

		}	
		
		
		
		
	/*	if (registration.getDateOfBirth() != null && registration.getDateOfBirth() != "") {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateOfBirth = registration.getDateOfBirth();
			String currentDate = sdf.format(date).toString();
			try {
				Calendar cal1 = new GregorianCalendar();
				Calendar cal2 = new GregorianCalendar();
				int age = 0;
				int factor = 0;
				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
				Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(currentDate);
				cal1.setTime(date1);
				cal2.setTime(date2);
				if (cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
					factor = -1;
				}
				age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
				if (age <= 13) {
					errors.rejectValue("dateOfBirth", "error.age.empty");
				}
			} catch (ParseException e) {
				System.out.println(e);
			}
		}*/
	}
}
