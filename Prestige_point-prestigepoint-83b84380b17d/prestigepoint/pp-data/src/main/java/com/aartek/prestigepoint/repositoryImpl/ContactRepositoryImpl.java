package com.aartek.prestigepoint.repositoryImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.repository.ContactRepository;

@Repository
public class ContactRepositoryImpl implements ContactRepository {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ContactRepositoryImpl.class);
  @Autowired
  private HibernateTemplate hibernateTemplate;

  public boolean saveContact(Enquiry enquiry) {
    if (enquiry != null) {
      hibernateTemplate.save(enquiry);
      return true;
    } else {
      return false;
    }
  }

}
