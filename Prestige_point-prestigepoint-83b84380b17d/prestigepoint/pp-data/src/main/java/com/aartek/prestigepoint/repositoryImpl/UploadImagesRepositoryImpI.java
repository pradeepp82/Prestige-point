package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.UploadImages;
import com.aartek.prestigepoint.repository.UploadImagesRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class UploadImagesRepositoryImpI implements UploadImagesRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UploadImages saveUploadImages(UploadImages uploadImages) {
		if (uploadImages != null) {
			hibernateTemplate.saveOrUpdate(uploadImages);
			return uploadImages;
		} else {
			return null;
		}
	}

	public List<UploadImages> getAllStudentName() {
		List<UploadImages> uploadImagesList = hibernateTemplate.find("from UploadImages where IS_DELETED="
				+ IConstant.IS_DELETED);
		return uploadImagesList;

	}

	public List<UploadImages> editUploadImagesStatus(Integer imagesId) {
		List<UploadImages> uploadImagesList = hibernateTemplate
				.find("from UploadImages a where a.imagesId=" + imagesId);
		return uploadImagesList;
	}

	public void deleteUploadImages(Integer imagesId) {
		UploadImages uploadImages = hibernateTemplate.get(UploadImages.class, imagesId);
		uploadImages.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != uploadImages) {
			hibernateTemplate.update(uploadImages);
		}

	}
}
