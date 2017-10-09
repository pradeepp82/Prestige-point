package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.model.UploadImages;
import com.aartek.prestigepoint.repository.ScrollerRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class ScrollerRepositoryImpl implements ScrollerRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ScrollerRepositoryImpl.class);
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Get all batch name from data base.
	 */
	public List<Scroller> getAllImage() {
		List<Scroller> imageList = hibernateTemplate.find("from Scroller where IS_DELETED=" + IConstant.IS_DELETED);
		return imageList;
	}

	/**
	 * Method use for save batch details into database.
	 */
	public boolean saveScrollerPhoto(Scroller scroller) {
		if (scroller != null) {
			hibernateTemplate.saveOrUpdate(scroller);
			return true;
		} else {
			return false;
		}

	}

	public void deleteScrollerImage(Integer imageId) {
		Scroller scroller = hibernateTemplate.get(Scroller.class, imageId);
		scroller.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != scroller) {
			hibernateTemplate.update(scroller);
		}
	}

	public List<Scroller> getSingleScrollDetail(String imageId) {
		List<Scroller> scrollers = hibernateTemplate.find("from Scroller where IMAGE_ID=" + imageId);
		return scrollers;
	}

	public List<Object> editSingleStudentDetail(Integer studentId) {
		return null;
	}

	public boolean changeStatusByImageId(Scroller scroller) {
		boolean status = false;
		{
			hibernateTemplate.saveOrUpdate(scroller);

			status = true;
		}
		return status;
	}

	public boolean uncheckStatusByImageId(Scroller scroller) {
		boolean status = false;
		{
			hibernateTemplate.saveOrUpdate(scroller);
			status = true;
		}
		return status;
	}

	public List<Scroller> getAllScrollImages() {
		List<Scroller> scrollers = null;
		scrollers = hibernateTemplate.find("from Scroller s where s.isDeleted=" + IConstant.IS_DELETED
				+ "and s.isStatusActive=" + IConstant.IS_Active);
		return scrollers;
	}

	public List<UploadImages> viewUploadImages() {
		List<UploadImages> getUploadImages = hibernateTemplate.find("from UploadImages ac where ac.isDeleted="
				+ IConstant.IS_DELETED + "and ac.isActive=" + IConstant.IS_DELETED);
		return getUploadImages;
	}

}
