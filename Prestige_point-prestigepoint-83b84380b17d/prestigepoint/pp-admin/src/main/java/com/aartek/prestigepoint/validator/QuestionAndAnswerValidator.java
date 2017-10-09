package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.aartek.prestigepoint.model.QuestionAnswer;
import com.aartek.prestigepoint.model.Registration;

@SuppressWarnings("unused")
@Component
public class QuestionAndAnswerValidator {
	public boolean supports(Class<?> clazz) {
		return QuestionAnswer.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		QuestionAnswer questionAnswer = (QuestionAnswer) target;
		ValidationUtils.rejectIfEmpty(errors, "subject", "error.subject.empty");
		if(questionAnswer.getSubject()!=null){
		if (questionAnswer.getSubject().getSubjectId() == 0) {
			errors.rejectValue("subject.subjectId", "error.subject.rule");
		}
		}
	}
}
