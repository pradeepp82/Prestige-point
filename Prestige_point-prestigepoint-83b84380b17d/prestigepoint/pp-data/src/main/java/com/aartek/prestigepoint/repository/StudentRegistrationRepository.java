/**
 * 
 */
package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

/**
 * @author deepak
 * 
 */
public interface StudentRegistrationRepository {

	public Registration saveStudent(Registration registration);

	public Registration editStuRegs(Integer registrationId);

	public List<Object> studentSignIn(String emailId, String password);

	public boolean verifyUserEmailId(String emailId);

	public Registration getStudentLogin(String emailId, String password);

	public Registration userIdVerify(Integer registrationId);

	/*public List<Registration> getAllStudentImages();*/

}
