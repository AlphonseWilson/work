package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Reimbursment;
import com.revature.daoimpl.ReimbursmentDAOImpl;

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
		
		response.sendRedirect("SubmitRequestEmp.html");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	//	String reimb_amount=request.getParameter("reimb_amount");
		String reimb_description=request.getParameter("reimb_description");
		String reimb_type=request.getParameter("reimb_type");	
	//	double rm_amount=Double.parseDouble(reimb_amount);

		
	
		
				
				ReimbursmentDAOImpl rd= new ReimbursmentDAOImpl();
				
				try {
					rd.createReimbursment(new Reimbursment(22.2,reimb_description,reimb_type));
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.sendRedirect("Employee.html");
			}
			
			
		}
		
		
	


