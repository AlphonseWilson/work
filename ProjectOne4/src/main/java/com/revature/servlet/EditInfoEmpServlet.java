package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.daoimpl.UsersDAOImpl;

/**
 * Servlet implementation class EditInfoEmp
 */
public class EditInfoEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditInfoEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("EditInfoEmp.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAOImpl impl = new UsersDAOImpl();
		String edit = (String)request.getParameter("edit"); 
		String username =(String)request.getParameter("username");
		HttpSession sess =request.getSession();
		String sesUser = (String) sess.getAttribute("UserName");
	
		String sql = "UPDATE USERS SET "+edit+" = '"+username+"' WHERE EMPID = "+sesUser;
		System.out.println(sql);
		try {
			impl.UpdateProfile(edit, username, sesUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.sendRedirect("Employee");		
		
		
	}

}
