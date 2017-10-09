package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.PersuingStudent;

public interface PersuingStudentRepository {

	List<PersuingStudent> getAllPersuingStudent();

	boolean savePersuingStudentDetail(PersuingStudent persuingStudent);

	

	void deletePersuingStudentDetail(Integer persuingStudentId);

	PersuingStudent updatePersuingStudentDetail(Integer persuingStudentId);

}
