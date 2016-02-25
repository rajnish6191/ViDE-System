<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
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
		<br/><br/><br/>
		
      
   <center>
   <font color="red">
		 <c:if test="${'requestScope.status'!='null'}">
					 
                          <c:out value="${param.status}"></c:out> 
                          </c:if>
                          </font>
                           </center>
                           
                           
                           <center>
                           
                           <h3><font color="#1274c9"> <i> Welcome To The WOrld Of </font><font color="#0EC972" size="5"><i>A Vision-Based Approach for Deep Web Data Extraction </i></font>
                           <table>
                           <tr>
                           <td>
                           
                          <tr>
        <td bgcolor="#F4F5F7" ><img alt="SeeImage
                  Here" id="previewField" src="images/w1.jpg" height="225" width="225"></td>
			
                 
                           
                           
                          
                           
                       <td>
                            <table>
                           <tr>
                           <td>
                           
                          <tr>
        <td bgcolor="#F4F5F7" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img alt="SeeImage
                  Here" id="previewField" src="images/w5.jpg" height="225" width="225"></td>
			
                 
                           
                           
                           </tr>
                           
                           </table>
                           </td>
                           </tr>
                           </table>
                           </center>
                           
                                      
              <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="12" width="900"/><br></td>
			</tr>
		</table>              
          
  </body>
</html>
