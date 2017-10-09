package com.aartek.prestigepoint.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.repository.ContactRepository;
import com.aartek.prestigepoint.service.ContactService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class ContactServiceImpl implements ContactService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ContactServiceImpl.class);
	@Autowired
	private ContactRepository contactRepository;

	public boolean saveContact(Enquiry enquiry) {
		boolean status = false;
		if (enquiry != null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			enquiry.setIsDeleted(IConstant.IS_DELETED);
			enquiry.setDate(dateFormat.format(date));
			status = contactRepository.saveContact(enquiry);
			return status;
		} else {
			return status;
		}
	}

}
