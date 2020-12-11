package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAcces;
import com.dao.DataAcess;
import com.model.User;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname");
		
		System.out.println(fname);
		
		User u=new User();
		
		u.setFname(fname);
		
		int i=DataAcces.deleteUser(u);
		
		if(i != 0)
		{
			System.out.println("user deleted");
			resp.sendRedirect("Welcome.jsp");
		}
		else
		{
			System.out.println("error");
			resp.sendRedirect("deleteUser.jsp");
		}
		
	}

}
