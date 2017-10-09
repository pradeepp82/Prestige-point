package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.EmiRepository;
import com.aartek.prestigepoint.service.EmiService;
import com.aartek.prestigepoint.util.DateFormat;
import com.aartek.prestigepoint.util.Gcm;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.SendMail;

@SuppressWarnings("unused")
@Service
public class EmiServiceImpl implements EmiService {

	private static final Logger logger = Logger.getLogger(EmiServiceImpl.class);

	@Autowired
	private EmiRepository emiRepository;

	public List<Emi> getFeesDetails(Integer registrationId) {
		List<Emi> emis = emiRepository.getFeesDetails(registrationId);
		return emis;
	}

	public boolean saveEmi(Emi emi) {
		boolean status = false;
		if (emi != null) {
			emi.setIsDeleted(IConstant.IS_DELETED);
			System.out.println("date 1=" + emi.getDate());
			emi.setDate(DateFormat.getYYYYMMDDDate(emi.getDate()));
			String emiDate = emi.getDate();
			Registration registration = emi.getRegistration();
			Integer stuRegistrationId = registration.getRegistrationId();
			status = emiRepository.saveEmi(emi);
			List<Registration> studentDetails = emiRepository.getEmiDetails(stuRegistrationId);
			registration = studentDetails.get(0);
			SendMail.emiMail(registration.getEmailId(), registration.getSubmittedFee(), registration.getFirstName(),
					registration.getTotalFee(), emi.getAmount(), emi.getDate());
			if (registration.getGcmId() != null) {
				Gcm.getGcm(registration, emi.getAmount());
			}
			return status;
		} else {
			return status;
		}

	}

	public boolean editEmiInfo(Emi emi) {
		boolean status = false;
		if (emi.getEmiId() != null) {
			emi.setIsDeleted(IConstant.IS_DELETED);
			System.out.println("date 1=" + emi.getDate());
			emi.setDate(DateFormat.getYYYYMMDDDate(emi.getDate()));
			String emiDate = emi.getDate();
			Integer amount = emi.getAmount();
			Registration registration = emi.getRegistration();
			Integer stuRegistrationId = registration.getRegistrationId();
			status = emiRepository.editEmiInfo(emi);
			List<Registration> studentDetails = emiRepository.getEmiDetails(stuRegistrationId);
			registration = studentDetails.get(0);
			SendMail.editEmiMail(registration.getEmailId(), registration.getSubmittedFee(),
					registration.getFirstName(), registration.getTotalFee(), emi.getAmount(), emi.getDate());
			return status;
		} else {
			return status;
		}

	}

	public List<Registration> getRegistrationDetails(Integer registrationId) {
		List<Registration> list = emiRepository.getRegistrationDetails(registrationId);
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	public Integer getRegistrationId(Integer emiId) {
		Integer registrationId = null;
		List<Emi> emis = emiRepository.getRegistrationId(emiId);
		if (emis != null) {
			Emi emi = (Emi) emis.get(0);
			registrationId = emi.getRegistration().getRegistrationId();
		}
		return registrationId;
	}

	public boolean deleteEmiDetails(Integer emiId) {
		boolean status = false;
		status = emiRepository.deleteEmiDetails(emiId);
		if(status){
			return status;
		}else{
			return status;
		}
	}

	public Emi editEmi(Integer emiId) {
		List<Emi> list = emiRepository.editEmi(emiId);
		if (list != null) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<Emi> getAllEmiId() {
		List<Emi> list = emiRepository.getAllEmiId();
		return list;

	}

	public Emi editEmiDetails(Integer emiId) {
		List<Emi> list = emiRepository.editEmi(emiId);
		if (list != null) {
			Emi emi = list.get(0);
			emi.setDate(DateFormat.getMMDDYYYYDate(emi.getDate()));
			return emi;
		} else {
			return null;
		}
	}

	public Registration getUserFeesDetails(Integer registrationId) {
		List<Registration> registrationList = emiRepository.getEmiDetails(registrationId);
		if (registrationList != null) {
			return registrationList.get(0);
		} else {
			return null;
		}
	}
}
