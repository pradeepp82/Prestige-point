package com.aartek.prestigepoint.model;

import java.io.Serializable;

import javax.persistence.Transient;

public class Mail implements Serializable{
	
private static final long serialVersionUID = 1L;

@Transient
private String emailId;

@Transient
private String subject;

@Transient
private String message;

@Transient
private String allStudent;

@Transient
private String allEnquiry;




public String getEmailId() {
	return emailId;
}

public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getSubject() {
	return subject;
}

public void setSubject(String subject) {
	this.subject = subject;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getAllStudent() {
	return allStudent;
}

public void setAllStudent(String allStudent) {
	this.allStudent = allStudent;
}

public String getAllEnquiry() {
	return allEnquiry;
}

public void setAllEnquiry(String allEnquiry) {
	this.allEnquiry = allEnquiry;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

}
