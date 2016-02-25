
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>
	  	

            <table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="images/hyd.jpg" align="top" height="180" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="#E851AF" size="5"><b><i>A Vision-Based Approach for   </i></b></font><font color="#4D88DB" size="5"><b><i> Deep Web Data Extraction</i></b></font></center></td>
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
                   
		
<center><h3><font color="teal"><b><i>View All Users Details</b></font></h3></center>
   
  
      
      
    <table width="" border="0" align="center" bordercolor="#F4F5F7">
    
      <tr bgcolor="#asHblue">
       
       
       
       
	   
        
       
        <td width="110"><div align="center" class="style8"><b>FirstName</b></div></td>
        <td width="87"><div align="center" class="style8"><b>LastName</b></div></td>
         
        
        <td width="64"><div align="center" class="style8"><b>Dob</b></div></td>
      <td width="110"><div align="center" class="style8"><b>Email</b></div></td>
        <td width="87"><div align="center" class="style8"><b>Fax</b></div></td>
        <td width="87"><div align="center" class="style8"><b>Phone</b></div></td>
        
        <td width="64"><div align="center" class="style8"><b>UserPicture</b></div></td>
        
      </tr>
      
      <c:if test="${not empty UserInfo}">
      <c:forEach var="UserInfo" items="${UserInfo}">
         
      <tr bgcolor="#CEC9FA" >
    
        
       
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${UserInfo.fname }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.lname }</span></div></td>
        
        <td bgcolor="#F4F5F7" ><div align="center" class="style7">  ${UserInfo.dob }</div></td> 
        <td bgcolor="#F4F5F7"><div align="center" class="style7">${UserInfo.email }</div></td>
        <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.fax }</span></div></td>
         <td bgcolor="#F4F5F7"><div align="center"><span class="style7">${UserInfo.mobile }</span></div></td>
        
        <td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="userimages/${UserInfo.photo }" height="50" width="90"></p></td>
        
     </tr>
      </c:forEach>
      </c:if>
      
      <c:if test="${ empty UserInfo}">
     
         <tr><td height="24" colspan="8"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
    
         </c:if>
 </table>
 
 
 
 <br/><br/><table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		</table>
</body>