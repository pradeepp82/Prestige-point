package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.PhotoInFooter;

public interface FooterPhotoRepository {

	public List<PhotoInFooter> getAllStudentName();

	public List<PhotoInFooter> listOfSelectedStudent();

	public boolean changeStatusByStudentId(PhotoInFooter photoInFooter);

	public boolean uncheckStatusByStudentId(PhotoInFooter photoInFooter);

	public List<PhotoInFooter> getSingleStudentDetail(String studentId);

	public List<Object> editSingleStudentDetail(Integer studentId);

	public boolean saveFooterPhoto(PhotoInFooter photoInFooter);

	public void deleteStudentData(Integer studentId);

}
