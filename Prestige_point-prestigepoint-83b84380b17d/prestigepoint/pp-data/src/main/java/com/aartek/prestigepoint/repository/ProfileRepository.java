package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface ProfileRepository {

	public List<Registration> getStudentDetails(int registrationId);

	public boolean updateProfile(Registration registration);

	public boolean saveChangePassword(Registration verifyPassword);
	
	public List<Registration> verifyPassword(String password, Integer registrationId);

	public List<Registration> verifyRegistrationId(Integer registrationId);

}
