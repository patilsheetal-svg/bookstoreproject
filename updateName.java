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
 * Servlet implementation class updateName
 */
@WebServlet("/updateName")
public class updateName extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		String fname=req.getParameter("fname");
		
		String lname=req.getParameter("lname");
		
		System.out.println(id);
		
		System.out.println(fname);
		
		System.out.println(lname);
		
		User u=new User();
		
		u.setFname(fname);
		
		u.setId(id);
		
		u.setLname(lname);
		
		int i=DataAcces.UpdateName(u);
		
		if(i != 0)
		{
			System.out.println("user updated");
			resp.sendRedirect("AdminActivity.jsp");
		}
		else
		{
			System.out.println("error");
			resp.sendRedirect("updateName.jsp");
		}
	}

}
