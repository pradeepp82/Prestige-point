package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.EmiRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class EmiRepositoryImpl implements EmiRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(EmiRepositoryImpl.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<Emi> getFeesDetails(Integer registrationId) {
		List<Emi> list = hibernateTemplate.find("from Emi e where e.registration.registrationId=" + registrationId
				+ " and e.isDeleted=" + IConstant.IS_DELETED);

		return list;
	}

	public boolean saveEmi(Emi emi) {
		Integer oldAmount = 0;
		if (emi != null) {
			if (emi.getEmiId() != null) {
				Emi oldEmi = (Emi) hibernateTemplate.get(Emi.class, emi.getEmiId());
				oldAmount = oldEmi.getAmount();
			}
			hibernateTemplate.saveOrUpdate(emi);
			List<Registration> registrations = hibernateTemplate.find("from Registration r where r.registrationId="
					+ emi.getRegistration().getRegistrationId());
			Registration registration = registrations.get(0);
			Integer submittedAmount = registration.getSubmittedFee() - oldAmount + emi.getAmount();
			registration.setSubmittedFee(submittedAmount);
			hibernateTemplate.update(registration);
			return true;
		} else {
			return false;
		}
	}

	public List<Registration> getRegistrationDetails(Integer registrationId) {
		List<Registration> list = hibernateTemplate.find("from Registration r where r.registrationId=" + registrationId
				+ " and r.isDeleted=" + IConstant.IS_DELETED);
		return list;
	}

	public List<Emi> getRegistrationId(Integer emiId) {
		List<Emi> emis = hibernateTemplate.find("from Emi e where e.emiId=" + emiId);
		return emis;

	}

	public boolean deleteEmiDetails(Integer emiId) {
		Emi emi = (Emi) hibernateTemplate.get(Emi.class, emiId);
		if (null != emi) {
			emi.getRegistration().setSubmittedFee(emi.getRegistration().getSubmittedFee() - emi.getAmount());
			emi.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
			hibernateTemplate.update(emi.getRegistration());
			hibernateTemplate.update(emi);
			return true;
		} else {
			return false;
		}
	}

	public List<Emi> editEmi(Integer emiId) {
		List<Emi> list = hibernateTemplate.find("from Emi e where e.emiId=" + emiId);
		return list;
	}

	public List<Emi> getAllEmiId() {
		List<Emi> emiList = hibernateTemplate.find("from Emi where IS_DELETED=" + IConstant.IS_DELETED);
		return emiList;

	}

	public Emi editEimForSingleRecord(Integer emiId) {
		Emi emi = (Emi) hibernateTemplate.find("from Emi e where e.emiId=" + emiId);
		return emi;
	}

	public List<Registration> getEmiDetails(Integer registrationId) {
		List<Registration> list = hibernateTemplate.find("from Registration r where r.registrationId=" + registrationId
				+ "and r.isDeleted=" + IConstant.IS_DELETED);
			return list;
	}

	public boolean editEmiInfo(Emi emi) {
		Integer oldAmount = 0;
		if (emi != null) {
			if (emi.getEmiId() != null) {
				Emi oldEmi = (Emi) hibernateTemplate.get(Emi.class, emi.getEmiId());
				oldAmount = oldEmi.getAmount();
			}
			hibernateTemplate.saveOrUpdate(emi);
			List<Registration> registrations = hibernateTemplate.find("from Registration r where r.registrationId="
					+ emi.getRegistration().getRegistrationId());
			Registration registration = registrations.get(0);
			Integer submittedAmount = registration.getSubmittedFee() - oldAmount + emi.getAmount();
			registration.setSubmittedFee(submittedAmount);
			hibernateTemplate.update(registration);
			return true;
		} else {
			return false;
		}
	}

}
