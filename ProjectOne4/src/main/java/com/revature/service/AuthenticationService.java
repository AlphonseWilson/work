package com.revature.service;


import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.daoimpl.ReimbursmentDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

public class AuthenticationService {
	
	public static UsersDAOImpl ud= new UsersDAOImpl();
	public static ReimbursmentDAOImpl ur= new ReimbursmentDAOImpl();
	
	public Users authenticateUser(Credentials cred) {
		Users user = null;
		user=ud.getUser(cred.getUsername(), user);
		
		if(cred.getUsername().equals(user.getUser_name()) && cred.getPassword().equals(user.getPass()))
		{	
			//ur.getuserDao(user.getUser_name());
			user = new Users(69, "dog", "pass", cred.getUsername(), "merlsdfghjk.com");
			return user;
		}
			else
		return user;
}
	
	//double handle bars {{ }}} render objects retrived from a database onto an html page.
}