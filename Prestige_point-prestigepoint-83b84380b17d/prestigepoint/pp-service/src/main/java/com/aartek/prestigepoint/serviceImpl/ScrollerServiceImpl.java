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

import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.model.UploadImages;
import com.aartek.prestigepoint.repository.ScrollerRepository;
import com.aartek.prestigepoint.service.ScrollerService;
import com.aartek.prestigepoint.util.IConstant;
import com.aartek.prestigepoint.util.ImageFormat;

@Service
public class ScrollerServiceImpl implements ScrollerService {

	private static final Logger logger = Logger.getLogger(ScrollerServiceImpl.class);
	@Autowired
	private ScrollerRepository scrollerRepository;

	@Value("${pp.saveScroller}")
	private String imagePath;

	/**
	 * Method get all batch name form data base and display in grid
	 */
	public List<Scroller> getAllImage() {
		List<Scroller> list = scrollerRepository.getAllImage();
		return list;
	}

	/**
	 * Get batch information for edit batch details.
	 * 
	 * @param batchId
	 */

	/**
	 * Method use for save batch information.
	 * 
	 * @param batch
	 */
	public boolean saveScrollerPhoto(Scroller scroller) {
		boolean status = false;
		if (scroller != null) {
			scroller.setIsDeleted(IConstant.IS_DELETED);
			scroller.setIsStatusActive(IConstant.IS_STATUS_ACTIVE);
			status = scrollerRepository.saveScrollerPhoto(scroller);
			BufferedImage newImg;
			String imageData = scroller.getImgPath().replaceFirst("^data:image/[^;]*;base64,?", "");
			newImg = ImageFormat.decodeToImage(imageData);
			if (newImg != null) {
				try {
					File f = new File(imagePath);
					f.mkdirs();
					ImageIO.write(newImg, "png", new File(imagePath + "/" + scroller.getImageId() + ".png"));
				} catch (IOException e) {
					logger.error("IOException", e);
				}
			}
			return status;
		} else {
			return status;
		}

	}

	/**
	 * Delete batch information.
	 * 
	 * @param batchId
	 */
	public void deleteScrollerImage(Integer imageId) {
		scrollerRepository.deleteScrollerImage(imageId);
	}

	public List<Scroller> getSingleScrollDetail(String imageId) {
		List<Scroller> scrollers = null;
		if (imageId != null) {
			scrollers = scrollerRepository.getSingleScrollDetail(imageId);

		}
		return scrollers;
	}

	public boolean changeStatusByImageId(Scroller scroller) {
		boolean status = false;
		if (scroller != null) {
			scroller.setIsStatusActive(1);
			status = scrollerRepository.changeStatusByImageId(scroller);
			status = true;
		}
		return status;
	}

	public boolean uncheckStatusByImageId(Scroller scroller) {
		boolean status = false;
		if (scroller != null) {
			scroller.setIsStatusActive(0);
			status = scrollerRepository.uncheckStatusByImageId(scroller);
			status = true;
		}
		return status;
	}

	public List<Scroller> getAllScrollImages() {
		List<Scroller> scrollers = scrollerRepository.getAllScrollImages();
		return scrollers;

	}

	public List<UploadImages> viewUploadImages() {
		List<UploadImages> getUploadImages = new ArrayList<UploadImages>();
		getUploadImages = scrollerRepository.viewUploadImages();
		return getUploadImages;
	}

}
