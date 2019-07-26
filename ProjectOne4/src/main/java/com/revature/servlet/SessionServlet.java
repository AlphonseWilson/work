package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Users;
import com.revature.daoimpl.UsersDAOImpl;

//@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	// return a JSON representation of the currently authenticated user for this
	// JSESSIONID.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDAOImpl userImpl = new UsersDAOImpl();
		Users usr = new Users();
		

		// grab current session, if it exists, otherwise get a null value
		HttpSession session = req.getSession(false);
		if (session != null) {
			try {
				HttpSession sess =req.getSession();
				sess.getAttribute("UserName");
				System.out.println("username in session servlet session: "+sess.getAttribute("UserName"));
				String sesUser = (String) sess.getAttribute("UserName");
				
				usr = userImpl.getUser(sesUser, usr);
				ObjectMapper obj = new ObjectMapper();
	
				String sts = new ObjectMapper().writeValueAsString(usr);
				resp.getWriter().write(sts);
			
			
			
			} catch (Exception e) {
				System.out.println("works 1");
				e.printStackTrace();
				resp.getWriter().write("{\"session\":null}");
			}
		} else {
			System.out.println("works 2");
			resp.getWriter().write("{\"session\":null}");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}