<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.nit.VIDE.Bean.ContentBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
  <body>
  
   
   <table align="center">
			<tr>
				<td colspan="1" width="1000" height="180" valign="top"><img src="images/hyd.jpg" align="top" height="180" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="1000" height="30"><center><font color="#EB912A" size="6"><b><i>A Vision-Based Approach for   </i></b></font><font color="#4D88DB" size="6"><b><i> Deep Web Data Extraction</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="1000" height="1" ><img src="images/head.jpg" height="12" width="900"/></td>
			</tr>
			<tr>
			<td>
		
		
		<c:if test="${sessionScope.role!='null'}">
		
   				<c:choose>
   				<c:when test="${sessionScope.role=='admin'}">
   				<jsp:include page="adminmenu.jsp"/>
   				</c:when>
   		        
   				
   				
   				
			    			
				
   				<c:when test="${sessionScope.role=='user'}">
   				<jsp:include page="Customeroptions.jsp"/>
   				</c:when>
   
			     <c:otherwise>
						<jsp:include page="menubeforelogin.jsp"/>
					</c:otherwise>
					</c:choose>
					</c:if>
		</td>
		</tr>
		</table>
		<br/><br/>
		
		
		<center>
   <font color="red">
		 <c:if test="${'requestScope.status'!='null'}">
					 
                          <c:out value="${param.status}"></c:out> 
                          </c:if>
                          </font>
                           </center>
                           <br/><br/>
                           
                           <table border="0" width="800">
   

   <tr bgcolor="#DAF2F1"><td colspan="1" align="center">View Results</td></tr>
   
   <br/><br/>
		
		<c:if test="${not empty contentinfo}">
		<c:forEach var="contentinfo" items="${contentinfo}">
		
   <tr>
  <td bgcolor="#F4F5F7"  align="center"><img alt="SeeImage Here" id="previewField" 
        src="userimages/${contentinfo.image }" height="200" width="200"></td>
        <td align="left">${contentinfo.description }</td>
  </tr>
  </c:forEach>
  </c:if>
  
  
   </table>
   
   <%
   
    String path=request.getRealPath("/document");
    
    
    Vector<ContentBean> vcb=(Vector<ContentBean>)request.getAttribute("contentinfo");
    
    for(ContentBean doc:vcb)
    {
    %>
    <%
    
    int cid=doc.getCid();
    String content=doc.getContent();
     %>
   
  
		
   
  <center> <a href='<%=path+'/'+cid+content%>'>Open Document</a></center>
  
  
  <%

out.println("<br>");

}
 %>
  
   <br/>
   <table>
   
     <tr>
				<td colspan="1" width="1000" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		
		</table>
   
  </body>
</html>
