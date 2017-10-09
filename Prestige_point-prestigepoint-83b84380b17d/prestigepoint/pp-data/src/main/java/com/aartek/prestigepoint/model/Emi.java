package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "emi")
public class Emi implements Serializable {

  private static final long serialVersionUID = 1L;
private static final Registration emi = null;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "EMI_ID")
  private Integer emiId;

  @Column(name = "AMOUNT")
  private Integer amount;
  
  @Column(name = "DATE")
  private String date;

  @Column(name = "IS_DELETED")
  private Integer isDeleted;

  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "REGISTRATION_ID")
  private Registration registration;

  /**
   * @return the emiId
   */
  public Integer getEmiId() {
    return emiId;
  }

  /**
   * @param emiId
   *          the emiId to set
   */
  public void setEmiId(Integer emiId) {
    this.emiId = emiId;
  }

  /**
   * @return the date
   */
  @JsonIgnore
  public String getDate() {
    return date;
  }

  /**
   * @param date
   *          the date to set
   */
  @JsonIgnore
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * @return the isDeleted
   */
  public Integer getIsDeleted() {
    return isDeleted;
  }

  /**
   * @param isDeleted
   *          the isDeleted to set
   */
  public void setIsDeleted(Integer isDeleted) {
    this.isDeleted = isDeleted;
  }

  /**
   * @return the registration
   */
  public Registration getRegistration() {
    return registration;
  }

  /**
   * @param registration
   *          the registration to set
   */
  public void setRegistration(Registration registration) {
    this.registration = registration;
  }

  /**
   * @return the amount
   */
  public Integer getAmount() {
    return amount;
  }

  /**
   * @param amount
   *          the amount to set
   */
  public void setAmount(Integer amount) {
    this.amount = amount;
  }

public Registration getEmi() {
	return emi;
}

public Emi editEmi() {
	return null;
}

}
