package com.aartek.prestigepoint.service;

import java.text.ParseException;
import java.util.List;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Reference;

@SuppressWarnings("rawtypes")
public interface EnquiryService {

	public void saveEnquiryMessage(Enquiry enquiry) throws ParseException;

	public boolean saveAdminEnquiry(Enquiry enquiry) throws ParseException;

	public List getMonthAndYearWiseEnquiryDetails(String month, String year);

	public List getYearWiseEnquiry(String year);

	public List getMonthWiseEnquiry(String month);

	public Enquiry editEnquiry(Integer enquiryId);

	public void deleteEnquiry(Integer enquiryId);

	

}
