package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Reference;
import com.aartek.prestigepoint.repository.EnquiryRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("rawtypes")
@Repository
public class EnquiryRepositoryImpl implements EnquiryRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger
			.getLogger(EnquiryRepositoryImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveEnquiryMessage(Enquiry enquiry) {
		hibernateTemplate.saveOrUpdate(enquiry);
	}

	public boolean saveAdminEnquiry(Enquiry enquiry) {
		if (enquiry != null) {
			hibernateTemplate.saveOrUpdate(enquiry);
			return true;
		}
		return false;
	}

	public List<Enquiry> getYearWiseEnquiry(String year) {
		List<Enquiry> enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END) from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED
						+ " and YEAR(e.date) = '"
						+ year
						+ "' GROUP BY MONTH(e.date)");
		return enquiryList;
	}

	public List<Enquiry> getMonthAndYearWiseEnquiryDetails(String month,
			String year) {
		List<Enquiry> enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END),handledBy from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED
						+ " and YEAR(e.date) = '"
						+ year
						+ "' and MONTH(e.date)='"
						+ month
						+ "' GROUP BY handledBy");

		return enquiryList;
	}

	public List<Enquiry> getMonthWiseEnquiry(String month) {
		List<Enquiry> enquiryList = hibernateTemplate
				.find("select COUNT(e.enquiryId) ,e.date, SUM(CASE WHEN e.status = '1' THEN 1 ELSE 0 END) from Enquiry e where e.isDeleted="
						+ IConstant.IS_DELETED
						+ " and MONTH(e.date) = '"
						+ month + "' GROUP BY YEAR(e.date)");
		return enquiryList;
	}

	@SuppressWarnings("unchecked")
	public List<Enquiry> editEnquiry(Integer enquiryId) {
		List<Enquiry> enquiryList = hibernateTemplate
				.find("from Enquiry en where en.enquiryId=" + enquiryId);
		return enquiryList;
	}

	public void deleteEnquiry(Integer enquiryId) {
		Enquiry enquiry = hibernateTemplate.get(Enquiry.class, enquiryId);
		enquiry.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != enquiry) {
			hibernateTemplate.update(enquiry);
		}
	}

	public void saveStatus(Enquiry enquiry) {
		hibernateTemplate.saveOrUpdate(enquiry);

	}

	public List<Enquiry> matchMobileNo(String contact) {
		@SuppressWarnings("unchecked")
		List<Enquiry> enquiry = hibernateTemplate
				.find("from Enquiry en where en.mobileNo=" + contact);
		return enquiry;
	}

}
