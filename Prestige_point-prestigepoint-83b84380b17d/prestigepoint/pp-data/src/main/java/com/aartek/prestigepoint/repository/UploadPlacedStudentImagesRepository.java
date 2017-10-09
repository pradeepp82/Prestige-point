package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;

public interface UploadPlacedStudentImagesRepository {

public UploadPlacedStudentImages savePlacedStudentImages(UploadPlacedStudentImages uploadPlacedStudentImages);

public List<UploadPlacedStudentImages> getAllPlacedStudentImages();

}
