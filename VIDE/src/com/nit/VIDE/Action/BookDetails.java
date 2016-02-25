package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.VIDE.Bean.ContentBean;
import com.nit.VIDE.DAO.ContentDAO;

public class BookDetails extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String path="";
		
		try{
			
			
			int cid=(Integer.parseInt(request.getParameter("cid")));
			
			System.out.println("in ACtion class,,,,,,,,,,,,,,content id is .........."+cid);
			
			String path1=request.getRealPath("/userimages");
			String path2=request.getRealPath("/document");
			
			
			Vector<ContentBean> vcb =new ContentDAO().getContentInfo(path1,cid,path2);
			
			 System.out.println("in Content Details..............vcb........."+vcb);
			 
			 
			 
			 
			
			if(!vcb.isEmpty())
			{
				
				path="ContentDetails.jsp?status=U R Requested Information";
				request.setAttribute("contentinfo", vcb);
				
			}
			else
			{
				
				path="ContentDetails.jsp?status=Sorry ! No Data Found Related To U R Search ";
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			path="ContentDetails.jsp?status=Invalid Data ";
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
	}

		
		
		
	}


