package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "upload_images")
public class UploadImages implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IMAGES_ID")
	private Integer imagesId;

	@Column(name = "NAME_OF_IMAGES")
	private String nameOfimages;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Column(name = "IS_ACTIVE")
	private Integer isActive;

	@Transient
	private String uploadImagesPath; 
	
	public String getUploadImagesPath() {
		return uploadImagesPath;
	}

	public void setUploadImagesPath(String uploadImagesPath) {
		this.uploadImagesPath = uploadImagesPath;
	}

	public Integer getImagesId() {
		return imagesId;
	}

	public void setImagesId(Integer imagesId) {
		this.imagesId = imagesId;
	}

	public String getNameOfimages() {
		return nameOfimages;
	}

	public void setNameOfimages(String nameOfimages) {
		this.nameOfimages = nameOfimages;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}


}