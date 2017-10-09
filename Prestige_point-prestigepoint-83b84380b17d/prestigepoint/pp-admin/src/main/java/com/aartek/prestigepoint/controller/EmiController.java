package com.aartek.prestigepoint.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.service.EmiService;
import com.aartek.prestigepoint.util.IConstant;

/**
 * 
 * @author Meenal
 *
 */
@Controller
public class EmiController {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(EmiController.class);

	@Autowired
	private EmiService emiService;

	/**
	 * Method for view emi details of students.
	 * 
	 * @param emi
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @param registrationId
	 * @return
	 */
	@RequestMapping(value = "/getEmiDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String viewFeesDetails(ModelMap model,@RequestParam(required = false) Integer registrationId, Integer emiId,Map<String, Object> map,@RequestParam(required = false) String message) {
		List<Emi> emiList = emiService.getFeesDetails(registrationId);
		List<Registration> registrations = emiService.getRegistrationDetails(registrationId);
		model.addAttribute("registrationList", registrations);
		model.addAttribute("feesDetails", emiList);
		model.addAttribute("registrationId", registrationId);
		model.addAttribute("message", message);
		model.addAttribute("emiId", emiId);
		map.put("Emi", new Emi());
		return "emi";
	}

	/**
	 * show a emi page and display student emi details.
	 * 
	 * @param map
	 * @param model
	 * @param registrationId
	 * @param message
	 * @param request
	 * @return
	 */
	@RequestMapping("/emi")
	public String showFee(Map<String, Object> map, Model model, @RequestParam(required = false) Integer registrationId,
			@RequestParam(required = false) String message, @RequestParam(required = false) Integer emiId,
			HttpServletRequest request) {
			if (emiId != null) {
				registrationId = emiService.getRegistrationId(emiId);
			}
			List<Emi> emi1 = emiService.getFeesDetails(registrationId);
			List<Registration> registrations = emiService.getRegistrationDetails(registrationId);
			model.addAttribute("registrationList", registrations);
			model.addAttribute("feesDetails", emi1);
			model.addAttribute("message", message);
			model.addAttribute("registrationId", registrationId);
			map.put("Emi", new Emi());
			return "emi";
		
	}

	/**
	 * Use for save emi details.
	 * 
	 * @param emi
	 * @param result
	 * @param model
	 * @param map
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/saveEmi", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveEmi(@ModelAttribute("Emi") Emi emi, ModelMap model, HttpServletRequest request)throws ParseException {
		boolean status = false;
		if (emi.getEmiId() != null) {
			Integer registrationId = emiService.getRegistrationId(emi.getEmiId());
			emi.getRegistration().setRegistrationId(registrationId);
			status = emiService.editEmiInfo(emi);
			if (status) {
				model.addAttribute("registrationId", emi.getRegistration().getRegistrationId());
				model.addAttribute("message",  IConstant.EMI_EDIT_MESSAGE);
			} else {
				model.addAttribute("message", "Error");
			}

		} else {
			status = emiService.saveEmi(emi);
			if (status) {
				model.addAttribute("message", IConstant.EMI_MESSAGE);
			    model.addAttribute("registrationId", emi.getRegistration().getRegistrationId());
			} else {
				model.addAttribute("message", "Error");
			}
		}

		return "redirect:/getEmiDetails.do?registrationId=" + emi.getRegistration().getRegistrationId();
	}

	/**
	 * use for edit the emi details
	 * 
	 * @param emi
	 * @param model
	 * @param emiId
	 * @return
	 */
	@RequestMapping(value = "/editEmi", method = { RequestMethod.GET, RequestMethod.POST })
	public String editEmi(@ModelAttribute("Emi") Emi emi, ModelMap model, Integer emiId) {
		emi = emiService.editEmiDetails(emiId);
		if (emi != null) {
			model.put("Emi", emi);
		}
		return "emi";
	}

	/**
	 * use for delete the emi details
	 * 
	 * @param emi
	 * @param model
	 * @param emiId
	 * @return
	 */

	@RequestMapping(value = "/deleteEmiDetails", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteEmiDetails(ModelMap model,@RequestParam(required = false) Integer emiId) {
		boolean status= false;
		status = emiService.deleteEmiDetails(emiId);
		if(status){
		model.addAttribute("message", IConstant.STUDENT_DELETE_MESSAGE);
		model.addAttribute("emiId", emiId);
		}else{
			model.addAttribute("message", IConstant.STUDENT_FAILUR_DELETE_MESSAGE);
		}
		return "redirect:/emi.do";
	}
	
	
	/**
	 * Use to genrate  payment Receipt
	 * 
	 * neha Rajput
	 * 
	 * 
	 */
	@RequestMapping("/genrateReceipt")
	public String genrateReceipt(
			 @RequestParam(required = false) Integer emiId,
					HttpServletRequest request)  {
	
				return "genrateReceipt";
		
	}
}

