package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.AddPlacedStudent;

public interface PlacedStudentService {

	java.util.List<AddPlacedStudent> getPlacedStudent();

	public boolean savePlacedStudent(AddPlacedStudent addPlacedStudent);

	public AddPlacedStudent editPlacedStudent(Integer studentId);

	public void deletePlacedStudent(Integer studentId);

	public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate);

}
