package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddChallenge;

public interface ChallengeRepository {

	public void saveChallenge(AddChallenge addChallenge);

	public List<AddChallenge>  getAllchallenge();

	public List<AddChallenge> viewChallengeDetails();

	public List<AddChallenge> editChallengeDetails(Integer challengeId);

	public void deleteChallenge(Integer challengeId);

	

}
