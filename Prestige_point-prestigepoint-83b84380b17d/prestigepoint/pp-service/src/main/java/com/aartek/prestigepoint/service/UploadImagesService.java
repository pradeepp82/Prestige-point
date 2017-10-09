package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.UploadImages;

public interface UploadImagesService {

	public boolean saveUploadImages(UploadImages uploadImages);

	public List<UploadImages> getAllUploadImages();

	public void changeUploadImagesStatus(String uploadImageIdValue, Integer uploadImageValue);

	public void deleteUploadImages(Integer imagesId);

}
