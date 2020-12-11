package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Book;
import com.model.User;

public class DataAcces {


	public static Connection makeConnection()
	{
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		
		System.out.println("driver loaded");
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookproject","root","root");
		
		System.out.println("connection success");
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	

public static int UpdateName(User u)
{
	int i=0;
	try
	{
	Connection conn=DataAcces.makeConnection();
	
	PreparedStatement pstmt=conn.prepareStatement("update user set name=?  where id=?");
	
	pstmt.setString(1,u.getFname());
	
	pstmt.setInt(2, u.getId());
	
	
	
	i=pstmt.executeUpdate();
	
	

	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	return i;
}


public static int addUser(User u) {
	{
		int i=0;
		try
		{
		
		Connection conn=DataAcces.makeConnection();
		
		
		
			PreparedStatement pstmt = conn.prepareStatement("insert into book(id,fname,lname,email,password,city)values(?,?,?,?,?,?)");
			
			pstmt.setInt(1, u.getId());
			
			pstmt.setString(2, u.getFname());
			
			pstmt.setString(3, u.getLname());
			
			pstmt.setString(4, u.getEmail());
			
			pstmt.setString(5, u.getPassword());
			
			pstmt.setString(6, u.getCity());
			
		
			
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return i;
		
	}
	
}


public static int deleteUser(User u) {
	
	int i=0;
	try
	{
	
	Connection conn=DataAcces.makeConnection();
	
	
	
		PreparedStatement pstmt = conn.prepareStatement("delete from user where id=?");
		
		pstmt.setInt(1, u.getId());
	
		
	
		
		i=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return i;
	
}

public static ResultSet viewUser()
{
	ResultSet rs=null;
	
	Connection conn=DataAcces.makeConnection();
	
	PreparedStatement pstmt;
	try {
		pstmt = conn.prepareStatement("select * from user");
		
		rs=pstmt.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
	
	
	
}


public static int Login(User u) {
	// TODO Auto-generated method stub
	return 0;
}




}
