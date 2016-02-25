<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 
 <script language="JavaScript" src="<%=request.getContextPath()+"/scripts/gen_validatorv31.js"%>"></script>
 
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
          
          
          
          
          
		<form action="AddContent" name="content">
		
    <table border="1" width="785" height="173">
    
    <tr bgcolor="#FFOOCCFFDD"><i> Upload Content</i></tr>
    <caption>UPLOAD CONTENT INFO</caption>
    <tr>
    <br/>
     <tr>
    <td width="128"><span class="style17"><font color="higblue"><b>ContentTitle</b></font> </span></td>
    <td width="269"><label>
    <input type="text" name="cname">
      </label></td>
     </tr>
      <tr>
    <td width="128"><span class="style17"><font color="higblue"><b>Content Sub Title</b></font> </span></td>
    <td width="269"><label>
    <input type="text" name="csubname">
      </label></td>
     </tr>
                              <tr>
                             <td width="128"><span class="style17"><font color="higblue"><b>ContentDescription</b></font> </span></td>
                                <td width="269"><label>
                                
                                <textarea rows="5" cols="30" name="description"></textarea>
                           
                            
                                </label></td>
                              </tr>
                              
                              <tr>
                             <td width="128"><span class="style17"><font color="higblue"><b>ContentCatagery</b></font> </span></td>
                                <td width="269"><label>
                                
                                <select name="catagery">
                                <option>--Select--</option>
                                <option value="international">International</option>
                                <option value="national">National</option>
                                </select>
                                </label>
                                </td>
                                </tr>
 
                              <tr>
    <td width="128"><span class="style17"><font color="higblue"><b>ContentTopic</b></font> </span></td>
    <td width="269"><label>
    <input type="text" name="topic">
      </label></td>
     </tr>
                              
                              
                              <tr>
                                <td><span class="style17"><font color="higblue"><b>Content Image</b></font></span></td>
                                <td>
                                 
                         
                                <input type="file" name="image"  onChange="preview(this)" />
                                     
                                    
                                    
                                </td>
                              </tr>

                              <tr>
                                <td><span class="style17"><font color="higblue"><b>BrowseContent</b></font></span></td>
                                <td>
                                 
                         
                                <input type="file" name="content"  onChange="preview(this)" />
                                     
                                    
                                    
                                </td>
                              </tr>
                              <tr>
    <td width="128"><span class="style17"><font color="higblue"><b>ContentPrice</b></font> </span></td>
    <td width="269"><label>
    <input type="text" name="price">
      </label></td>
     </tr>
     <tr>
    <td width="128"><span class="style17"><font color="higblue"><b>ContentType</b></font> </span></td>
    <td width="269"><label>
    <input type="text" name="ctype">
      </label></td>
     </tr>
                              <br/>
                              
<tr>
                             <td align="right">
                             <input type="submit" name="submit" value="UpLoad">
                              </td></tr>
    </table>
    
    
    
<br/>
			
                  <table>
                  
                  <tr>
				<td colspan="2" width="900" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		</table>
    </form>
    
    
     
          <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("content");

     frmvalidator.addValidation("cname","req","Content Title is required");
    
    frmvalidator.addValidation("csubname","req","subname is required");
    
    
    frmvalidator.addValidation("description","req","Description Name is required");
   
    frmvalidator.addValidation("topic","req","topic is required");
   
    
    frmvalidator.addValidation("price","req","Description Name is required");
    frmvalidator.addValidation("price","numeric");
    frmvalidator.addValidation("ctype","req","ctype is required");
    
  </script>
    
  </body>
</html>
