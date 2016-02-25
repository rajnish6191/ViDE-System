package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.VIDE.Bean.RegisterForm;
import com.nit.VIDE.DAO.SecurityDAO;


public class LoginAction extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "LoginForm.jsp?status=Invalid username and password";
		try
		{HttpSession session=request.getSession();
		RegisterForm rb = new RegisterForm();
			String username = request.getParameter("username");
			rb.setLoginid(username);
			String pass=request.getParameter("password");
			rb.setPassword(pass);
             
			String role = new SecurityDAO().loginCheck(rb);

			if (role.equalsIgnoreCase("admin"))
			{
				target = "adminhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			
			else if (role.equalsIgnoreCase("user"))
			{
				
					target = "userhome.jsp?status=Welcome " + username;
				
					target = "userhome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else if (role.equalsIgnoreCase("master"))
			{
				
					target = "MasterHome.jsp?status=Welcome " + username;
				
					target = "MasterHome.jsp?status=Welcome " + username;
				session.setAttribute("user", username);
				session.setAttribute("role", role);
				session.setAttribute("pass",pass);
			}
			else
				target = "LoginForm.jsp?status=Invalid username and password";
		}
		catch (Exception e)
		{
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
