package com.revature.service;


import com.revature.beans.Users;
import com.revature.daoimpl.ReimbursmentDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

public class AuthenticationService {
	
	public static UsersDAOImpl ud= new UsersDAOImpl();
	public static ReimbursmentDAOImpl ur= new ReimbursmentDAOImpl();
	
	public boolean authenticateUser(String username ,String password, String position) {
		Users user= new Users();
		user=ud.getUser(username);
		
		if(username.equals(user.getUser_name()) && password.equals(user.getPass()))
		{	ur.getuserDao(user.getUser_name());
			return true;
		}
			else
		return false;
}
	
	//double handle bars {{ }}} render objects retrived from a database onto an html page.
}