package com.aartek.prestigepoint.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.repository.ProfileRepository;
import com.aartek.prestigepoint.service.ProfileService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;

@Service
public class ProfileServiceImpl implements ProfileService {
	private static final Logger logger = Logger.getLogger(ProfileServiceImpl.class);

	@Autowired
	private ProfileRepository profileRepository;

	@Value("${pp.imagePath}")
	private String imagePath;

	public List<Registration> getStudentDetails(int registrationId) {
		List<Registration> studentDetailsList = profileRepository.getStudentDetails(registrationId);
		return studentDetailsList;
	}

	public boolean updateProfile(Registration registration) {
		boolean status = false;
		if (registration != null) {
			BufferedImage newImg;
			String imageData = registration.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
			newImg = ImageFormat.decodeToImage(imageData);
			if (newImg != null) {
				try {
					File f = new File(imagePath);
					f.mkdirs();
					ImageIO.write(newImg, "png", new File(imagePath + "/" + registration.getRegistrationId() + ".png"));
				} catch (IOException e) {
					logger.error("IOException", e);
				}
			}
			registration.setIsDeleted(IConstant.IS_DELETED);
			status = profileRepository.updateProfile(registration);
			return status;
		}
		return false;
	}

	public boolean saveChangePassword(Registration registration) {
		List<Registration> list = new ArrayList<Registration>();
		Registration verifyPassword = null;
		list = profileRepository.verifyPassword(registration.getPassword(), registration.getRegistrationId());
		if (list != null && !list.isEmpty()) {
			for (Registration reg : list) {
				verifyPassword = (Registration) reg;
				verifyPassword.setPassword(registration.getNewPassword());
				profileRepository.saveChangePassword(verifyPassword);
				return true;
			}
		}
		return false;
	}

	public boolean studentChangePassword(Registration registration) {
		List<Registration> list = new ArrayList<Registration>();
		Registration newPassword = null;
		list = profileRepository.verifyRegistrationId(registration.getRegistrationId());
		if (list != null && !list.isEmpty()) {
			for (Registration userRegistration : list) {
					newPassword = (Registration) userRegistration;
					newPassword.setPassword(registration.getPassword());
					profileRepository.saveChangePassword(newPassword);
					return true;
				}
			}
		return false;
	}
}