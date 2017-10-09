package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AddPlacedStudent;
import com.aartek.prestigepoint.repository.PlacedStudentRepository;
import com.aartek.prestigepoint.service.PlacedStudentService;
import com.aartek.prestigepoint.util.DateFormat;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class PlacedStudentServiceImp implements PlacedStudentService {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PlacedStudentServiceImp.class);
	@Autowired
	private PlacedStudentRepository placedStudentRepository;

	public java.util.List<AddPlacedStudent> getPlacedStudent() {
		List<AddPlacedStudent> list = new ArrayList<AddPlacedStudent>();
		list = placedStudentRepository.getPlacedStudent();
		return list;
	}

	public AddPlacedStudent editPlacedStudent(Integer studentId) {
		List<Object> list = new ArrayList<Object>();
		AddPlacedStudent addPlacedStudent = null;
		list = placedStudentRepository.editPlacedStudent(studentId);
		for (Object object : list) {
			addPlacedStudent = (AddPlacedStudent) object;
		}
		list = null;// it is used for memory save
		return addPlacedStudent;

	}

	/*
	 * getPlacedStudentDetails is used for change the format of date
	 */
	public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate) {
		List<AddPlacedStudent> placedStudentList = placedStudentRepository.generatePlacedStudentReportMonthlyWise(
				DateFormat.getMMDDYYYYDateFormat(fromDate), DateFormat.getMMDDYYYYDateFormat(toDate));
		return placedStudentList;

	}

	public boolean savePlacedStudent(AddPlacedStudent addPlacedStudent) {
		addPlacedStudent.setIsDeleted(IConstant.IS_DELETED);
		addPlacedStudent.setReleaseDateFromAartek(DateFormat.getMMDDYYYYDateFormat(addPlacedStudent
				.getReleaseDateFromAartek()));
		placedStudentRepository.savePlacedStudent(addPlacedStudent);
		return true;

	}

	public void deletePlacedStudent(Integer studentId) {
		placedStudentRepository.deletePlacedStudent(studentId);
	}

}
