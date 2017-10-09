package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Upload;
import com.aartek.prestigepoint.repository.UploadRepository;

@SuppressWarnings("unchecked")
@Repository
public class UploadRepositoryImpl implements UploadRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void uploadJar(Upload upload) {
		hibernateTemplate.saveOrUpdate(upload);
		
	}

	public List<Upload> downloadJar() {
		List<Upload> download = hibernateTemplate.find("from Upload");
		return download;
	}
}
