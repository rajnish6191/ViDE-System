package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nit.VIDE.Bean.ContentBean;
import com.nit.VIDE.DAO.ContentDAO;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class AddContent extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContentBean cb=new ContentBean();
		
		HttpSession hs=request.getSession();
		
		try{
			Map m=request.getParameterMap();
			
			BeanUtils.populate(cb, m);
			
		}catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		String path="";
		
		String login=(String) hs.getAttribute("user");
		
		try{
			
			boolean flag= new ContentDAO().addContent(cb,login); 
			
			if(flag)
			{
				
				path="UploadContent.jsp?status=Content Uploaded Successfully";	
			}
			else {
				
				path="UploadContent.jsp?status=Content Uploading is Failed";
			}
			
		}
		catch (Exception e) {
		
			path="UploadContent.jsp?status=Invalid Entries";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);

}
}
