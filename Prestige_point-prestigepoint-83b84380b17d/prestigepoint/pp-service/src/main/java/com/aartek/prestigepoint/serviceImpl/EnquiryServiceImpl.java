package com.aartek.prestigepoint.serviceImpl;

//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.repository.EnquiryRepository;
import com.aartek.prestigepoint.service.EnquiryService;
import com.aartek.prestigepoint.util.CamelCase;
import com.aartek.prestigepoint.util.DateFormat;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("rawtypes")
@Service
public class EnquiryServiceImpl implements EnquiryService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EnquiryServiceImpl.class);

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private EnquiryRepository addEnquiryRepository;

	public void saveEnquiryMessage(Enquiry enquiry) throws ParseException {
		java.text.DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		enquiry.setIsDeleted(IConstant.IS_DELETED);
		enquiry.setDate(DateFormat.getYYYYMMDDDate(dateFormat1.format(date)));
		enquiry.setEnquiryBy("online");
		enquiry.setQualification("N/A");
		enquiry.setHandledBy("N/A");
		enquiry.setReferenceMobileNo("N/A");
		/*enquiry.setReferenceName("N/A");*/
		enquiry.setCollage("N/A");
		enquiry.setStatus(0);
		enquiry.setName(CamelCase.produceCamelCase(enquiry.getName()));
		enquiryRepository.saveEnquiryMessage(enquiry);
	}

	public boolean saveAdminEnquiry(Enquiry enquiry) throws ParseException {
		enquiry.setDate(DateFormat.getYYYYMMDDDate((enquiry.getDate())));
		enquiry.setName(CamelCase.produceCamelCase(enquiry.getName()));
		enquiry.setLastName(CamelCase.produceCamelCase(enquiry.getLastName()));
		enquiry.setHandledBy(CamelCase.produceCamelCase(enquiry.getHandledBy()));
		enquiry.setIsDeleted(IConstant.IS_DELETED);
		enquiry.setEnquiryBy("admin");
		enquiry.setStatus(0);
		boolean status = false;
		if (enquiry != null) {
			enquiry.setIsDeleted(IConstant.IS_DELETED);
			status = enquiryRepository.saveAdminEnquiry(enquiry);
		}
		return status;
	}

	public List getYearWiseEnquiry(String year) {
		List enquirylist = enquiryRepository.getYearWiseEnquiry(year);
		return enquirylist;
	}

	public List getMonthAndYearWiseEnquiryDetails(String month, String year) {
		List enquirylist = enquiryRepository.getMonthAndYearWiseEnquiryDetails(month, year);
		return enquirylist;
	}

	public List getMonthWiseEnquiry(String month) {
		List enquirylist = enquiryRepository.getMonthWiseEnquiry(month);
		return enquirylist;
	}

	public Enquiry editEnquiry(Integer enquiryId) {
		List<Enquiry> enquiryList = addEnquiryRepository.editEnquiry(enquiryId);
		if (enquiryList != null && !enquiryList.isEmpty()) {
			return enquiryList.get(0);
		} else {
			return null;
		}
	}

	public void deleteEnquiry(Integer enquiryId) {
		enquiryRepository.deleteEnquiry(enquiryId);
	}
}
