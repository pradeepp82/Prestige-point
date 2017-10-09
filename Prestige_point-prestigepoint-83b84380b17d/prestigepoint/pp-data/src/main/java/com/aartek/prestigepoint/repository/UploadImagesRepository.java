package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.UploadImages;

public interface UploadImagesRepository {

	public UploadImages saveUploadImages(UploadImages uploadImages);

	public List<UploadImages> getAllStudentName();

	public List<UploadImages> editUploadImagesStatus(Integer imagesId);

	public void deleteUploadImages(Integer imagesId);

}
