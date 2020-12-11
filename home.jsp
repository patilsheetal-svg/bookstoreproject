<%@page import="java.sql.ResultSet"%>
<%@page import="com.dao.DataAcess"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="Order.jsp">
<h1>Books</h1>

<table border="2">
<tr>

<th>ID</th>

<th>Book name</th>

<th>Author name</th>

<th>Price</th>

<th>Quantity</th>

<th>Select</th>


</tr>

<%
ResultSet rs=DataAcess.viewBook();

int i=0;

while(rs.next())
{
	%>
	
	<tr>
	
	<td><%= rs.getInt(1) %></td>
	
	<td><%= rs.getString(2) %></td>
	
	<td><%= rs.getString(3) %></td>
	
	<td><%= rs.getInt(4) %></td>
	
	<td><input type="text" name="<%= "quantity"+i %>"></td>
	
	<td><input type="checkbox" name="select" value=<%= rs.getInt(1) %> ></td>
	
	</tr>
	
	<% 
}




%>

</table>

<br><br>

<input type="submit" value="purchase">

</form>
</body>
</html>