
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" type="text/css" href="jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
	<script src="jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
</head>



<body>


	<form action="Display.jsp">
	
	
	<center>
	<br><br/><br/><br/><br/>
	<fieldset>
	<input type="text" id="title" name="title" size="50"/>
	<input type="image"  alt="submit"  src="images/g4.jpg" >
	
	</fieldset>
	</center>
	<script>
		$("#title").autocomplete("getdata.jsp");
	</script>
	
	</form>
	
	<center>
   <font color="red">
		 <c:if test="${'requestScope.status'!='null'}">
					 
                          <c:out value="${param.status}"></c:out> 
                          </c:if>
                          </font>
                           </center>
	
</body>

</html>