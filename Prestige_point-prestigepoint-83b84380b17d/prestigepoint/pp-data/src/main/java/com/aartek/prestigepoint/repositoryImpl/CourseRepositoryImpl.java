package com.aartek.prestigepoint.repositoryImpl;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.CurrentStatus;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.repository.CourseRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class CourseRepositoryImpl implements CourseRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CourseRepositoryImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Save course details into data base.
	 */
	public boolean saveCourse(Course course) {
		if (course != null) {
			hibernateTemplate.saveOrUpdate(course);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * get all course name from data base.
	 */

	public List<Course> getCourses() {
		List<Course> courseList = hibernateTemplate.find("from Course where IS_DELETED=" + IConstant.IS_DELETED);
		return courseList;
	}

	/**
	 * get course information for edit course details.
	 * 
	 * @param courseId
	 */

	public Course editCourse(Integer courseId) {
		Course course = (Course) hibernateTemplate.get(Course.class, courseId);
		return course;
	}

	/**
	 * Method use for delete course.
	 * 
	 * @param courseId
	 * @return
	 */

	@SuppressWarnings("unused")
	public boolean deleteCourse(Integer courseId) {
		Course course = (Course) hibernateTemplate.get(Course.class, courseId);
		course.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != course) {
			 hibernateTemplate.update(course);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method use for get all enquiey details
	 */

	public List<Enquiry> getAllEnquiryDetails() {
		List<Enquiry> enquiries = hibernateTemplate.find("from Enquiry where IS_DELETED=" + IConstant.IS_DELETED
				+ "order by date asc");
		return enquiries;
	}

	/**
	 * Method for get all year name
	 */

	public List<Year> getAllYearName() {
		List<Year> years = hibernateTemplate.find("from Year where IS_DELETED=" + IConstant.IS_DELETED
				+ " order by year asc");
		return years;
	}

	/**
	 * Method for get all current status
	 */

	public List<CurrentStatus> getAllCurrentStatus() {
		List<CurrentStatus> currentStatus = hibernateTemplate.find("from CurrentStatus where IS_DELETED="
				+ IConstant.IS_DELETED + " order by currentStatus asc");
		return currentStatus;
	}

	/**
	 * Method for get course fee corresponding for courseType.
	 * 
	 * @param courseIdId
	 */

	public Integer getFeeByCourseType(Integer courseIdId) {
		List<Object> list = hibernateTemplate.find("from Course c where c.isDeleted=" + IConstant.IS_DELETED
				+ " and c.courseId=?", courseIdId);
		@SuppressWarnings("rawtypes")
		Iterator iterator = list.iterator();
		Integer amount = null;
		while (iterator.hasNext()) {
			Course type = (Course) iterator.next();
			amount = type.getCourseFee();
		}
		return amount;
	}

	/*public boolean saveCourseCategory(CourseCategory courseCategory) {
		if (courseCategory != null) {
			hibernateTemplate.saveOrUpdate(courseCategory);
			return true;
		} else {
			return false;
		}
	}
*/
}
