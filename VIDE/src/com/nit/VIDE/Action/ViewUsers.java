package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.VIDE.DAO.UserDAO;
import com.nit.VIDE.util.CoreList;

public class ViewUsers extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


doPost(request, response);



}


public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

String path="";

  try{
	  
	 
	    String path1=request.getRealPath("/userimages");
	  
	 
	  
	  CoreList vqb= new UserDAO().getUsers(path1);				  								 
	  
	  request.setAttribute("UserInfo", vqb);
	  System.out.println("in Action class vcb Feedback..........."+vqb);
	  
	  
	  if(!vqb.isEmpty())
	  {
		  
		  path="ViewUserProfile.jsp?status=Here Is The Users Info";
		 }
	  else {
		  
		  path="ViewUserProfile.jsp?status=No Users R Available ";
		
	}
	  
}
  catch (Exception e) {
	e.printStackTrace();
	path="ViewUserProfile.jsp?status=Invalid Entries";
}


  RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request,response);


}
}
