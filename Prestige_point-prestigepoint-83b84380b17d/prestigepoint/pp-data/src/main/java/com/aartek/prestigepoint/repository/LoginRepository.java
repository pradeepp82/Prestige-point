package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AdminLogin;

public interface LoginRepository {

  public List<AdminLogin> adminSignIn(String emailId, String password);
  public boolean signUp(AdminLogin login);

}
