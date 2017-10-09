package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.CurrentStatus;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.repository.CourseRepository;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class CourseServiceImpl implements CourseService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	/**
	 * Method for save course details.
	 * 
	 * @param course
	 */
	public boolean saveCourse(Course course) {
		boolean status = false;
		if (course != null) {
			course.setIsDeleted(IConstant.IS_DELETED);
			status = courseRepository.saveCourse(course);
			return status;
		} else
			return status;
	}

	/**
	 * Method use for get all course name that are register.
	 */
	public List<Course> getCourses() {
		List<Course> list = courseRepository.getCourses();
		return list;
	}

	/**
	 * Method for edit course information.
	 * 
	 * @param courseId
	 */
	public Course editCourse(Integer courseId) {
		Course course = courseRepository.editCourse(courseId);
		if(course!=null){
			return course;
		}else{
			return null;
		}
	}

	/**
	 * Delete course information from data base.
	 * 
	 * @param courseId
	 * @return
	 */
	public boolean deleteCourse(Integer courseId) {
		boolean status = false;
		status = courseRepository.deleteCourse(courseId);
		if (status)
			return status;
		else
			return status;

	}

	/**
	 * Method get all enquiry for display in grid
	 */
	public List<Enquiry> getAllEnquiryDetails() {
		List<Enquiry> list = new ArrayList<Enquiry>();
		list = courseRepository.getAllEnquiryDetails();
		return list;
	}

	/**
	 * Method get all year from data base.
	 */
	public List<Year> getAllYearName() {
		List<Year> list = courseRepository.getAllYearName();
		return list;
	}

	/**
	 * Method get all status from data base.
	 */
	public List<CurrentStatus> getAllCurrentStatus() {
		List<CurrentStatus> list = new ArrayList<CurrentStatus>();
		list = courseRepository.getAllCurrentStatus();
		return list;

	}

	/**
	 * Method for get fee corresponding to course.
	 * 
	 * @param courseIdId
	 */
	public Integer getFeeByCourseType(Integer courseIdId) {
		Integer amount = null;
		if (courseIdId != null) {
			amount = courseRepository.getFeeByCourseType(courseIdId);
		}
		return amount;
	}

	/*public boolean saveCourseCategory(CourseCategory courseCategory) {
		boolean status = false;
		if (courseCategory != null) {
			courseCategory.setIsDeleted(IConstant.IS_DELETED);
			status = courseRepository.saveCourseCategory(courseCategory);
			return status;
		} else
			return false;
	}*/
}
