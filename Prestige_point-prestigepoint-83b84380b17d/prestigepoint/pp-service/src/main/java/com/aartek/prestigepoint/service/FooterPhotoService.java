package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.PhotoInFooter;

public interface FooterPhotoService {

	public List<PhotoInFooter> getAllStudentName();

	public boolean changeStatusByStudentId(PhotoInFooter photoInFooter);

	public boolean uncheckStatusByStudentId(PhotoInFooter photoInFooter);

	public List<PhotoInFooter> listOfSelectedStudent();

	public PhotoInFooter editSingleStudentDetail(Integer studentId);

	public List<PhotoInFooter> getSingleStudentDetail(String studentId);

	public boolean saveFooterPhoto(PhotoInFooter photoInFooter);

	public void deleteStudentData(Integer studentId);

}
