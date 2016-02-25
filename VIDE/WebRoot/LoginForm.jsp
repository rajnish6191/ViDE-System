
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<html>
	<head>
	
	<script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>"></script>
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
				<td colspan="1" width="900" height="30"><center><font color="#EB912A" size="5"><b><i>A Vision-Based Approach for    </i></b></font><font color="#4D88DB" size="5"><b><i> Deep Web Data Extraction</i></b></font></center></td>
			</tr>
			<tr>
				<td colspan="1" width="900" height="1" ><img src="images/head.jpg" height="12" width="900"/></td>
			</tr>
		</table>
		<table width="1000">
		
		<c:if test="${'sessionScope.role'!='null'}">
		
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
        <form action="./LoginAction" method=post name="login" >
        <table  border="0" align="center"  bgcolor="white" width="80%">
               <tr>
                 <td height="120" align="right"></td>
                 <td><table border="0" align="center">
                   <tr align="center"><strong><h3><font color="#01AFFF">Login Form</font></h3></strong>
 	</tr>
                   <tr>
                     <td ><span class="Title"><font color="#01AFOO">UserID</font></span></td>
                      <td ><input type="text" name="username">                      </td>
                      </tr>
                   <tr>
                     <td><span class="Title"><font color="#01AFOO">Password</font></span></td>
                      <td>
                        <input type="password" name="password">                      </td>
                      </tr>
                   <tr>
                     <td colspan="2">
                       <div align="center" class="style11">
                         <input type="submit" name="Submit" value="Sign In">
                          &nbsp;
                          <input name="Input2" type="reset" value="Clear">
                         </div>                        </td>
                      </tr>
                 </table></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td>
                 <div align="center"><a href="Recoverpassword.jsp"><strong><font color="">Forgot Password ! !......</font></strong></a></div></td>
                 <td>&nbsp;</td>
               </tr>
               <tr>
                 <td >&nbsp;</td>
                 <td>
                 <div align="center"><a href="RegistrationForm.jsp"><strong><font color="">New User ****</font></strong></a></div></td>
                 <td>&nbsp;</td>
               </tr>
               
             </table>
		
		
          </form>
          
          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  frmvalidator.addValidation("username","req","Login Name is required");
    frmvalidator.addValidation("username","alpha","Login Name is Only Characters");
    frmvalidator.addValidation("password","req","Password is required");

  </script>
          <br/><br/>
			
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		</table>
	</body>
</html>