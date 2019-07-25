package com.revature.dao;

import java.sql.SQLException;

import com.revature.beans.Users;

public interface UserDAO {
	
	//this is the Employee DAO that is an interface that contain methods for specific operations
	
	public void createUser(Users users)
			throws SQLException;
}

