<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.nit.VIDE.DAO.ContentDAO"%>
<%@ page import="com.nit.VIDE.DAO.DummyDB" %>

<%@page import="com.nit.VIDE.Bean.form1"%>

<%!String title; %>
<%

	DummyDB db = new DummyDB();

	String query = request.getParameter("q");
	System.out.println(query);
	
	List<form1> countries = db.getData(query);
    for(form1 form1:countries)
    {
     title=form1.getTitle();
    out.println(title+"-"+form1.getSubTitle());
        out.println(title+"-"+form1.getSubTitle()+"-"+form1.getDomain());
    
    
    }
   session.setAttribute("title",title);
	
%>
