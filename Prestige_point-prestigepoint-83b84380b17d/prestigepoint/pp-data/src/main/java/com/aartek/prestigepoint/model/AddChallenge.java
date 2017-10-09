package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "add_challenge")
public class AddChallenge implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CHALLENGE_ID")
	private Integer challengeId;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DISCRIPTION")
	private String discription;

	@Column(name = "PRICE")
	private Integer price;

	@Column(name = "CHALLENGE_CONDITION")
	private String challengeCondition;

	@Column(name = "DURATION")
	private String duration;

	@Column(name = "TECHNOLOGY")
	private String technology;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@Column(name = "IS_ACTIVE")
	private Integer isActive;

	public Integer getChallengeId() {
		return challengeId;
	}

	public void setChallengeId(Integer challengeId) {
		this.challengeId = challengeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getChallengeCondition() {
		return challengeCondition;
	}

	public void setChallengeCondition(String challengeCondition) {
		this.challengeCondition = challengeCondition;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}


	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
