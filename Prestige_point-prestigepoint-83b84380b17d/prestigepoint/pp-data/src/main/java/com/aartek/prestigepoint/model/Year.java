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
@Table(name = "year")
public class Year implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "YEAR_ID")
	private Integer yearId;

	@Column(name = "YEAR")
	private String year;

	@Column(name = "IS_DELETED")
	private Integer isDeleted;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "YEAR_ID")
	private List<Registration> registrationList;

	/**
	 * @return the yearId
	 */
	public Integer getYearId() {
		return yearId;
	}

	/**
	 * @param yearId
	 *            the yearId to set
	 */
	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

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
