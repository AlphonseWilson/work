package com.revature.dao;


import java.sql.SQLException;

import com.revature.beans.Reimbursment;

public interface ReimbursmentDAO{
	

		public void createReimbursment(Reimbursment reimb)
			throws SQLException;
}

