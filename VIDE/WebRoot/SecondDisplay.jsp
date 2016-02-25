<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.nit.VIDE.DAO.ContentDAO" %>
<%@ page import="com.nit.VIDE.Bean.*" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body>
  
  <table align="center">
			<tr>
				<td colspan="1" width="1000" height="180" valign="top"><img src="images/hyd.jpg" align="top" height="180" width="900"/></td>
			</tr>
			<tr>
				<td colspan="1" width="1000" height="30"><center><font color="#EB912A" size="5"><b><i>A Vision-Based Approach for   </i></b></font><font color="#4D88DB" size="5"><b><i> Deep Web Data Extraction</i></b></font></center></td>
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
		
		<br/>
		
		
	
      
   
                           
                           <jsp:include page="index.jsp"></jsp:include>
                           
                          
                           
                           
                           
                       
                     <%  
                       
                       String pa = request.getParameter("page");
               String title=request.getParameter("title");
                System.out.println("in second Jsp title is..........."+title);
                String login=(String) session.getAttribute("user");
                 String path="";

              if(title.length()==0)
                 {
                 path="index.jsp?status=Plz Enter Proper Data";
				 response.sendRedirect(path);
				 }
				 
				 else{
			
                 
          ContentDAO cdao = new ContentDAO();
          
          
          
          
          
          int pageNo=0;
          if(pa==null)
            pageNo=0;
           else
           pageNo=Integer.parseInt(pa);
          System.out.println(" rows:  pags are..."+pageNo);
           int totalrows=cdao.getTotalRowCount(title);
            System.out.println(" rows are..."+totalrows);
           int totalpages=totalrows/5;
           if(totalrows%5!=0)
           totalpages=totalpages+1;
           	 String path1=request.getRealPath("/userimages");
            System.out.println(totalrows+" rows: total pages are..."+totalpages);
  	      int startrow=(pageNo*5)+1;
  	      int endrow=(pageNo*5)+5;
  	      System.out.println("in jsp start is..............."+startrow);
  	       System.out.println("in jsp end is..............."+endrow);
  	      
  	       Vector<ContentBean> vcb =new ContentDAO().getContentAt(path1,title,startrow,endrow,login);
  	       session.setAttribute("searchinfo", vcb);
         %>

                           
    
   
    <table border="0" width="200" height="250" align="left">
    <div ></div>
    
    <tr bgcolor="#DAF2F1"><i>Narrowing U R Results</i></tr><br/><br/>
     <c:if test="${not empty searchinfo}">
     <c:forEach var="searchinfo" items="${searchinfo}" end="0" >
     
    <tr>
    <td>
   <font size="4" color="#117DF0" style=""> Books</font><font size="3" color="#BD59D9" style="">(${searchinfo.booksno })</font>
    </td>
    </tr>
    <tr>
    <td>
  <font size="4" color="#117DF0" style=""> Mobile</font><font size="3" color="#BD59D9" style="">(${searchinfo.mobileno })</font>
    </td>
    </tr>
    <tr>
    <td>
   <font size="4" color="#117DF0" style="">Musical Inistuments</font><font size="3" color="#BD59D9" style="">(${searchinfo.musicno })</font>
    
    </td>
    </tr>
    </c:forEach>
    </c:if>
    </table>

   
      
  <table border="0" width="800">
   

   <tr bgcolor="#DAF2F1"><td colspan="1" align="center">Showing All The Results</td></tr>
   
   <c:if test="${not empty searchinfo}">
   <c:forEach var="searchinfo" items="${searchinfo}">
   
  <tr ><td align="center">
  <table>
  <tr>
  <td><font size="5" color="#DE2180" style="">Title:${searchinfo.cname }</font></td>
  </tr>
  <tr>
  <td bgcolor="#F4F5F7" ><img alt="SeeImage
  Here" id="previewField" src="userimages/${searchinfo.image }" height="90" width="90"></td>
  
  <td><font size="4" color="#39A4E6" style="">${searchinfo.csubname } </font><br/><br/><a href="#"><i>Buy Now:</i></a>$<font size="4" color="#39A4E6" style=""> ${searchinfo.price }</font> </td>
  <td> &nbsp;&nbsp;&nbsp;&nbsp;</td>
  <td> <font size="4" color="#39A4E6" style="">(PaperBack - ${searchinfo.date })</font><br/><br/><a href="./BookDetails?cid=${searchinfo.cid }">About Content</a></td>
 </tr>
 
   
  <tr><td colspan="4"><i><font size="4" color="#4315E8" style="">In Stock</font></i></td><tr>
                     <tr>               <td colspan="4">....................................................................................</td></tr>
            </table>
           </td></tr>
            
   </c:forEach>
   </c:if>
    <tr><td> 

    <br/><br/>
    <table align="center"><tr><td width="100%">
      (<%=startrow %>-<%if(endrow>totalrows)endrow=totalrows;%><%=endrow %> of <%=totalrows %> Total)
      <%

      if(pageNo>0) {%><a href="./SecondDisplay.jsp?page=0&title=<%=title%>">First</a>|<a href="./SecondDisplay.jsp?page=<%=pageNo-1%>&title=<%=title%>"><< |</a>
      <%}
     // int count=0;
      for(int i=0;i<totalpages;i++){
      if((i==pageNo-2)||(i==pageNo-1)||(i==pageNo)||(i==pageNo+1)||(i==pageNo+2)){
      if(!(pageNo==i)){%><a href="SecondDisplay.jsp?page=<%=i %>&title=<%=title%>"><%}%> <%=(i+1) %></a> | 
      <%//count++;
      }
      //if(count==5)break;
      }
      
      %><%if(pageNo<totalpages-1) {%><a href="SecondDisplay.jsp?page=<%=pageNo+1%>&title=<%=title%>">>> |</a><a href="SecondDisplay.jsp?page=<%=totalpages-1%>&title=<%=title%>">Last</a><%} }%></td></tr>
    
      
      <c:if test="${ empty searchinfo}">
         <tr><td height="24" colspan="6"><div align="center" class="style3"><strong>No Records Found</strong></div></td>
         </tr>
         </c:if>
     
    </table>
    
    </td></tr>
   </table>
   
    
    </td>
     </tr>
     
     <tr><td>
     </td>
     </tr>                       
  

                  
                  <tr>
				<td colspan="1" width="1000" height="20"><img src="images/head.jpg" height="16" width="900"/><br></td>
			</tr>
		
		</table>
		
   
  </body>
</html>
