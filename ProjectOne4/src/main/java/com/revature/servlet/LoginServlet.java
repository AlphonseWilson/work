package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Users;
import com.revature.service.AuthenticationService;

public class LoginServlet  extends HttpServlet {

	private static AuthenticationService au = new AuthenticationService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("index.html");
	}
	  
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Credentials cred = new Credentials();
		cred.setUsername(req.getParameter("username")); 
		cred.setPassword(req.getParameter("password")); 
		cred.setPosition(req.getParameter("position")); 
	
		
		boolean istrue=au.authenticateUser(cred) != null;
		HttpSession sess =req.getSession();
		sess.setAttribute("UserName", cred.getUsername());
		System.out.println("username session: "+sess.getAttribute("UserName"));
		System.out.println(cred.getUsername());
		
		if(istrue==true) {
			
			
			sess.setAttribute("Users", true);
			
			
			if(cred.getPosition().equals("manager")) {
				resp.sendRedirect("Manager");
			}else {
				resp.sendRedirect("Employee");			

			}
		}		
		else 			
			resp.sendRedirect("loginpage");		
		
	}
	
	
	
}