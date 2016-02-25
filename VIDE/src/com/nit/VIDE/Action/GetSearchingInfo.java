package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.VIDE.Bean.SearchBean;
import com.nit.VIDE.DAO.ContentDAO;

public class GetSearchingInfo extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path="";
		
		
		try{
			
			Vector<SearchBean> vsb= new ContentDAO().getSearchCount();
			
			System.out.println("in Action Calsss vector is.........."+vsb);
			
			if(!vsb.isEmpty())
			{
				
				path="ViewSearchInfo.jsp?status=Enjoy THe SearchCountInfo of users";
				
				request.setAttribute("searchcount", vsb);
				
				
			}
			else
			{
				path="ViewSearchInfo.jsp?status=Sorry, There r no Searches is Available";
			}
			
			
       }
		catch (Exception e) {
			path="ViewSearchInfo.jsp?status=Invalid Entries ";
			e.printStackTrace();
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response);
		
		
		
	}

}
