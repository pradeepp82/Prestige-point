package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.PersuingStudent;
import com.aartek.prestigepoint.model.PlacedStudentFeeStructure;
import com.aartek.prestigepoint.repository.PersuingStudentRepository;
import com.aartek.prestigepoint.repository.PlacedStudentFeeStructureDetailRepository;
import com.aartek.prestigepoint.service.PersuingStudentService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class PersuingStudentServiceImpl implements PersuingStudentService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EnquiryServiceImpl.class);

	@Autowired
	private PersuingStudentRepository persuingStudentRepository;

	public List<PersuingStudent> getAllPersuingStudent() {
		List<PersuingStudent> persuingStudentList = persuingStudentRepository.getAllPersuingStudent();
		if (persuingStudentList != null && !persuingStudentList.isEmpty()) {
			return persuingStudentList;
		} else
			return null;
	}

	public boolean savePersuingStudentDetail(PersuingStudent persuingStudent) {
		{
			boolean status = false;
			if (persuingStudent != null) {
				persuingStudent.setIsDeleted(IConstant.IS_DELETED);
				status = persuingStudentRepository.savePersuingStudentDetail(persuingStudent);
			}
			return status;
		}
	}

	public PersuingStudent updatePersuingStudentDetail(Integer persuingStudentId) {
		PersuingStudent persuingStudentDetails = persuingStudentRepository
						.updatePersuingStudentDetail(persuingStudentId);
		if (persuingStudentDetails != null)
			return persuingStudentDetails;
		else
			return null;

	}

	public void deletePersuingStudentDetail(Integer persuingStudentId) {
		persuingStudentRepository.deletePersuingStudentDetail(persuingStudentId);

	}

}
