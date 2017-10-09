package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Upload;

public interface UploadRepository {

  public void uploadJar(Upload upload);

  public List<Upload> downloadJar();

}
