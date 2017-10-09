package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Registration;

public interface ForgotPasswordRepository {

  public List<Registration> getPassword(String emailId);

}
