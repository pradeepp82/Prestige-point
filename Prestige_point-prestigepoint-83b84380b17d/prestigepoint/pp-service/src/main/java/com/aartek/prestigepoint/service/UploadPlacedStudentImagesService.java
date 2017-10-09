package com.aartek.prestigepoint.service;

import java.io.IOException;
import java.util.List;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;

public interface UploadPlacedStudentImagesService {

	public boolean savePlacedStudentImages(UploadPlacedStudentImages uploadPlacedStudentImages);

	public List<UploadPlacedStudentImages> getAllPlacedStudentImages() throws IOException;

}
