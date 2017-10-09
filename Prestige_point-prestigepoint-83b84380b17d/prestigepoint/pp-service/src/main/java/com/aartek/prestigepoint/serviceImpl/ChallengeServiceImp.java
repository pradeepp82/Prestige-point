package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AddChallenge;
import com.aartek.prestigepoint.repository.ChallengeRepository;
import com.aartek.prestigepoint.service.ChallengeService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class ChallengeServiceImp implements ChallengeService {
	@Autowired
	private ChallengeRepository addChallengeRepository;

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ChallengeServiceImp.class);

	public boolean saveChallenge(AddChallenge addChallenge) {
		addChallenge.setIsDeleted(IConstant.IS_DELETED);
		addChallenge.setIsActive(IConstant.IS_DELETED_DEACTIVE);
		addChallengeRepository.saveChallenge(addChallenge);
		return true;
	}

	public List<AddChallenge> getAllchallenge() {
		List<AddChallenge> allAddChallengeList = new ArrayList<AddChallenge>();
		allAddChallengeList = addChallengeRepository. getAllchallenge();
		return allAddChallengeList;
	}

	public List<AddChallenge> viewChallengeDetails() {
		List<AddChallenge> getChallengeDetails = new ArrayList<AddChallenge>();
		getChallengeDetails = addChallengeRepository.viewChallengeDetails();
		return getChallengeDetails;
	}

	public AddChallenge editChallengeDetails(Integer challengeId) {
		List<AddChallenge> allAddChallengeList = addChallengeRepository.editChallengeDetails(challengeId);
		if(allAddChallengeList!=null)
			  return allAddChallengeList.get(0);
			else
				return null;
	}

	public void changeChallengeStatus(String challengeIdValue, Integer challengeValue) {
		if (challengeIdValue != null && challengeValue != null) {
			AddChallenge addChallenge = (AddChallenge) addChallengeRepository.editChallengeDetails(challengeValue).get(0);
			if (challengeIdValue.equals("true")) {

				addChallenge.setIsActive(IConstant.IS_DELETED);

				addChallengeRepository.saveChallenge(addChallenge);
			} else {
				System.out.println("else=" + addChallenge);
				addChallenge.setIsActive(IConstant.IS_DELETED_DEACTIVE);
				addChallengeRepository.saveChallenge(addChallenge);
			}

		}
	}

	public void deleteChallenge(Integer challengeId) {
		addChallengeRepository.deleteChallenge(challengeId);
	}

}
