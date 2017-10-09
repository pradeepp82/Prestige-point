package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddMarquee;
import com.aartek.prestigepoint.repository.MarqueeRepository;
import com.aartek.prestigepoint.util.IConstant;
@SuppressWarnings("unchecked")
@Repository
public class MarqueeRepositoryImpI implements MarqueeRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean saveMarquee(AddMarquee addMarquee) {
		if(addMarquee!=null){
		hibernateTemplate.saveOrUpdate(addMarquee);
		return true;
		}else{
			return false;
		}
	}
	
	public List<AddMarquee> getAllMarqueeDiscription() {
		List<AddMarquee> marqueeList = hibernateTemplate.find("from AddMarquee mqu where  mqu.isDeleted=" + IConstant.IS_DELETED);
		return marqueeList;
	}


	public List<AddMarquee> editMarqueeDescription(Integer marqueeId) {
	List<AddMarquee> marqueeList = hibernateTemplate.find("from AddMarquee a where a.marqueeId=" + marqueeId);
	return marqueeList;
		
	}

	@SuppressWarnings("unused")
	public boolean deleteMarqueeDescription(Integer marqueeId) {
		AddMarquee Addmarquee = hibernateTemplate.get(AddMarquee.class, marqueeId);
		  Addmarquee .setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
			if (null != Addmarquee ) {
				hibernateTemplate.update(Addmarquee);
				return true;
			}else{
				return false;
			}
		}
		
	}

