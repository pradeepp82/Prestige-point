package com.aartek.prestigepoint.repository;


import java.util.List;

import com.aartek.prestigepoint.model.City;
import com.aartek.prestigepoint.model.Reference;
import com.aartek.prestigepoint.model.Registration;


public interface RegistrationRepository {

  public Registration saveStudentDeatils(Registration registration);

  public List<Registration> getAllStudentDetails();

  public List<Registration> getCourseWiseStudentDetails(Integer courseId);

  public List<Registration> getBatchWiseStudentDetails(Integer batchId);

  public List<String> getallStudentEmailId();

  public List<String> getallEnquiryEmailId();

  public List<Registration> makeAsPaidUser(Integer registrationId);

  public Registration updateStudentAsPaid(Registration registration);

  public List<Registration> editStudentDetails(Integer registrationId);

  public void deleteStudentDetails(Integer registrationId);

  public List<Registration> getStudentDetailsByName(String firstName);

  public boolean verifyUserEmailId(String emailId);

public List<Registration> getStudentDetails(String emailId);


public List<Reference> getAllReference();

/*public List<Registration> getByCurrentStatus(Integer current_status_Id);*/
/**
 * @author patidar
 * @param enrollmentNo
 * @return
 */
public boolean verifyUserenrollmentNo(String enrollmentNo);

/**
 * @author patidar
 * @param contactNo
 * @return
 */
public boolean verifyUserContactNo(String contactNo);

public List<Registration> getPersuingStudent(String persuing);

public List<Registration> getCourseAndBatchWise(Integer courseId, Integer batchId);

public List<City> getAllCity();

/*public List<Qualification> getAllQualification();*/




}
