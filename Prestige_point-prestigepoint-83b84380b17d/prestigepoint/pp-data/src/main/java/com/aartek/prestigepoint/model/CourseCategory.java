/*package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "course_category")
public class CourseCategory  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_CAT_ID")
	private Integer courseCatId;

	@Column(name = "COURSE_CAT_NAME")
	private String courseCatName;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Integer getCourseCatId() {
		return courseCatId;
	}

	public void setCourseCatId(Integer courseCatId) {
		this.courseCatId = courseCatId;
	}

	public String getCourseCatName() {
		return courseCatName;
	}

	public void setCourseCatName(String courseCatName) {
		this.courseCatName = courseCatName;
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

	

}
*/