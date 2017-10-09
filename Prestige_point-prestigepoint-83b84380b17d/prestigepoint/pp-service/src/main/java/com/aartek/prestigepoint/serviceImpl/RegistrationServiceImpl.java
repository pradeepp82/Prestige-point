package com.aartek.prestigepoint.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.City;
import com.aartek.prestigepoint.model.Emi;
import com.aartek.prestigepoint.model.Enquiry;
import com.aartek.prestigepoint.model.Reference;
import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.EnquiryRepository;
import com.aartek.prestigepoint.repository.RegistrationRepository;
import com.aartek.prestigepoint.service.RegistrationService;
import com.aartek.prestigepoint.util.AutoGenratedPassword;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;
import com.aartek.prestigepoint.util.SendMail;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private EnquiryRepository enquiryRepository;


	@Value("${pp.imagePath}")
	private String imagePath;

	public boolean saveStudentDeatils(Registration registration) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		boolean status = false;
		if (registration != null) {
			Emi emi = new Emi();
			emi.setAmount(registration.getSubmittedFee());
			emi.setIsDeleted(IConstant.IS_DELETED);
			emi.setDate(dateFormat.format(date));
			registration.setIsDeleted(IConstant.IS_DELETED);
			registration.setStatus(IConstant.PAID_STATUS);
			List<Emi> emis = new ArrayList<Emi>();
			emis.add(emi);
			registration.setEmiList(emis);
			if (registration.getTenthMarksheet() != null) {
				registration.setTenthMarksheet("Submitted");
			} else {
				registration.setTenthMarksheet("Not Submitted");
			}

			if (registration.getTwelfthMarksheet() != null) {
				registration.setTwelfthMarksheet("Submitted");
			} else {
				registration.setTwelfthMarksheet("Not Submitted");
			}

			if (registration.getGraduation() != null) {
				registration.setGraduation("Submitted");
			} else {
				registration.setGraduation("Not Submitted");
			}

			if (registration.getIdProof() != null) {
				registration.setIdProof("Submitted");
			} else {
				registration.setIdProof("Not Submitted");
			}
			
			if(registration.getPgMaeksheet()!=null){
				registration.setPgMaeksheet("Submitted");
			}
			else{
				registration.setPgMaeksheet("Not Submitted");
			}
			if(registration.getSemester() != null ){
				registration.setYear(null);
			}
			else{
				registration.setSemester(0);
			}
			Registration register = registrationRepository.saveStudentDeatils(registration);
			
			List<Enquiry> enquiryList= enquiryRepository.matchMobileNo(registration.getContact());
			
			if(enquiryList!=null&&!enquiryList.isEmpty()){
				Enquiry enquiry = enquiryList.get(0);
				enquiry.setStatus(1);
				enquiryRepository.saveStatus(enquiry);
				}
			
			if (register != null) {
				BufferedImage newImg;
				String imageData = registration.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(imagePath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(imagePath + "/" + registration.getRegistrationId()
								+ ".png"));
					} catch (IOException e) {
						logger.error("IOException", e);
					}
				}
				return true;
			
			} else {
				return false;
			}
		}
		return status;
	}

	public List<Registration> getAllStudentDetails() {
		List<Registration> list = new ArrayList<Registration>();
		list = registrationRepository.getAllStudentDetails();
		return list;
	}

	public List<Registration> getStudentDetailsByName(String firstName) {
		List<Registration> list = new ArrayList<Registration>();
		list = registrationRepository.getStudentDetailsByName(firstName);
		return list;
	}

	public List<Registration> getCourseWiseStudentDetails(Integer courseId) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations = registrationRepository.getCourseWiseStudentDetails(courseId);
		return registrations;
	}

	public List<Registration> getBatchWiseStudentDetails(Integer batchId) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations = registrationRepository.getBatchWiseStudentDetails(batchId);
		return registrations;
	}

	public List<String> getallStudentEmailId() {
		List<String> emailList = new ArrayList<String>();
		emailList = registrationRepository.getallStudentEmailId();
		return emailList;
	}

	public List<String> getallEnquiryEmailId() {
		List<String> emailList = new ArrayList<String>();
		emailList = registrationRepository.getallEnquiryEmailId();
		return emailList;
	}

	public Registration makeAsPaidUser(Integer registrationId) {
		List<Registration> stuRegs = null;
		Registration updateStudent = new Registration();
		stuRegs = registrationRepository.makeAsPaidUser(registrationId);
		for (Registration registration : stuRegs) {
			updateStudent = (Registration) registration;
		}
		return updateStudent;
	}

	public boolean updateStudentAsPaid(Registration registration) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		boolean status = false;
		String autoGeneratedPassword = AutoGenratedPassword.generateRandomPassword();
		if (registration != null) {
			Emi emi = new Emi();
			emi.setAmount(registration.getSubmittedFee());
			emi.setIsDeleted(IConstant.IS_DELETED);
			emi.setDate(dateFormat.format(date));
			registration.setIsDeleted(IConstant.IS_DELETED);
			registration.setStatus(IConstant.PAID_STATUS);
			registration.setPassword(autoGeneratedPassword);
			List<Emi> emis = new ArrayList<Emi>();
			emis.add(emi);
			registration.setEmiList(emis);
			Registration registration2 = registrationRepository.updateStudentAsPaid(registration);
			if (registration2 != null) {
				BufferedImage newImg;
				String imageData = registration.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(imagePath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(imagePath + "/" + registration.getRegistrationId()
								+ ".png"));
					} catch (IOException e) {
						logger.error("IOException", e);
					}
				}
				SendMail.sendEmail(registration2.getEmailId(), autoGeneratedPassword, registration2.getFirstName());
				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	public Registration editSudentDetails(Integer registrationId) {
		List<Registration> list = registrationRepository.editStudentDetails(registrationId);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void deleteStudentDetails(Integer registrationId) {
		registrationRepository.deleteStudentDetails(registrationId);

	}

	public boolean verifyUserEmailId(String emailId) {
		boolean status = false;
		status = registrationRepository.verifyUserEmailId(emailId);
		return status;

	}

	public Registration getStudentDetails(String emailId) {
		List<Registration> list = new ArrayList<Registration>();
		Registration registration = null;
		list = registrationRepository.getStudentDetails(emailId);
		for (Registration reg : list) {
			registration = (Registration) reg;
			SendMail.forgotPassword(registration.getEmailId(), registration.getPassword(), registration.getFirstName());
		}
		return registration;
	}

	public List<Reference> getAllReference() {
		return registrationRepository.getAllReference();
	}

	/**
	 * @author patidar
	 */
	public boolean verifyUserenrollmentNo(String enrollmentNo) {
		boolean status = false;
		status = registrationRepository.verifyUserenrollmentNo(enrollmentNo);
		return status;
	}

	/**
	 * @author patidar
	 */
	public boolean verifyUserContactNo(String contactNo) {
		boolean status = false;
		status = registrationRepository.verifyUserContactNo(contactNo);
		return status;
	}

	/*public List<Registration> getByCurrentStatus(Integer current_status_Id) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations = registrationRepository.getByCurrentStatus(current_status_Id);
		return registrations;
	}*/

	public List<Registration> getPersuingStudent(String persuing) {
		
		List<Registration>persuingList= new ArrayList<Registration>();
		
		persuingList=registrationRepository.getPersuingStudent(persuing);
		return persuingList;
	}

	/*public List<Registration> getCourseAndBatchWise(Course course, Batch batch) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations=registrationRepository.getCourseAndBatchWise(course,batch);
		return registrations;
	}
*/
	public List<Registration> getCourseAndBatchWise(Integer courseId,
			Integer BatchId) {
		List<Registration> registrations = new ArrayList<Registration>();
		registrations=registrationRepository.getCourseAndBatchWise(courseId, BatchId);
		
		return registrations;
	}

	public List<City> getAllCity() {
	
		return registrationRepository.getAllCity();
	}

	/*public List<Qualification> getAllQualification() {
		List<Qualification> qualificationList = new ArrayList<Qualification>();
		qualificationList = registrationRepository.getAllQualification();
		return qualificationList;
	}*/

}
