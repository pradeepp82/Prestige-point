package com.aartek.prestigepoint.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.UploadPlacedStudentImages;
import com.aartek.prestigepoint.repository.UploadPlacedStudentImagesRepository;
import com.aartek.prestigepoint.service.UploadPlacedStudentImagesService;
import com.aartek.prestigepoint.util.ImageFormat;
import com.aartek.prestigepoint.util.ImageFormatWS;

@Service
public class UploadPlacedStudentImagesServiceImpl implements UploadPlacedStudentImagesService {

	@Autowired
	private UploadPlacedStudentImagesRepository uploadPlacedStudentImagesRepository;

	@Value("${pp.uploadPlacedStudentImagesPath}")
	private String uploadPlacedStudentImagesPath;

	public boolean savePlacedStudentImages(UploadPlacedStudentImages uploadPlacedStudentImages) {
		boolean status = false;
		if (uploadPlacedStudentImages != null) {
			UploadPlacedStudentImages UploadPlacedStudentImage = uploadPlacedStudentImagesRepository
					.savePlacedStudentImages(uploadPlacedStudentImages);
			if (UploadPlacedStudentImage != null) {
				BufferedImage newImg;
				String imageData = UploadPlacedStudentImage.getUploadPlacedStudentImagesPath().replaceFirst(
						"^data:image/[^;]*;base64,?", "");
				newImg = ImageFormat.decodeToImage(imageData);
				if (newImg != null) {
					try {
						File f = new File(uploadPlacedStudentImagesPath);
						f.mkdirs();
						ImageIO.write(newImg, "png", new File(uploadPlacedStudentImagesPath + "/"+ UploadPlacedStudentImage.getStudentImagesId() + ".png"));
					} catch (IOException e) {
						System.out.println("IOException");
					}
					UploadPlacedStudentImage.setNameOfStudentImages(UploadPlacedStudentImage.getStudentImagesId()
							+ ".png");
					uploadPlacedStudentImagesRepository.savePlacedStudentImages(UploadPlacedStudentImage);
				}
				return true;
			} else {
				return false;
			}
		}
		return status;
	}

	/**
	 * this is use for view the multiple images for web service
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<UploadPlacedStudentImages> getAllPlacedStudentImages() throws IOException {
		List<UploadPlacedStudentImages> studentImagesList = uploadPlacedStudentImagesRepository
				.getAllPlacedStudentImages();
		List studentList = new ArrayList();
		UploadPlacedStudentImages studentsImages = null;
		if (studentImagesList != null) {
			for (UploadPlacedStudentImages images : studentImagesList) {
				studentsImages = images;
				String imagePath = ImageFormatWS.readStudentsImage(studentsImages);
				studentList.add(imagePath);
			}
			return studentList;
		} else {
			return null;
		}
	}

}
