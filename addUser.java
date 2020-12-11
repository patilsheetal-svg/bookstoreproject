package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAcces;
import com.model.User;

/**
 * Servlet implementation class addUser
 */
@WebServlet("/addUser")
public class addUser extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String Email=req.getParameter("email");
		String Password=req.getParameter("pass");
		String City=req.getParameter("city");
		
		System.out.println(fname);
		
		System.out.println(lname);
		
		System.out.println(Email);
		
		System.out.println(Password);
		
		System.out.println(City);
		
		User u=new User();
		
		u.setFname(fname);
		
		u.setLname(lname);
		
		u.setEmail(Email);
		
		u.setPassword(Password);
		
		u.setCity(City);
		
		
		int i=DataAcces.addUser(u);
		
		if(i != 0)
		{
			System.out.println("user added");
			resp.sendRedirect("Welcome.jsp");
		}
		else
		{
			System.out.println("error");
			System.out.println("addUser.jsp");
		}
	}

}
