package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persuing_students")
public class PersuingStudent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSUING_STUDENT_ID")
	private Integer persuingStudentId;

	@OneToOne
	@JoinColumn(name = "REGISTRATION_ID") 
	private Registration registration;
	
	/*@Column(name = "NAME")
	private String name;*/
	
	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Integer getPersuingStudentId() {
		return persuingStudentId;
	}

	public void setPersuingStudentId(Integer persuingStudentId) {
		this.persuingStudentId = persuingStudentId;
	}

	

	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	/*public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
*/
	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	/*public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}*/

	/*@Column(name = "CONTACT")
	private String contact;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "QUALIFICATION")
	private String qualification;*/
	
	@Column(name = "SEMESTER")
	private String semester;
	/*
	@Column(name = "COLLEGE_NAME")
	private String collegeName;*/

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	
	
	
	
}
