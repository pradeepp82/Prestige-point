package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AdminLogin;

public interface ForgotPasswordAdminRepository {

public List<AdminLogin> getPassword(String emailId);

}
