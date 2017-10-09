package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface ProfileService {

	public List<Registration> getStudentDetails(int registrationId);

	public boolean updateProfile(Registration registration);

	public boolean saveChangePassword(Registration registration);

	public boolean studentChangePassword(Registration registration);

}
