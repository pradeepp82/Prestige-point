package com.aartek.prestigepoint.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.aartek.prestigepoint.model.Upload;

public interface UploadService {

	public List<Upload> downloadJar();

	public void uploadJar(Upload upload, MultipartFile file, String languageType) throws IOException;

}
