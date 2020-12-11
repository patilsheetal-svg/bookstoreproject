package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Book;

public class DataAcess {

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
		

	public static int UpdatePrice(Book b)
	{
		int i=0;
		try
		{
		Connection conn=DataAcess.makeConnection();
		
		PreparedStatement pstmt=conn.prepareStatement("update book1 set bprice=?  where bid=?");
		
		pstmt.setInt(1,b.getPrice());
		
		pstmt.setInt(2, b.getId());
		
		
		
		i=pstmt.executeUpdate();
		
		

		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return i;
	}
	

	public static int addBook(Book b) {
		{
			int i=0;
			try
			{
			
			Connection conn=DataAcess.makeConnection();
			
			
			
				PreparedStatement pstmt = conn.prepareStatement("insert into book1(bid,bname,bauthor,bprice)values(?,?,?,?)");
				
				pstmt.setInt(1, b.getId());
				
				pstmt.setString(2, b.getBname());
				
				pstmt.setString(3, b.getBauthor());
				
				pstmt.setInt(4, b.getPrice());
				
			
				
				i=pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return i;
			
		}
		
	}


	public static int deleteBook(Book b) {
		
		int i=0;
		try
		{
		
		Connection conn=DataAcess.makeConnection();
		
		
		
			PreparedStatement pstmt = conn.prepareStatement("delete from book1 where bid=?");
			
			pstmt.setInt(1, b.getId());
		
			
		
			
			i=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return i;
		
	}
	
	public static ResultSet viewBook()
	{
		ResultSet rs=null;
		
		Connection conn=DataAcess.makeConnection();
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement("select * from book1");
			
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
		
		
	}
	
	
	
	


	
	
}

	



