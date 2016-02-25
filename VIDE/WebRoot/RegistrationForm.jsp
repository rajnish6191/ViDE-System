
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String st = "";
	if (request.getParameter("userid") != null) {
%>
<%
	st = request.getParameter("userid");
%>
<%
	}
%>
<html>
<head>
	<script type="text/javascript">
	 
	 function CheckAvailable()
	 {
	   
	    var userid=document.getElementById("userid").value;
	    var user="";
	    if(userid==user)
	    {
	        alert("user id is required");
	        return false;
	    }
	    window.location.href="./ChekUserAction?userid="+userid;
	 }
	 
	 function  checkPass()
	 {	 
	   var pwd1=document.getElementById("userpwd").value;
	   var pwd2=document.getElementById("repwd").value;
	   if(pwd1!=pwd2){
	     alert("password not mathed");
	     return false;
	   }
	 }
	 
   
   </script>
	<script language="JavaScript" type="text/javascript"
		src="scripts/ts_picker.js"></script>
</head>
<body>

<table align="center">
			<tr>
				<td colspan="1" width="900" height="180" valign="top"><img src="images/hyd.jpg" align="top" height="180" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="30"><center><font color="#E851AF" size="6"><b><i>A Vision-Based Approach for   </i></b></font><font color="#4D88DB" size="6"><b><i> Deep Web Data Extraction</i></b></font></center></td>
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
	<form action="./RegisterAction" method="post" name="registerform">
		<table width="900" align="center">
			<tr>
				<td colspan="2" align="center">
					
				</td>
			</tr>
			<tr bgcolor="#fffff">
				<td colspan="2" align="center">
					<font color="green" size="5">Registration Form</font>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="red">Note:</font> fill all the column with valid data
					to complete your registration...
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font size="4" color="blue">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Authentication
						Details</font>
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Create User ID </font>
				</td>
				<td>
					<input type="text" name="userid" size="30" value="<%=st%>"  onchange="javascript:CheckAvailable()">
					
					
				</td>
			
			<td>
			<center>
   <font color="green">
		 <c:if test="${'requestScope.status1'!='null'}">
					 
                          <c:out value="${param.status1}"></c:out> 
                          </c:if>
                          </font>
                           </center>
                           </td>
                           </tr>
			<tr>
				<td align="center">
					<font size="4">Create Password</font>
				</td>
				<td>
					<input type="password" name="userpwd" size="30">
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">ReEnter Password</font>
				</td>
				<td>
					<input type="password" name="repwd" size="30"
						onblur="javascript:checkPass();">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Select Security Question</font>
				</td>
				<td>
					<font size="3" face="Verdana">
					 <select
							name="questn">
							<option value="">--Select One---</option>
							<option value="What is your favorite pastime?">What is your favorite pastime?</option>
							<option value="Who your childhood hero?">Who your childhood hero?</option>
							<option value="What is the name of your first school?">What is the name of your first school?</option>
							<option value="Where did you meet your spouse?">Where did you meet your spouse?</option>
							<option value="What is your favorite sports team?">What is your favorite sports team?</option>
							<option value="What is your father middle name?">What is your father middle name?</option>
							<option value="What was your high school mascot?">What was your high school?</option>
							<option value="What make was your first car or bike?">What make was your first car or bike?</option>
							<option value="What is your pet name?">What is your pet name?</option>
						</select> </font>
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Type Your Answer</font>
				</td>
				<td>
					<input type="text" name="ansr" size="30">
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="left">
					<font color="blue" size="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;Personal Details</font>
				</td>
			</tr>
			<tr>
				<td bgcolor="black" colspan="2"></td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">First Name</font>
				</td>
				<td>
					<input type="text" name="fname" size="30">
					
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<font size="4">Last Name</font>
				</td>
				<td>
					<input type="text" name="lname" size="30">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Date Of Birth</font>
				</td>
				<td>
					<input type="text" name="dob" size="30">
				
					<a
						href="javascript:show_calendar('document.registerform.dob', document.registerform.dob.value);">
						<img src="./images/cal.gif" alt="a" width="18" height="18"
							border="0" />
					</a>
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Browse Photo</font>
				</td>
				<td>
					<input type="file" name="photo" size="30">
					
				</td>
			</tr>
			
			<tr>
				<td align="center">
					<font size="4">Mobile Number</font>
				</td>
				<td>
					<input type="text" name="mobile" size="30">
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Email Address</font>
				</td>
				<td>
					<input type="text" name="email" size="30">
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Fax</font>
				</td>
				<td>
					<input type="text" name="fax" size="30">
					
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					
					</td></tr><tr><td bgcolor="#ashblue" colspan="2"><br></td></tr><tr><td align="center"><br></td><td><br></td></tr><tr><td align="center"><br></td><td><br></td></tr><tr><td colspan="2">
					<font color="blue" size="4">Address Details</font>
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">House No</font>
				</td>
				<td>
					<input type="text" name="hno" size="30">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Street/village Name</font>
				</td>
				<td>
				<input type="text" name="sname">
					
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">City/Mandal Name</font>
				</td>
				<td>
					<input type="text" name="city">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">State Name</font>
				</td>
				<td>
					<input type="text" name="state">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Country Name</font>
				</td>
				<td>
					<input type="text" name="country">
				</td>
			</tr>
			<tr>
				<td align="center">
					<font size="4">Pin Code</font>
				</td>
				<td>
					<input type="text" name="pin" size="30">
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input  type="submit" value="SubmitDetails">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>