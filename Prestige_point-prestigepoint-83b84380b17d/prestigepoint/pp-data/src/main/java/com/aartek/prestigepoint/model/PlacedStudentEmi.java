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

@Entity
@Table(name = "emi_placed_student")

public class PlacedStudentEmi implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final PlacedStudentFeeStructure pla = null;
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "PLACED_EMI_ID")
	  private Integer PlacedStuId;

	  @Column(name = "AMOUNT")
	  private Integer amount;
	  
	  @Column(name = "DATE")
	  private String date;

	  @Column(name = "IS_DELETED")
	  private Integer isDeleted;

	  
	  @ManyToOne(fetch = FetchType.EAGER)
	  @JoinColumn(name = "PLACED_STUDENT_ID")
	  private PlacedStudentFeeStructure placedStudentFeeStructure;

	 
	 
	 
	 
	 

}
