package com.aartek.prestigepoint.model;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "registration")
public class Registration implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Integer emiId = null;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REGISTRATION_ID")
	private Integer registrationId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "HANDLEDBY")
	private String handledBy;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "PARENT_CONTACT")
	private String parentContact;

	@Column(name = "COURSE_FEE")
	private Integer courseFee;

	@Column(name = "DISCOUNT")
	private Integer discount;

	@Column(name = "TOTAL_FEE")
	private Double totalFee;

	@Column(name = "SUBMITTED_FEE")
	private Integer submittedFee;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Column(name = "COLLEGE_NAME")
	private String collegeName;

	@Column(name = "PERCENTAGE")
	private Double percentage;

	@Column(name = "ID_NUMBER")
	private String idNumber;

	@Column(name = "10_MARKSHEET")
	private String tenthMarksheet;

	@Column(name = "12_MARKSHEET")
	private String twelfthMarksheet;

	@Column(name = "GRADUATION")
	private String graduation;

	@Column(name = "ID_PREOOF")
	private String idProof;

	@Column(name = "GCM_ID")
	private String gcmId;
	
	@Column(name = "ENROLLMENT_NO")
	private String enrollmentNo;
	
	@Column(name = "SEMESTER")
	private Integer semester;

	@Column(name = "PERSUING")
	private String persuing;
	

// 24-6-2016  neha rajput 
	
	
	@Column(name = "REFERENCE_NAME")
	private String referenceName;
	
	@Column(name = "PG_MARKSHEET")
	private String pgMaeksheet;

	
	public String getPgMaeksheet() {
		return pgMaeksheet;
	}

	public void setPgMaeksheet(String pgMaeksheet) {
		this.pgMaeksheet = pgMaeksheet;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	public String getPersuing() {
		return persuing;
	}

	public void setPersuing(String persuing) {
		this.persuing = persuing;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public String getEnrollmentNo() {
		return enrollmentNo;
	}

	public void setEnrollmentNo(String enrollmentNo) {
		this.enrollmentNo = enrollmentNo;
	}

	@Transient
	private String newPassword;


	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getGcmId() {
		return gcmId;
	}

	public void setGcmId(String gcmId) {
		this.gcmId = gcmId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getTenthMarksheet() {
		return tenthMarksheet;
	}

	public void setTenthMarksheet(String tenthMarksheet) {
		this.tenthMarksheet = tenthMarksheet;
	}

	public String getTwelfthMarksheet() {
		return twelfthMarksheet;
	}

	public void setTwelfthMarksheet(String twelfthMarksheet) {
		this.twelfthMarksheet = twelfthMarksheet;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Integer getEmiid() {
		return emiId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REFERENCE_ID")
	private Reference reference;

	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "YEAR_ID")
	private Year year;
	
	@ManyToOne
	@JoinColumn(name = "CITY_id")
	private City cities;

	public City getCities() {
		return cities;
	}

	public void setCities(City cities) {
		this.cities = cities;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@ManyToOne
	@JoinColumn(name = "BATCH_ID")
	private Batch batch;

	@ManyToOne
	@JoinColumn(name = "CURRENT_STATUS_ID")
	private CurrentStatus currentStatus;
	
	
	/*@ManyToOne
	@JoinColumn(name = "QUALIFICATION_ID")
	private Qualification qualifications;
	
	
	

	public Qualification getQualifications() {
		return qualifications;
	}

	public void setQualifications(Qualification qualifications) {
		this.qualifications = qualifications;
	}*/

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "REGISTRATION_ID")
	private List<Emi> emiList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "REGISTRATION_ID", updatable = false)
	private List<AddPlacedStudent> AddPlacedStudentList;

	public List<AddPlacedStudent> getAddPlacedStudentList() {
		return AddPlacedStudentList;
	}

	public void setAddPlacedStudentList(List<AddPlacedStudent> addPlacedStudentList) {
		AddPlacedStudentList = addPlacedStudentList;
	}

	@Transient
	private String searchType;

	@Transient
	private String imgPath;

	/*
	 * @Transient private String mail;
	 */

	@Transient
	private String attachFile;

	/*
	 * @Transient private String mailPath;
	 * 
	 * public String getMailPath() { return mailPath; }
	 * 
	 * public void setMailPath(String mailPath) { this.mailPath = mailPath; }
	 */
	@Transient
	private List<File> files;

	@Column(name = "IMAGE_PATH")
	private String imagePath;

	@Transient
	private String subject;

	@Transient
	private String message;

	@Transient
	private String allStudent;

	@Transient
	private String allEnquiry;

	@Column(name = "STATUS")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PASSWORD")
	private String password;

	/**
	 * @return the registrationId
	 */
	public Integer getRegistrationId() {
		return registrationId;
	}

	/**
	 * @param registrationId
	 *            the registrationId to set
	 */
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}

	/**
	 * @param qualification
	 *            the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the parentContact
	 */
	public String getParentContact() {
		return parentContact;
	}

	/**
	 * @param parentContact
	 *            the parentContact to set
	 */
	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the courseFee
	 */
	public Integer getCourseFee() {
		return courseFee;
	}

	/**
	 * @param courseFee
	 *            the courseFee to set
	 */
	public void setCourseFee(Integer courseFee) {
		this.courseFee = courseFee;
	}

	/**
	 * @return the discount
	 */
	public Integer getDiscount() {
		return discount;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	/**
	 * @return the submittedFee
	 */
	public Integer getSubmittedFee() {
		return submittedFee;
	}

	/**
	 * @param submittedFee
	 *            the submittedFee to set
	 */
	public void setSubmittedFee(Integer submittedFee) {
		this.submittedFee = submittedFee;
	}

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * @return the batch
	 */

	/**
	 * @return the year
	 */
	public Year getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Year year) {
		this.year = year;
	}

	/**
	 * @return the emiList
	 */
	public List<Emi> getEmiList() {
		return emiList;
	}

	/**
	 * @param emiList
	 *            the emiList to set
	 */
	public void setEmiList(List<Emi> emiList) {
		this.emiList = emiList;
	}

	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType
	 *            the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/*
	 * public String getMail() { return mail; }
	 * 
	 * public void setMail(String mail) { this.mail = mail; }
	 */
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAllStudent() {
		return allStudent;
	}

	public void setAllStudent(String allStudent) {
		this.allStudent = allStudent;
	}

	public String getAllEnquiry() {
		return allEnquiry;
	}

	public void setAllEnquiry(String allEnquiry) {
		this.allEnquiry = allEnquiry;
	}

	/**
	 * @return the status
	 */

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	public CurrentStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(CurrentStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the attachFile
	 */
	public String getAttachFile() {
		return attachFile;
	}

	/**
	 * @param attachFile
	 *            the attachFile to set
	 */
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * @return the files
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}

	public Integer getemiId() {
		return emiId;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

}
