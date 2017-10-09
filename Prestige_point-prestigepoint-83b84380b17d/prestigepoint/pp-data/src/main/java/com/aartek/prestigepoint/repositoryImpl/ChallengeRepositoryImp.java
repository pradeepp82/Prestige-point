package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.repository.ChallengeRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class ChallengeRepositoryImp implements ChallengeRepository {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChallengeRepositoryImp.class);

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void saveChallenge(AddChallenge addChallenge) {
		hibernateTemplate.saveOrUpdate(addChallenge);
	}

	public List<AddChallenge>  getAllchallenge() {
		List<AddChallenge>  getAllchallenge = hibernateTemplate.find("from AddChallenge ac where ac.isDeleted="
				+ IConstant.IS_DELETED);
		return  getAllchallenge;
	}

	public List<AddChallenge> viewChallengeDetails() {
		List<AddChallenge> getChallengeDetails = hibernateTemplate.find("from AddChallenge ac where ac.isDeleted="
				+ IConstant.IS_DELETED + "and ac.isActive=" + IConstant.IS_DELETED);
		return getChallengeDetails;
	}

	public List<AddChallenge> editChallengeDetails(Integer challengeId) {
		List<AddChallenge> challengeList = hibernateTemplate.find("from AddChallenge a where a.challengeId=" + challengeId);
		return challengeList;
	}

	public void deleteChallenge(Integer challengeId) {
		AddChallenge addChallenge = hibernateTemplate.get(AddChallenge.class, challengeId);
		addChallenge.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != addChallenge) {
			hibernateTemplate.update(addChallenge);
		}
	}


}