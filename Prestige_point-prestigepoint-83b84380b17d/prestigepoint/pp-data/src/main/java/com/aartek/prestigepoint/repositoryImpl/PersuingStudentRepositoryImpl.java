package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.PersuingStudent;
import com.aartek.prestigepoint.repository.PersuingStudentRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class PersuingStudentRepositoryImpl implements PersuingStudentRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<PersuingStudent> getAllPersuingStudent() {
		List<PersuingStudent> persuingStudentList = hibernateTemplate
						.find("from PersuingStudent ps where ps.isDeleted=" + IConstant.IS_DELETED);
		return persuingStudentList;
	}

	public boolean savePersuingStudentDetail(PersuingStudent persuingStudent) {
		if (persuingStudent != null) {
			hibernateTemplate.saveOrUpdate(persuingStudent);
			return true;
		}
		return false;
	}

	public void deletePersuingStudentDetail(Integer persuingStudentId) {
		PersuingStudent persuingStudent = hibernateTemplate.get(PersuingStudent.class, persuingStudentId);
		persuingStudent.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (persuingStudent != null) {
			hibernateTemplate.update(persuingStudent);
		}

	}

	public PersuingStudent updatePersuingStudentDetail(Integer persuingStudentId) {
		PersuingStudent persuingStudentDetails = hibernateTemplate.get(PersuingStudent.class, persuingStudentId);
		return persuingStudentDetails;
	}

}
