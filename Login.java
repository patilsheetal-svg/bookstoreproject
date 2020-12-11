package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DataAcces;
import com.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		
		String password=req.getParameter("password");
		
		System.out.println(email);
		
		System.out.println(password);
		
		User u=new User();
		
		u.setEmail(email);
		
		u.setPassword(password);
		
		int n=DataAcces.Login(u);
		
		if(n != 0)
		{
			HttpSession session=req.getSession();
			
			session.setAttribute("id", n);
			
			resp.sendRedirect("home.jsp");
		}
		
		else
		{
			resp.sendRedirect("Error.jsp");
			
		}
	}

}
