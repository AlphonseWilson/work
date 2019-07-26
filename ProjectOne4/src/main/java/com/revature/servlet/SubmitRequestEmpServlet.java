package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursment;
import com.revature.beans.Users;
import com.revature.daoimpl.ReimbursmentDAOImpl;
import com.revature.daoimpl.UsersDAOImpl;

/**
 * Servlet implementation class SubmitRequestEmpServlet
 */
public class SubmitRequestEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitRequestEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("SubmitRequestEmp.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersDAOImpl impl = new UsersDAOImpl();
		
		Users usr = new Users();
		//form data
		String amount = request.getParameter("amount"); 
		int money = Integer.parseInt(amount);
		String picture =(String)request.getParameter("picture");
		
		
		HttpSession sess =request.getSession();
		String sesUser = (String) sess.getAttribute("UserName");
		
		usr = impl.getUser(sesUser, usr);
		String sql = "INSERT INTO REQUESTS (EMPID, AMOUNT, PICTURE, PENDINGSTATE, MANAGER) VALUES ("+usr.getUser_id()+","+money+", '"+picture+"', 'Pending',"+usr.getUser_ManagerId()+") ";


		
//		String sql = "UPDATE USERS SET "+edit+" = '"+username+"' WHERE EMPID = "+sesUser;
		System.out.println(sql);
		try {
			impl.SubmitRequest(usr, money, picture);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		response.sendRedirect("Employee");		
		
		
	}

}
