package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;
import com.aartek.prestigepoint.repository.UploadPlacedStudentImagesRepository;

@SuppressWarnings("unchecked")
@Repository
public class UploadPlacedStudentImagesRepositoryImpl implements UploadPlacedStudentImagesRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public UploadPlacedStudentImages savePlacedStudentImages(UploadPlacedStudentImages uploadPlacedStudentImages) {
		if (uploadPlacedStudentImages != null) {
			hibernateTemplate.saveOrUpdate(uploadPlacedStudentImages);
			return uploadPlacedStudentImages;
		} else {
			return null;
		}
	}

	public List<UploadPlacedStudentImages> getAllPlacedStudentImages() {
		List<UploadPlacedStudentImages> PlacedStudentImagesList = hibernateTemplate
				.find("from UploadPlacedStudentImages");
		if (PlacedStudentImagesList != null) {
			return PlacedStudentImagesList;
		} else {
			return null;
		}
	}

}
