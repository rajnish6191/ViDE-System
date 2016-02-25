package com.nit.VIDE.Action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.nit.VIDE.Bean.RegisterForm;
import com.nit.VIDE.DAO.RegisterDAO;
import com.sun.org.apache.commons.beanutils.BeanUtils;







public class RegisterAction extends HttpServlet {
	
	
public	void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
	
	doPost(request, response);
		
		
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		RegisterForm rb=new RegisterForm();
		
		
		System.out.println("=============================In Side Registered action Class====================");
		
		try{
			Map m=request.getParameterMap();
			
			BeanUtils.populate(rb, m);
			
		}catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String path="";
		
		try{
		
		RegisterDAO wd=new RegisterDAO();
		System.out.println("==============created RegisterDAO================");
		System.out.println("in side register action of national");
		
		
		
		boolean flag=wd.insertNewUser(rb);
	
		System.out.println("in register action class ...."+flag);
		
		if(flag)
		{
		
			path="LoginForm.jsp?status=Register is Successful";
		}else
		{
			
			path="RegistrationForm.jsp?status=registration is Failed";
			
		}
		
	
	}
		catch (Exception e) {
			
			path="RegistrationForm.jsp?status=Invalid entries";
		}
		
	
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
	}

}
