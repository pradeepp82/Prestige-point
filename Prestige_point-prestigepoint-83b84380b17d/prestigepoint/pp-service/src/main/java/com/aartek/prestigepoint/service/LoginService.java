
package com.aartek.prestigepoint.service;

import com.aartek.prestigepoint.model.AdminLogin;

public interface LoginService {

	public AdminLogin userSignIn(AdminLogin login);
	
	public boolean signUp(AdminLogin login);

}
