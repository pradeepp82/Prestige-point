package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.AddChallenge;

public interface ChallengeService {

	public boolean saveChallenge(AddChallenge addChallenge);

	public List<AddChallenge>  getAllchallenge();

	public List<AddChallenge> viewChallengeDetails();

	public AddChallenge editChallengeDetails(Integer challengeId);

	public void deleteChallenge(Integer challengeId);

	public void changeChallengeStatus(String challengeIdValue, Integer challengeValue);

}
