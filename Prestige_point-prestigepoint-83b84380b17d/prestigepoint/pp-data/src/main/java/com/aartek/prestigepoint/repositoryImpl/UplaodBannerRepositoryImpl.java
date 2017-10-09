/*package com.aartek.prestigepoint.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.aartek.prestigepoint.model.UploadBanner;
import com.aartek.prestigepoint.repository.UploadBannerRepository;
@Repository
public class UplaodBannerRepositoryImpl implements UploadBannerRepository {

	 @Autowired
	  private HibernateTemplate hibernateTemplate;

	  public void uploadBImage(UploadBanner uploadBanner) {
	    hibernateTemplate.saveOrUpdate(uploadBanner);
	  }
}
*/