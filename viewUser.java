package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAcces;
import com.model.User;

/**
 * Servlet implementation class viewUser
 */
@WebServlet("/viewUser")
public class viewUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		
		String lname=req.getParameter("lname");
		
		String email=req.getParameter("email");
		
		String city=req.getParameter("city");
		
		System.out.println(fname);
		
		System.out.println(lname);
		
		System.out.println(email);
		
		System.out.println(city);
		
		User u=new User();
		
		u.setFname(fname);
		
		u.setLname(lname);
		
		u.setEmail(email);
		
		u.setCity(city);
		
		ResultSet i=DataAcces.viewUser();
		
		if(i != null)
		{
			System.out.println("user viewed");
			
			resp.sendRedirect("Welcome.jsp");
		}
		else
		{
			System.out.println("error");
			
			resp.sendRedirect("viewUser.jsp");
		}
	}

}
