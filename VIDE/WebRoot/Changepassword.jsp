<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
	
	<script type="text/javascript">
	function validator(){
	
	document.getElementById("pass").innerHTML="";
	document.getElementById("change").innerHTML="";
	
	if(document.getElementById("newpass").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter Password";
return false;
	}
	else if(document.getElementById("new").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter New Password";
return false;
	}

	}
	
	</script>
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
                           <center><span class=Title><h3><font color="#ghtblue">Change Password Form</font> </h3></span></center>
      
		<form id="form3" name="newedesignation" method="post"
			action="./ChangePasswordAction" onsubmit="return validator();">
			<table border="0" align="center">
				<tr>
					<td><span class=Title>
					  Login Name
					</span></td>
					<td>
						<input type="text" name="username" value="${sessionScope.user}" readonly />					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  Old Password
					</span></td>
					<td>
						<input type="password" name="oldpassword" id="newpass"/><div id="pass">					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  New Password
					</span></td>
					<td>
						<input type="password" name="newpassword" id="new" />	<div id="change">					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center"><strong>
						  <input type="submit" name="Submit" value="Change" />
						</strong></div>				  </td>
				</tr>
			</table>
		</form>
		
		<br/>
			
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		</table>
	</body>
</html>
  