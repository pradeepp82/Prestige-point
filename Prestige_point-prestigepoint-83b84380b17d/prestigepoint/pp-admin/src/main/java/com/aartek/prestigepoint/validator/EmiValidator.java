package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.Emi;

@Component
public class EmiValidator {
	public boolean supports(Class<?> clazz) {
		return Emi.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "date", "error.date.empty");

	}
}
