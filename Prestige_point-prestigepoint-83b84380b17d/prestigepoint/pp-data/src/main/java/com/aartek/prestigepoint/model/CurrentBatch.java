package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name = "currentbatch")
public class CurrentBatch implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "CURRENT_BATCH_ID")
  private Integer currentBatchId;

  @Column(name = "STATUS")
  private String status;

  @Column(name = "NO_OF_STUDENT")
  private Integer onOfStudent;

  @Column(name = "YEAR")
  private Integer year;
  
  public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}



public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}



@Column(name = "MONTH")
  private String month;
  
  
  @Column(name = "IS_DELETED")
  private Integer isDeleted;

 
  @Column(name = "BATCH_NAME")
  private String batchName;

  @Column(name = "CURRENT_TOPIC")
  private String currentTopic;

  /**
   * @return the currentBatchId
   */
  public Integer getCurrentBatchId() {
    return currentBatchId;
  }

  /**
   * @param currentBatchId
   *          the currentBatchId to set
   */
  public void setCurrentBatchId(Integer currentBatchId) {
    this.currentBatchId = currentBatchId;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status
   *          the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the onOfStudent
   */
  public Integer getOnOfStudent() {
    return onOfStudent;
  }

  /**
   * @param onOfStudent
   *          the onOfStudent to set
   */
  public void setOnOfStudent(Integer onOfStudent) {
    this.onOfStudent = onOfStudent;
  }

  /**
   * @return the batch
   */
 

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
   * @return the currentTopic
   */
  public String getCurrentTopic() {
    return currentTopic;
  }

  /**
   * @param currentTopic
   *          the currentTopic to set
   */
  public void setCurrentTopic(String currentTopic) {
    this.currentTopic = currentTopic;
  }

public String getBatchName() {
	return batchName;
}

public void setBatchName(String batchName) {
	this.batchName = batchName;
}

}
