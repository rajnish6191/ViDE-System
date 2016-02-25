<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="images/hyd.jpg" align="top" height="180" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="#EB912A" size="5"><b><i>A Vision-Based Approach for   </i></b></font><font color="#4D88DB" size="5"><b><i> Deep Web Data Extraction</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src="images/head.jpg" height="12" width="900"/></td>
			</tr>
		</table>
		<table width="1000">
		
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
		</table>
  <body>
  
		 <br/> <br/>
		 
		 
		 <center>
   <font color="red">
		 <c:if test="${'requestScope.status'!='null'}">
					 
                          <c:out value="${param.status}"></c:out> 
                          </c:if>
                          </font>
                           </center>
  
  
  <table align="center" border="1" bgcolor="" width="90%" cellpadding="10">
   <caption>SEARCH INFORMATION</caption>
   <tr bgcolor="#CCFFFF"><i>Search Count Info</i></tr>
   <br/> 
   <tr bgcolor="#4D88DB"><th><b>UserName</b></th><th><b>Search Content</b></th><th><b>Search Domain</b></th><th><b>Search Date</b></th><th><b>Search Count</b></th>
    </tr>
    
    <c:if test="${not empty searchcount}">
    <c:forEach var="searchcount" items="${searchcount}">
    
    <tr>
    
    
    
    <td>${searchcount.fname }${searchcount.lname }</td>
    <td>${searchcount.content }</td>
    <td>${searchcount.sdomain }</td>
    <td>${searchcount.sdate }</td>
    <td>${searchcount.count }</td>
   
   
    </tr>
    
     </c:forEach>
    </c:if>
    </table>
    
    
    <br/><table>
      
                  <tr>
				<td colspan="1" width="1000" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		
		</table>
    
    
  </body>
</html>
