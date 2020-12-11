
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.dao.DataAcess"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2">
<tr>

<th>ID</th>

<th>Book name</th>

<th>Author name</th>

<th>Price</th>

<th>Quantity</th>

<th>Total Amount</th>


</tr>

<form action="Confirm.jsp">

<%

String[] selected=request.getParameterValues("select");

Connection conn=DataAcess.makeConnection();

int id=0;

if(selected != null)
{
	for(int i=0;i<selected.length;i++)
	{
	id=Integer.parseInt(selected[i]);
	
	System.out.println("id"+id);
	
	int Quantity=Integer.parseInt(request.getParameter("Quantity"+(id)));
	
	PreparedStatement pstmt=conn.prepareStatement("select * from book where bid="+id);
	
	ResultSet rs=pstmt.executeQuery();
	
	while(rs.next())
	{
		
		%>
		
		<tr>
		
		<td><%= rs.getInt(1) %></td>
		
		<td><%= rs.getString(2) %></td>
		
		<td><%= rs.getString(3) %></td>
		
		<% int price= rs.getInt(4); %>
		<td><%= Quantity %></td>
		<td><%= price %></td>
		<% int amt=Quantity*price; %>
		<td><%= amt %></td>
		
		</tr>
		
		<% 
	}
	
	}
}


%>

</table>

<input type="submit" value="confirm purchase"><br>

</form>

</body>
</html>