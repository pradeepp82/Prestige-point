package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.PersuingStudent;

public interface PersuingStudentService {

	List<PersuingStudent> getAllPersuingStudent();

	boolean savePersuingStudentDetail(PersuingStudent persuingStudent);

	PersuingStudent updatePersuingStudentDetail(Integer persuingStudentId);

	void deletePersuingStudentDetail(Integer persuingStudentId);

}
