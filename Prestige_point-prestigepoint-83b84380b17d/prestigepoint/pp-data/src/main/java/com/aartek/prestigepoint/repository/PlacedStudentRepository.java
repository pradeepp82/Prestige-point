package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddPlacedStudent;

public interface PlacedStudentRepository {

    public List<AddPlacedStudent> getPlacedStudent();

    public List<Object> editPlacedStudent(Integer studentId);

    public void deletePlacedStudent(Integer studentId);

    public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate);

    public void savePlacedStudent(AddPlacedStudent addPlacedStudent);

}
