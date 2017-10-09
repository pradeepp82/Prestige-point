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
@Table(name = "dynamic_footer")
public class PhotoInFooter implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "STUDENT_ID")
  private Integer studentId;

  @Column(name = "STUDENT_NAME")
  private String studentName;

  @Column(name = "STUDENT_COMMENT")
  private String studentComment;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;
  
  @Column(name = "COMPANY_NAME")
  private String placedInCompany;
  
  @Column(name = "STUDENT_PACKAGE")
  private Double studentPackage;
  
  

public Double getStudentPackage() {
	return studentPackage;
}

public void setStudentPackage(Double studentPackage) {
	this.studentPackage = studentPackage;
}

@Column(name="IS_STATUS_ACTIVE")
  private Integer isStatusActive;
  
  
  @Transient
	private String imgPath;
  
  public String getImgPath() {
	return imgPath;
}

public void setImgPath(String imgPath) {
	this.imgPath = imgPath;
}

public Integer getIsStatusActive() {
	return isStatusActive;
}

public void setIsStatusActive(Integer isStatusActive) {
	this.isStatusActive = isStatusActive;
}

public Integer getStudentId() {
	return studentId;
}

public void setStudentId(Integer studentId) {
	this.studentId = studentId;
}



public String getStudentName() {
	return studentName;
}

public void setStudentName(String studentName) {
	this.studentName = studentName;
}

public String getStudentComment() {
	return studentComment;
}

public void setStudentComment(String studentComment) {
	this.studentComment = studentComment;
}
public Integer getIsDeleted() {
	return isDeleted;
}

public void setIsDeleted(Integer isDeleted) {
	this.isDeleted = isDeleted;
}

public String getPlacedInCompany() {
	return placedInCompany;
}

public void setPlacedInCompany(String placedInCompany) {
	this.placedInCompany = placedInCompany;
}

 
}
