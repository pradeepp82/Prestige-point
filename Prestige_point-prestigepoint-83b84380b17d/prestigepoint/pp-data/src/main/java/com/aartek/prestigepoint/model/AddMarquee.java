package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "add_marquee")
public class AddMarquee  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MARQUEE_ID")
	private Integer marqueeId;
	
	@Column(name = "MARQUEE_DISCRIPTION")
	private String discription;
	
	@Column(name = "IS_DELETED")
	private Integer isDeleted;
	
	@Column(name = "IS_ACTIVE")
	private Integer isActive;

	public Integer getMarqueeId() {
		return marqueeId;
	}

	public void setMarqueeId(Integer marqueeId) {
		this.marqueeId = marqueeId;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

}
