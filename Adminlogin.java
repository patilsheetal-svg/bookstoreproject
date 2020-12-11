package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/adminLogin")
public class Adminlogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String uname=req.getParameter("uname");
		
		String password=req.getParameter("pass");
		
		if(uname.equals("admin") && password.equals("admin123"))
		{
			resp.sendRedirect("AdminActivity.jsp");
		}
		else
		{
			resp.sendRedirect("Adminlogin.jsp");
		}
	}

}
