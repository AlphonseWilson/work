package com.revature.driver;

import java.sql.SQLException;

import com.revature.beans.Reimbursment;
import com.revature.daoimpl.ReimbursmentDAOImpl;
import com.revature.service.AuthenticationService;

public class Driver {

	public static void main(String[] args) {
	

		AuthenticationService au = new AuthenticationService();
		System.out.println(au.authenticateUser("MNOFAL","PASSWORD","employee"));
		
		Reimbursment reimb= new Reimbursment(432423, "FSSSSSF", "23", "TTTTTTTYYYYYY",1, "SADs", "sASAss");
		ReimbursmentDAOImpl rd= new ReimbursmentDAOImpl();
		
		try {
			
			
			rd.createReimbursment(reimb);
	
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		UsersDAOImpl ud = new UsersDAOImpl();
		Users users= new Users("moh","moh22","mohammed", "hijazi", "moh",5);
		
		try {
			ud.createUser(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("added Users");
	}	
	
		*/
		
		/*
		 * ReimbursmentDAOImpl rd = new ReimbursmentDAOImpl(); Reimbursment reimb= new
		 * Reimbursment(200.00 , "7/16/2019" , "7/20/2019" , "ballin out of control", 5
		 * , 1 , "pending" , "boss stuff");
		 * 
		 * try { rd.createReimbursment(reimb); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * System.out.println("added Reimbursment");
		 */
	
}	
}