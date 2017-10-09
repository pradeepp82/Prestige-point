package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Scroller;
import com.aartek.prestigepoint.model.UploadImages;

public interface ScrollerService {

	public List<Scroller> getAllImage();

	public boolean changeStatusByImageId(Scroller scroller);

	public boolean uncheckStatusByImageId(Scroller scroller);

	public List<Scroller> getSingleScrollDetail(String imageId);

	public boolean saveScrollerPhoto(Scroller scroller);

	public void deleteScrollerImage(Integer imageId);

	public List<Scroller> getAllScrollImages();

	public List<UploadImages> viewUploadImages();

}
