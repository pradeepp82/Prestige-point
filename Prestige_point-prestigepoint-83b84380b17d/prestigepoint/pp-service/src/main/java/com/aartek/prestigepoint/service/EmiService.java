package com.aartek.prestigepoint.service;

import java.text.ParseException;
import java.util.List;

import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Registration;

public interface EmiService {

	List<Emi> getFeesDetails(Integer emiId);

	public boolean saveEmi(Emi emi) throws ParseException;

	List<Registration> getRegistrationDetails(Integer emiId);

	public Integer getRegistrationId(Integer emiId);

	boolean deleteEmiDetails(Integer emiId);

	List<Emi> getAllEmiId();

	public Emi editEmi(Integer emiId);

	public Emi editEmiDetails(Integer emiId);

	boolean editEmiInfo(Emi emi) throws ParseException;

	Registration getUserFeesDetails(Integer registrationId);

}
