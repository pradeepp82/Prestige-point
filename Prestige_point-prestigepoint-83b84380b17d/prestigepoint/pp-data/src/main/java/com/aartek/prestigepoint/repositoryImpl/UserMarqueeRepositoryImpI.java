package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddMarquee;
import com.aartek.prestigepoint.repository.UserMarqueeRepository;
import com.aartek.prestigepoint.util.IConstant;
@Repository
public class UserMarqueeRepositoryImpI implements UserMarqueeRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unchecked")
	public List<AddMarquee> fatchMarqueeDescription() {

		List<AddMarquee> getMarqueeDetails = hibernateTemplate.find("from AddMarquee ac where ac.isDeleted="
				+ IConstant.IS_DELETED + "and ac.isActive=" + IConstant.IS_Active);
		return getMarqueeDetails ;
	}
}
