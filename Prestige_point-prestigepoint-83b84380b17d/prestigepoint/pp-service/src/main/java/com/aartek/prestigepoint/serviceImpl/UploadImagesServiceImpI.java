package com.aartek.prestigepoint.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.UploadImages;
import com.aartek.prestigepoint.repository.UploadImagesRepository;
import com.aartek.prestigepoint.service.UploadImagesService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;

@Service
public class UploadImagesServiceImpI implements UploadImagesService {

	@Autowired
	private UploadImagesRepository uploadImagesRepository;

	@Value("${pp.uploadImagesPath}")
	private String uploadImagesPath;

	public boolean saveUploadImages(UploadImages uploadImages) {

		boolean status = false;
		if (uploadImages != null) {
			uploadImages.setIsDeleted(IConstant.IS_DELETED);
			uploadImages.setIsActive(IConstant.IS_STATUS_ACTIVE);
			UploadImages uploadImages1 = uploadImagesRepository.saveUploadImages(uploadImages);
			if (uploadImages1 != null) {
				BufferedImage newImg;
				String imageData = uploadImages.getUploadImagesPath().replaceFirst("^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(uploadImagesPath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(uploadImagesPath + "/" + uploadImages.getImagesId()
								+ ".png"));
					} catch (IOException e) {
						System.out.println("IOException");
					}
					uploadImages.setNameOfimages(uploadImages.getImagesId() + ".png");
					uploadImagesRepository.saveUploadImages(uploadImages);
				}
				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	public List<UploadImages> getAllUploadImages() {
		List<UploadImages> list = uploadImagesRepository.getAllStudentName();
		return list;
	}

	public void changeUploadImagesStatus(String uploadImageIdValue, Integer uploadImageValue) {
		if (uploadImageIdValue != null && uploadImageValue != null) {
			UploadImages uploadImages = (UploadImages) uploadImagesRepository.editUploadImagesStatus(uploadImageValue)
					.get(0);
			if (uploadImageIdValue.equals("true")) {
				uploadImages.setIsActive(IConstant.IS_DELETED);
				uploadImagesRepository.saveUploadImages(uploadImages);
			} else {
				uploadImages.setIsActive(IConstant.IS_DELETED_DEACTIVE);
				uploadImagesRepository.saveUploadImages(uploadImages);
			}

		}

	}

	public void deleteUploadImages(Integer imagesId) {
		uploadImagesRepository.deleteUploadImages(imagesId);
	}

}
