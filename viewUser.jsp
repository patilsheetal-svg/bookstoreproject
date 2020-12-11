<%@page import="com.dao.DataAcces"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.model.User" %>
    
   <%@ page import ="com.dao.DataAcess" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2">
<tr>
<th>first name</th>
<th>last name</th>
<th>email</th>
<th>city</th>
</tr>

<%

     ResultSet rs=DataAcces.viewUser();

while(rs.next())
{
	%>
	
	<tr>
	
	<td> <%= rs.getString(1) %></td>
	
	
	<td> <%= rs.getString(2) %></td>
	
	
	<td> <%= rs.getString(3) %></td>
	
	
	<td> <%= rs.getString(4) %></td>
	
	</tr>
	
	<% 
}











%>
</table>

</body>
</html>