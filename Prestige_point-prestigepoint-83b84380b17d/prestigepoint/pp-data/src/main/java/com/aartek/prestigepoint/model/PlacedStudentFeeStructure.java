package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "placed_student_fee_structure")
public class PlacedStudentFeeStructure implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PLACED_STUDENT_ID")
	private Integer placedStudentId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "STUDENT_PACKAGE")
	private String studentPackage;
	

	
	public String getStudentPackage() {
		return studentPackage;
	}

	public void setStudentPackage(String studentPackage) {
		this.studentPackage = studentPackage;
	}



	@Column(name = "IS_DELETED")
	private Integer isDeleted;
	
	

	
	
	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}



	@Column(name = "LAST_NAME")
	private String lastName;

	public Integer getPlacedStudentId() {
		return placedStudentId;
	}

	public void setPlacedStudentId(Integer placedStudentId) {
		this.placedStudentId = placedStudentId;
	}

	@Column(name = "CONTACT_NUMBER")
	private String contactNumber;

	@Column(name = "EMAIL")
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getSubmittedFee() {
		return submittedFee;
	}

	public void setSubmittedFee(String submittedFee) {
		this.submittedFee = submittedFee;
	}

	public String getRemainingFee() {
		return remainingFee;
	}

	public void setRemainingFee(String remainingFee) {
		this.remainingFee = remainingFee;
	}

	@Column(name = "TOTLE_FEE")
	private String totalFee;

	@Column(name = "SUBMITED_FEE")
	private String submittedFee;

	@Column(name = "REMAINING_FEE")
	private String remainingFee;

	
	

}
