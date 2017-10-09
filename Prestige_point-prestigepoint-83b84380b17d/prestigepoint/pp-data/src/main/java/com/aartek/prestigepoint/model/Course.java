package com.aartek.prestigepoint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
	private Integer courseId;

	@Column(name = "COURSE_NAME")
	private String courseName;

	@Column(name = "COURSE_FEE")
	private Integer courseFee;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID", updatable = false)
	private List<Registration> registrationList;
	
	/*@ManyToOne
	@JoinColumn(name = "COURSE_CAT_ID")
	private Course course;*/
	
	
	

	/*@ManyToOne
	@JoinColumn(name = "ADMIN_LOGIN_ID")
	private AdminLogin adminLogin;

	public AdminLogin getAdminLoginId() {
		return adminLogin;
	}

	public void setAdminLoginId(AdminLogin adminLogin) {
		this.adminLogin = adminLogin;
	}*/

	/**
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	 * @return the registrationList
	 */
	public List<Registration> getRegistrationList() {
		return registrationList;
	}

	/**
	 * @param registrationList
	 *            the registrationList to set
	 */
	public void setRegistrationList(List<Registration> registrationList) {
		this.registrationList = registrationList;
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

}
