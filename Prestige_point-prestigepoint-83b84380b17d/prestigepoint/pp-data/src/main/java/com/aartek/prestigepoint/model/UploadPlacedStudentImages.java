package com.aartek.prestigepoint.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "upload_student_images")
public class UploadPlacedStudentImages {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_IMAGES_ID")
	private Integer studentImagesId;
	
	@Column(name = "NAME_OF_STUDENT_IMAGES")
	private String nameOfStudentImages;
	
	@Transient
	private String uploadPlacedStudentImagesPath; 
	

	public Integer getStudentImagesId() {
		return studentImagesId;
	}

	public void setStudentImagesId(Integer studentImagesId) {
		this.studentImagesId = studentImagesId;
	}

	public String getNameOfStudentImages() {
		return nameOfStudentImages;
	}

	public void setNameOfStudentImages(String nameOfStudentImages) {
		this.nameOfStudentImages = nameOfStudentImages;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUploadPlacedStudentImagesPath() {
		return uploadPlacedStudentImagesPath;
	}

	public void setUploadPlacedStudentImagesPath(String uploadPlacedStudentImagesPath) {
		this.uploadPlacedStudentImagesPath = uploadPlacedStudentImagesPath;
	}
	
	
}
