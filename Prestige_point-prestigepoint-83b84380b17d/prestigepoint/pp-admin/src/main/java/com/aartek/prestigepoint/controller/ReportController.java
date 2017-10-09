package com.aartek.prestigepoint.controller;

/*this controller class is design for enquiry view*/

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Reference;
import com.aartek.prestigepoint.model.Year;
import com.aartek.prestigepoint.service.CourseService;
import com.aartek.prestigepoint.service.EnquiryService;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.validator.EnquiryValidator;

/**
 * 
 * @author Meenal pathre
 *
 */
@Controller
public class ReportController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(ReportController.class);

	@Autowired
	private CourseService courseService;

	@Autowired
	private EnquiryService enquiryService;

	@Autowired
	private EnquiryValidator enquiryValidator;
	
	@Autowired
	private RegistrationService registrationService;

	/**
	 * use for viewEnquiryByMonth
	 * 
	 * @param enquiry
	 * @param map
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/getEnquiryByMonth")
	public String showEnquiryPage(@ModelAttribute("Enquiry") Enquiry enquiry, Map<String, Object> map, Model model) {
		map.put("Enquiry", new Enquiry());
		List<Year> yearList = courseService.getAllYearName();
		model.addAttribute("year", yearList);
		return "viewEnquiryByMonth";
	}

	@RequestMapping("/adminEnquiry")
	public String showaddAddEnquiryPage(@ModelAttribute("Enquiry") Enquiry enquiry, Map<String, Object> map,Model model, 
			@RequestParam(required = false) String message) {
		map.put("Enquiry", new Enquiry());
		model.addAttribute("message", message);
		List<Reference> referenceList = registrationService.getAllReference();
		if (referenceList != null) {
			model.addAttribute("reference", referenceList);
		}
		
		
		return "addAdminEnquiry";
	}
	
	/**
	 * it's use for save the enquiry details
	 * 
	 * @param enquiry
	 * @param result
	 * @param model
	 * @param map
	 * @param message
	 * @return
	 * @throws ParseException
	 */

	@RequestMapping(value = "/saveAdminEnquiry", method = { RequestMethod.GET, RequestMethod.POST })
	 public String saveAdminEnquiry(@ModelAttribute("Enquiry") Enquiry enquiry, BindingResult result, Model model,
	   Map<String, Object> map, @RequestParam(required = false) String message) throws ParseException {
	  boolean status = false;
	  List<Reference> referenceList = registrationService.getAllReference();
		if (referenceList != null) {
			model.addAttribute("reference", referenceList);
		}
	  
	  if (enquiry != null && !enquiry.equals("null")) {
	   enquiryValidator.validate(enquiry, result);
	   if (result.hasErrors()) {
	    return "addAdminEnquiry";
		 
	   }
	   status = enquiryService.saveAdminEnquiry(enquiry);
	   if (status) {
	    model.addAttribute("message", IConstant.ENQUIRY_BY_ADMIN_SUCCESS);
	   } else {
	    model.addAttribute("message", IConstant.ENQUIRY_BY_ADMIN_FAIL);
	   }
	   map.put("Enquiry", new Enquiry());
	   return "addAdminEnquiry";
	  } else {
	   return "redirect:/adminEnquiry.do";
	  }
	 }

	@RequestMapping(value = "/getEnquiryDetails", method = {RequestMethod.GET, RequestMethod.POST})
	public String viewEnquiryReport(@ModelAttribute("Enquiry") Enquiry enquiry, ModelMap model,
			HttpServletRequest request, @RequestParam(required = false) Integer enquiryId) throws ParseException {
		String method = request.getMethod();
		List<Year> yearList = null;
		yearList = courseService.getAllYearName();
		if (!enquiry.getMonth().equals("0") && !enquiry.getYear().equals("0")) {
			List enquirylist = enquiryService.getMonthAndYearWiseEnquiryDetails(enquiry.getMonth(), enquiry.getYear());
			if (enquirylist != null) {
				model.addAttribute("enquirylist", enquirylist);
			}
		} else {
			if (enquiry.getMonth().equals("0")) {
				List enquirylist = enquiryService.getYearWiseEnquiry(enquiry.getYear());
				if (enquirylist != null) {
					model.addAttribute("enquirylist", enquirylist);
				}
			} else {
				List enquirylist = enquiryService.getMonthWiseEnquiry(enquiry.getMonth());
				if (enquirylist != null) {
					model.addAttribute("enquirylist", enquirylist);
				}
			}
		}
		model.addAttribute("year", yearList);
		model.addAttribute("message", IConstant.ENQUIRY_MESSAHE);
		return "viewEnquiryByMonth";
	}
	
	/**
	 * it's use for edit the enquiry details
	 * 
	 * @param enquiry
	 * @param map
	 * @param request
	 * @param enquiryId
	 * @return
	 * @throws ParseException
	 */

	@RequestMapping(value = "/editEnquiry")
	public String editEnquiry(@ModelAttribute("Enquiry") Enquiry enquiry, Map<String, Object> map,ModelMap model,
			HttpServletRequest request, @RequestParam(required = false) Integer enquiryId) throws ParseException {
		enquiry = enquiryService.editEnquiry(enquiryId);
		map.put("Enquiry", enquiry);
		 List<Reference> referenceList = registrationService.getAllReference();
			if (referenceList != null) {
				model.addAttribute("reference", referenceList);
			}
		  
		
		
		return "addAdminEnquiry";
	}

	/**
	 * it's use for delete the enquiry details
	 * 
	 * @param enquiryId
	 * @return
	 */
	@RequestMapping(value = "/deleteEnquiry", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteEnquiry(@RequestParam(required = false) Integer enquiryId) {
		enquiryService.deleteEnquiry(enquiryId);
		return "redirect:/getEnquiry.do";
	}
}
