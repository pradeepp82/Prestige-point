package com.aartek.prestigepoint.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.aartek.prestigepoint.model.AssignmentDoc;

@Component
public class AssignmentValidator {

	public boolean supports(Class<?> clazz) {
		return AssignmentDoc.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		AssignmentDoc assignmentDoc = (AssignmentDoc) target;
		if (assignmentDoc.getAddAssignment().getSubject() != null) {
			if (assignmentDoc.getAddAssignment().getSubject().getSubjectId()== 0) {
				errors.rejectValue("addAssignment.subject.subjectId", "error.subject.rule");
			}
		}
	}

}
