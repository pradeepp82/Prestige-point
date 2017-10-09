package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "placed_student")
public class AddPlacedStudent implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private Integer studentId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "PACKAGE")
	private String studentPackage;

	@Column(name = "JOINING_DATE")
	private String joiningDate;

	@Column(name = "RELEASE_DATE_FROM_AARTEK")
	private String releaseDateFromAartek;

	@Column(name = "JOB_LOCATION")
	private String jobLocation;

	@Column(name = "EXPERIENCE")
	private String experience;

	@Column(name = "YEAR")
	private String year;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@ManyToOne
	@JoinColumn(name = "REGISTRATION_ID")
	private Registration registration;

	@Transient
	private String fromDate;

	@Transient
	private String toDate;

	@Transient
	private String searchType;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getReleaseDateFromAartek() {
		return releaseDateFromAartek;
	}

	public void setReleaseDateFromAartek(String releaseDateFromAartek) {
		this.releaseDateFromAartek = releaseDateFromAartek;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public String getStudentPackage() {
		return studentPackage;
	}

	public void setStudentPackage(String studentPackage) {
		this.studentPackage = studentPackage;
	}
}
