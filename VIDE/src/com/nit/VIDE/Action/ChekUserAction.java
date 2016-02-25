package com.nit.VIDE.Action;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nit.VIDE.DAO.RegisterDAO;
import com.nit.VIDE.DAO.SecurityDAO;


public class ChekUserAction extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userid");
		System.out.println("in logincheck ............."+username);
		String target = "RegistrationForm.jsp?status1=Invalid username and password";
		try
		{
			
			 
			boolean flag = new RegisterDAO().checkAvailability(username);
			
			System.out.println("in Action class user is .............."+flag);

			if (flag)
			{
				target = "RegistrationForm.jsp?status1=_/Available";
				
			}
			
			else
				target = "RegistrationForm.jsp?status1=/Alreadyexist&userName="+username;
		}
		catch (Exception e)
		{
			target = "RegistrationForm.jsp?status1=_/<b>Available</b>&userName="+username;
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
