package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.VIDE.util.LoggerManager;
import com.nit.VIDE.DAO.SecurityDAO;
import com.nit.VIDE.Bean.RegisterForm;

public class RecoverPasswordAction extends HttpServlet {

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

		String target = "Recoverpasswordfprm.jsp?status=<font color=red>Entries not Matched... Try Again</font>";;
	      try{
	    	  RegisterForm rb=new RegisterForm();
	          String loginid=request.getParameter("username");
	          String sanswer=request.getParameter("sanswer");
	          rb.setLoginid(loginid);
	          rb.setSecretanswer(sanswer);
	          String squestid="";
	          String password="";
	          squestid=request.getParameter("squest");
	           if(request.getParameter("ch")!=null)
	          {
	          
	        	   squestid=request.getParameter("ownquest");
	            
	          }
	             
	          
	          rb.setSecretquestionid(squestid);    
	              password=new SecurityDAO().recoverPasswordByQuestion(rb);
	          if(password.equals("") || password==null)
	              target="Recoverpassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
	          else
	             target="LoginForm.jsp?status=Password is  "+password;
	        }
	        catch(Exception e)
	        {
	           LoggerManager.writeLogSevere(e);
	        }
	        RequestDispatcher rd = request.getRequestDispatcher(target);
	        rd.forward(request,response);
	  
	}

}
