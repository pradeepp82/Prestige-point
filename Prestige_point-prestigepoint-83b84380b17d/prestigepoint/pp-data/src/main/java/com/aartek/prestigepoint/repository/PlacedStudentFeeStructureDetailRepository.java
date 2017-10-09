package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;

public interface PlacedStudentFeeStructureDetailRepository {
	public List<PlacedStudentFeeStructure> getAllPlacedStudentDetail();

	public boolean savePlacedStudentDetail(PlacedStudentFeeStructure placedStudentFeeStructure);

	public PlacedStudentFeeStructure updatePlacedStudentDetail(Integer placedStudentId);

	public void deletePlacedStudentDetail(Integer placedStudentId);

}
