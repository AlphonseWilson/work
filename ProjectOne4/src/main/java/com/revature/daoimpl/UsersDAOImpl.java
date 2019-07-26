package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.beans.Users;
import com.revature.beans.Users;
import com.revature.dao.UserDAO;
import com.revature.util.ConnFactory;

public class UsersDAOImpl implements UserDAO {

	public static ConnFactory cf= ConnFactory.getInstance();
	public static Connection conn = cf.getConnection();


	public void createUser(Users users) throws SQLException {
		// TODO Auto-generated method stub
		//int user_id = users.getUser_id();
		String username = users.getUser_name();
		String password = users.getPass();
		String firstname = users.getUser_FirstName();
		String lastname = users.getUser_LastName();
		String email = users.getUser_email();
		String user_tier = users.getUser_position();
		
	//we use prepared statements bc they are faster and more secure
	// you would only use a STATEMENT for SELECT otherwise you 
	// are open to SQL Injection which can crash you program 
	// and steal peoples data, or messup your code
	// and its much better for updating info.
	
		
		String sql = "INSERT INTO ERS_USERS(users_username,users_password, users_firstname, users_lastname, users_email, users_tier) VALUES(?,?,?,?,?,?)";
	
		PreparedStatement stmt;
		
		stmt = conn.prepareStatement(sql);
		
		//when we set the parameters, we match the value to the index according 
		// to the question array in the SQL string above, SQL index starts at 1
		//stmt.setInt(1, user_id);
		stmt.setString(1, username);
		//we really could also put users.getUsername instead of the username variable in beans
		//the reason we do it this way is to stick to the design pattern, easier and better this way.
		stmt.setString(2,password);
		stmt.setString(3, firstname);
		stmt.setString(4, lastname);
		stmt.setString(5, email);
		stmt.setString(6, user_tier);
		stmt.execute();
		// insert and save ....
		
	}
	
	
	public Users getUser(String username, Users usr) {
	 Users user = new Users();
		String sql="select USERNAME, PASS, EMPID, POSITION, FIRSTNAME, LASTNAME, PHONE, EMAIL, MYMANAGER from USERS where USERNAME = ?";
		
		PreparedStatement stmt;
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			
			ResultSet rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				user.setUser_name(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setUser_id(rs.getInt(3));
				user.setUser_position(rs.getString(4));
				
				user.setUser_FirstName(rs.getString(5));
				user.setUser_LastName(rs.getString(6));
				user.setUser_Phone(rs.getString(7));
				user.setUser_email(rs.getString(8));
				
				user.setUser_ManagerId(rs.getInt(9));

				
		
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return user;
	}
	public List<Users> getPendingRequests(int userId) throws SQLException{
		
		List<Users> userList = new ArrayList<>();
		Connection conn = cf.getConnection();
		
		
		String sql = "SELECT REQID, AMOUNT, PENDINGSTATE FROM REQUESTS WHERE EMPID = 13";
		
		PreparedStatement stmt;
		
		stmt = conn.prepareStatement(sql);
		
		//when we set the parameters, we match the value to the index according 
		// to the question array in the SQL string above, SQL index starts at 1
		//stmt.setInt(1, user_id);
	//	stmt.setInt(1, userId);
				
		ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Users u = new Users();
				int reqid = rs.getInt(1);
				u.setReqid(reqid);
				
				int amount = rs.getInt(2);
				u.setAmount(amount);
				
				String pendingState = rs.getString(3);
				u.setReqState(pendingState);
			      userList.add(u);
				
				
			}

		return userList;
	}
//	thisOne!!!!!!!!!!!!!!!!!!!!
	public void UpdateProfile(String updatedColumn, String update, String USERNAME) throws SQLException {
		
		
		
		String sql = "UPDATE USERS SET "+updatedColumn+" = '"+update+"' WHERE USERNAME = '"+USERNAME+"'";

		

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate(sql);
			

		
	}
	
public void SubmitRequest(Users user, int amount, String picture) throws SQLException {
		
		
		
		String sql = "INSERT INTO REQUESTS (EMPID, AMOUNT, PICTURE, PENDINGSTATE, MANAGER) VALUES ("+user.getUser_id()+","+amount+", '"+picture+"', 'Pending',"+user.getUser_ManagerId()+") ";

		

		PreparedStatement ps = conn.prepareStatement(sql);
		ps.executeUpdate(sql);
			

		
	}

}