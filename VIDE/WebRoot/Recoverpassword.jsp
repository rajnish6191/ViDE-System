
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
		<style type="text/css">
.Title {
font-family:Verdana;
font-weight:bold;
font-size:8pt
}
.Title1 {font-family:Verdana;
font-weight:bold;
font-size:8pt
}
        </style>
	</head>
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
                     
		<FORM action="./RecoverPasswordAction" method="post" name="register">
			<TABLE border="0" align="center" bgcolor="white" width=80%>

				<TR>
					<TD> 
						<TABLE border="1" align="center">
						
                    <center>  <h3><strong><font color="#23448965544">ForgotPassword Form </font></strong></h3></center>
							<TR>
								<TD align="right"></TD>
								<TD>
									<TABLE border="0" align="center">
										<TR>
											<TD><span class=Title>
												Login Name</span>
											</TD>
											<TD>
												<INPUT type="text" name="username" value="${sessionScope.user }">
											</TD>
										</TR>
										<TR>
											<TD><span class=Title>
												Secret Question</span>
											</TD>
											<TD><span class=Title>
												<select name="squest">
      <option value="select" selected="true"><font size="3" face="Verdana">--Select One---</font></option>
      <option value="What is your favorite pastime?"><font size="3" face="Verdana">What is your favorite pastime?</font></option>
      <option value="Who your childhood hero?"><font size="3" face="Verdana">Who your childhood hero?</font></option>
      <option value="What is the name of your first school?"><font size="3" face="Verdana">What is the name of your first school?</font></option>
      <option value="Where did you meet your spouse?"><font size="3" face="Verdana">Where did you meet your spouse?</font></option>
      <option value="What is your favorite sports team?"><font size="3" face="Verdana">What is your favorite sports team?</font></option>
      <option value="What is your father middle name?"><font size="3" face="Verdana">What is your father middle name?</font></option>
      <option value="What was your high school mascot?"><font size="3" face="Verdana">What was your high school mascot?</font></option>
      <option value="What make was your first car or bike?"><font size="3" face="Verdana">What make was your first car or bike?</font></option>
      <option value="What is your pet name?"><font size="3" face="Verdana">What is your pet name?</font></option>
    </select>
										</span>	</TD>
										</TR>
										
											
										
										<TR>
											<TD><span class=Title>
												Secret Answer</span>
											</TD>
											<TD>
												<INPUT name="sanswer" type="text">
											</TD>
										</TR>
										<TR>
											<TD colspan="2"><span class=Title>
												<DIV align="center">
													<INPUT name="Input" type="submit" value="Recover">
													&nbsp;
													<INPUT name="Input" type="reset" value="Clear">
												</DIV></span>
											</TD>
										</TR>
									</TABLE>
								</TD>
								<TD>&nbsp;
									
							  </TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</FORM>
		
		<br/>
			
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		</table>
      
	</body>
</html>