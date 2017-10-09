package com.aartek.prestigepoint.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.aartek.prestigepoint.model.Registration;
import com.aartek.prestigepoint.model.UploadPlacedStudentImages;

import sun.misc.BASE64Encoder;

public class ImageFormatWS {
	public static String readImage(Integer registrationId, String imagePath) throws IOException {
		// Pseudo Code
		if (imagePath!=null&& !imagePath.equals("false")) {
			BufferedImage bufferedImage = ImageIO
					.read(new File(IConstant.IMAGE_WS_PATH + "/" + registrationId + ".png"));
			/*
			 * String []formatSplit=imageDao.split("\\.");
			 * if(formatSplit.length==2){ String format=formatSplit[1];
			 */
			String format = "png";

			BASE64Encoder base64Encoder = new BASE64Encoder();
			String imageString = null;
			String encodedImage = null;
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			try {
				ImageIO.write(bufferedImage, format, bos);
				byte[] imageBytes = bos.toByteArray();
				encodedImage = base64Encoder.encode(imageBytes);
				imageString = encodedImage;
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return imageString;
		} else {
			return null;
		}
	}

	public static String readStudentsImage(UploadPlacedStudentImages studentsImages) throws IOException {
		if (studentsImages.getNameOfStudentImages()!=null&& !studentsImages.getNameOfStudentImages().equals("")) {
				File file = new File(IConstant.PLACED_STUDENT_IMAGE + "/" + studentsImages.getStudentImagesId()+ ".png");
				// Pseudo Code
				BufferedImage bufferedImage = ImageIO.read(file);
				String format = "png";
				BASE64Encoder base64Encoder = new BASE64Encoder();
				String imageString = null;
				String encodedImage = null;
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				try {
					ImageIO.write(bufferedImage, format, bos);
					byte[] imageBytes = bos.toByteArray();
					encodedImage = base64Encoder.encode(imageBytes);
					imageString = encodedImage;
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return imageString;
		} else {
			return null;
		}
	}
}

