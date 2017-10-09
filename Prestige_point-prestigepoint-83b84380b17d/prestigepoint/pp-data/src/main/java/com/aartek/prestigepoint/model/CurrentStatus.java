package com.aartek.prestigepoint.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "currentstatus")
public class CurrentStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CURRENT_STATUS_ID")
	private Integer current_status_Id;

	public Integer getCurrent_status_Id() {
		return current_status_Id;
	}

	public void setCurrent_status_Id(Integer current_status_Id) {
		this.current_status_Id = current_status_Id;
	}


	@Column(name = "CURRENTSTATUS")
	private String currentStatus;


	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}



	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CURRENT_STATUS_ID")
	private List<Registration> registrationList;

	/**
	 * @return the statusId
	 */
	

	/**
	 * @return the isDeleted
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted
	 *            the isDeleted to set
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the registrationList
	 */
	public List<Registration> getRegistrationList() {
		return registrationList;
	}

	/**
	 * @param registrationList
	 *            the registrationList to set
	 */
	public void setRegistrationList(List<Registration> registrationList) {
		this.registrationList = registrationList;
	}

}
