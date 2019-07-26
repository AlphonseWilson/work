package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Users;
import com.revature.dao.UserDAO;
import com.revature.daoimpl.UsersDAOImpl;

/**
 * Servlet implementation class ViewPendingRequests
 */
public class ViewPendingRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPendingRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsersDAOImpl userImpl = new UsersDAOImpl();
		List <Users> tempList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();

		// grab current session, if it exists, otherwise get a null value
		HttpSession session = req.getSession(false);
		if (session != null) {
			try {
				tempList.addAll(userImpl.getPendingRequests(9));
				
				
				
				PrintWriter out = resp.getWriter();
				
				String requestJson = mapper.writeValueAsString(tempList);
				resp.setContentType("UTF-8");
				System.out.println("this is the jason code from bens help: ");

				System.out.println(requestJson);
				out.print(requestJson);
				out.flush();
			//	resp.getWriter().write(requestJson);
				
				
				
//				HttpSession sess =req.getSession();
//				sess.getAttribute("UserId");
//				System.out.println("username in session servlet session: "+sess.getAttribute("UserName"));
//				String sesUserId = (String) sess.getAttribute("UserId");
//				//int id = Integer.parseInt(sesUserId);
//				int id = 9;//hardcode for tests
//
//				List<Users> usrlist = userImpl.getPendingRequests(id);
//				ObjectMapper obj = new ObjectMapper();
//	
//				String sts = new ObjectMapper().writeValueAsString(usrlist);
//				System.out.println("the list is here: "+sts);
//				resp.getWriter().write(sts);
			
			
			
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