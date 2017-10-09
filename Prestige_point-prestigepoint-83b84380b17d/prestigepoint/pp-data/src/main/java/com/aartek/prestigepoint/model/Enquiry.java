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
@Table(name = "enquiry")
public class Enquiry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENQUIRY_ID")
	private Integer enquiryId;

	@Column(name = "NAME")
	private String name;

	/*public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
*/
	/*@Column(name = "COURSE")
	private String course;
*/
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Column(name = "EMAIL_ID")
	private String emailId;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Column(name = "DATE")
	private String date;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "ENQUIRY_BY")
	private String enquiryBy;

	@Column(name = "QUALIFICATION")
	private String qualification;

	@Column(name = "COLLAGE")
	private String collage;

	/*public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}

	@Column(name = "REFERENCE_NAME")
	private String referenceName;*/

	/*@JoinColumn(name = "REFERENCE_ID")
	private Integer referenceId;*/

	@Column(name = "REFERENCER_MOBILE_NO")
	private String referenceMobileNo;

	@Column(name = "TRAINING_TYPE")
	private Integer trainingType;

	@Column(name = "HANDLED_BY")
	private String handledBy;

	@Column(name = "status")
	private int status;
	
	@ManyToOne
	@JoinColumn(name = "REFERENCE_ID")
	private Reference reference;

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}

	@Transient
	private String searchType;

	@Transient
	private String month;

	@Transient
	private String year;

	@Transient
	private long countByMonth;

	@Transient
	private long statusCount;

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCollage() {
		return collage;
	}

	public void setCollage(String collage) {
		this.collage = collage;
	}

	/*public Integer getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Integer referenceId) {
		this.referenceId = referenceId;
	}*/

	public void setCountByMonth(long countByMonth) {
		this.countByMonth = countByMonth;
	}

	public String getReferenceMobileNo() {
		return referenceMobileNo;
	}

	public void setReferenceMobileNo(String referenceMobileNo) {
		this.referenceMobileNo = referenceMobileNo;
	}

	public Integer getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(Integer trainingType) {
		this.trainingType = trainingType;
	}

	public String getHandledBy() {
		return handledBy;
	}

	public void setHandledBy(String handledBy) {
		this.handledBy = handledBy;
	}

	public String getEnquiryBy() {
		return enquiryBy;
	}

	public void setEnquiryBy(String enquiryBy) {
		this.enquiryBy = enquiryBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the enquiryId
	 */
	public Integer getEnquiryId() {
		return enquiryId;
	}

	/**
	 * @param enquiryId
	 *            the enquiryId to set
	 */
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	/**
	 * @return the name
	 */

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getCountByMonth() {
		return countByMonth;
	}

	public void setCountByMonth(Long o) {
		this.countByMonth = o;
	}

	public long getStatusCount() {
		return statusCount;
	}

	public void setStatusCount(long statusCount) {
		this.statusCount = statusCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
