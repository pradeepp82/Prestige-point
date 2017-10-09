package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.PhotoInFooter;
import com.aartek.prestigepoint.repository.FooterPhotoRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class FooterPhotoRepositoryImpl implements FooterPhotoRepository {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(FooterPhotoRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Get all batch name from data base.
	 */
	public List<PhotoInFooter> getAllStudentName() {
		List<PhotoInFooter> batchList = hibernateTemplate.find("from PhotoInFooter where IS_DELETED="
				+ IConstant.IS_DELETED);
		return batchList;
	}

	/**
	 * Get batch information for edit batch details.
	 */
	public List<Object> editSingleStudentDetail(Integer studentId) {
		List<Object> list = hibernateTemplate.find("from PhotoInFooter p where p.studentId=" + studentId);
		return list;
	}

	/**
	 * Method use for save batch details into database.
	 */
	public boolean saveFooterPhoto(PhotoInFooter photoInFooter) {
		if (photoInFooter != null) {
			hibernateTemplate.saveOrUpdate(photoInFooter);
			return true;
		} else {
			return false;
		}
	}

	public List<PhotoInFooter> getSingleStudentDetail(String studentId) {
		List<PhotoInFooter> photoInFooter = hibernateTemplate.find("from PhotoInFooter where STUDENT_ID=" + studentId);
		return photoInFooter;

	}

	public boolean changeStatusByStudentId(PhotoInFooter photoInFooter) {
		boolean status = false;
		{
			hibernateTemplate.saveOrUpdate(photoInFooter);
			status = true;
		}
		return status;
	}

	public boolean uncheckStatusByStudentId(PhotoInFooter photoInFooter) {
		boolean status = false;
		{
			hibernateTemplate.saveOrUpdate(photoInFooter);
			status = true;
		}
		return status;
	}

	public List<PhotoInFooter> listOfSelectedStudent() {
		List<PhotoInFooter> photoInFooters = hibernateTemplate.find("from PhotoInFooter where IS_STATUS_ACTIVE=1");
		return photoInFooters;
	}
    /**
	 * Method for delete batch information.
	 */
	public void deleteStudentData(Integer studentId) {
		PhotoInFooter photoInFooter = (PhotoInFooter) hibernateTemplate.get(PhotoInFooter.class, studentId);
		photoInFooter.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		photoInFooter.setIsStatusActive(IConstant.IS_DELETED_DEACTIVE);
		if (null != photoInFooter) {
			hibernateTemplate.update(photoInFooter);
		}
	}

}
