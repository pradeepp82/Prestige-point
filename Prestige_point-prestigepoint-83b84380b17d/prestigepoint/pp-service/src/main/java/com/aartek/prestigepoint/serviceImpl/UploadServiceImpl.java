package com.aartek.prestigepoint.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aartek.prestigepoint.model.Upload;
import com.aartek.prestigepoint.repository.UploadRepository;
import com.aartek.prestigepoint.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {
	
 private static final Logger logger = Logger.getLogger(UploadServiceImpl.class);
 
  @Autowired
  private UploadRepository uploadRepository;

  @Value("${pp.uploadJar}")
  private String uploadJar;
	
  public void uploadJar(Upload upload, MultipartFile file, String languageType) throws IOException {
   	     OutputStream out = null;
   	     InputStream filecontent = null;
   	     final String fileName = file.getOriginalFilename();
   	     final MultipartFile filePart = file;
   	     final String path = uploadJar + languageType;
		try {
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();
			int read = 0;
			final byte[] bytes = new byte[1024];
			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			upload.setJarType(languageType);
			upload.setNameOfJar(fileName);
			upload.setPathOfJar(path + File.separator + fileName);
			uploadRepository.uploadJar(upload);
		} catch (FileNotFoundException fileNotFoundException) {
			logger.error("FileNotFoundException!" ,fileNotFoundException);
		} finally {
			if (out != null) {
				out.close();
			}
		}
  }

  public List<Upload> downloadJar() {
    List<Upload> l = uploadRepository.downloadJar();
    return l;
  }

}
