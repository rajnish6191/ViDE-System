package com.nit.VIDE.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.nit.VIDE.Bean.ContentBean;
import com.nit.VIDE.DAO.ContentDAO;

public class GetResult extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		ContentBean cb=new ContentBean();
		
		try{
			
			
			Map m=request.getParameterMap();
			
			BeanUtils.populate(cb, m);
			}
		catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String path="";
		String str="";
		
		try{
			HttpSession hs=request.getSession();
			
			String login=(String)hs.getAttribute("user");
			
			 String path1=request.getRealPath("/userimages");
			 
			 String title=request.getParameter("title");
			 int pageNo=0;
			 String pa = request.getParameter("page");
			 if(pa==null)
			 pageNo=0;
			 else
			 pageNo=Integer.parseInt(pa);
			 int totalrows=new ContentDAO().getTotalRowCount(title);
			 int totalpages=totalrows/5;
			 if(totalrows%5!=0)
			 totalpages=totalpages+1;
			 System.out.println(totalrows+" rows: total pages are..."+totalpages);
			 int startrow=(pageNo*5)+1;
			 int endrow=(pageNo*5)+5;


			 
			 System.out.println("in action .............start is...."+startrow);
			
			 
			 if(title.length()==0)
			 {
				 
				 path="index.jsp?status=Plz Enter Proper Data";
				 
			 }
			 else
			 {
			 
			 Vector<ContentBean> vcb =new ContentDAO().getContentAt(path1,title,startrow,endrow,login);
			
			 System.out.println("in getResult..............vcb........."+vcb);
			 
			 
			 
			 hs.setAttribute("searchinfo", vcb);
			
			if(!vcb.isEmpty())
			{
				
				path="Display.jsp?status=U R Requested Information";
				
			}
			else
			{
				
				path="Display.jsp?status=Sorry ! No Data Found Related To U R Search ";
			}
			 }
			
		}
		catch (Exception e) {
			e.printStackTrace();
			path="Display.jsp?status=Invalid Data ";
		}
		
		
		RequestDispatcher rd=request.getRequestDispatcher(path);
		
		rd.forward(request, response);
		
	}

}
