package com.aartek.prestigepoint.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Course;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Meenal pathre
 *
 */
@Controller
public class CourseController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	/**
	 * Method for show add course page.
	 * 
	 * @param map
	 * @param model
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/course")
	public String showCoursePage(Map<String, Object> map, Model model, @RequestParam(required = false) String message) {
		List<Course> courseList = courseService.getCourses();
		if (courseList != null) {
			model.addAttribute("courseList", courseList);
		}
		map.put("Course", new Course());
		model.addAttribute("message", message);
		return "course";

	}

	/**
	 * Use for save course information.
	 * 
	 * @param course
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param courseId
	 * @return
	 */

	@RequestMapping(value = "/saveCourse.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String saveMarquee(@ModelAttribute("Course") Course course, ModelMap model) {
		boolean status = false;
		status = courseService.saveCourse(course);
		if (status) {
			model.addAttribute("message", IConstant.COURSE_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.COURSE_FAILURE_MESSAGE);
		}
		return "redirect:/course.do";
	}

	/**
	 * Use for update course information
	 * 
	 * @param course
	 * @param map
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/editCourse")
	public String editCourse(@ModelAttribute("Course") Course course, Map<String, Object> map,Model model,
			@RequestParam(required = false) Integer courseId) {
		List<Course> courseList = courseService.getCourses();
		if(courseList!=null){
		model.addAttribute("courseList", courseList);
		}
		course = courseService.editCourse(courseId);
		if (course != null) {
			map.put("Course", course);
		}
		return "course";
	}

	/**
	 * Method for delete course details.
	 * 
	 * @param course
	 * @param result
	 * @param model
	 * @param request
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/deleteCourse", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteCourse(ModelMap model, @RequestParam(required = false) Integer courseId) {
		boolean status = false;
		status = courseService.deleteCourse(courseId);
		if (status) {
			model.addAttribute("message", IConstant.COURSE_SUCCESS_DELETE_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.COURSE_FAILUR_DELETE_MESSAGE);
		}
		return "redirect:/course.do";
	}

	/**
	 * Method use for display all enquiry information.
	 * 
	 * @param map
	 * @param model
	 * @return
	 */
	@RequestMapping("/getEnquiry")
	public String showviewEnquiryDetailsPage(Model model) {
		List<Enquiry> enquiryList = courseService.getAllEnquiryDetails();
		if (enquiryList != null) {
			model.addAttribute("enquiryList", enquiryList);
		}
		return "getEnquiry";
	}

	
	
	
	/*@RequestMapping("/addCourseCatagory")
	public String addCourseCatagory(@RequestParam(required = false) Integer courseId){
		
		return "addCourseCatagory";
		
	}
	
	
	@RequestMapping(value = "/saveCourseCategory.do", method = { RequestMethod.GET, RequestMethod.POST })
	private String saveCourseCategory(@ModelAttribute("CourseCategory") CourseCategory courseCategory, ModelMap model) {
		
		boolean status = false;
		status = courseService.saveCourseCategory(courseCategory);
		if (status) {
			model.addAttribute("message", IConstant.COURSE_CAT_SUCCESS_MESSAGE);
		} else {
			model.addAttribute("message", IConstant.COURSE_CAT_FAILURE_MESSAGE);
		}
		return "addCourseCatagory";
		
	}*/
	
	


}
