package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DataAcess;
import com.model.Book;

/**
 * Servlet implementation class addBook
 */
@WebServlet("/addBook")
public class addBook extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String bname=req.getParameter("bname");
		
		String bauthor=req.getParameter("bauthor");
		
		int bprice=Integer.parseInt(req.getParameter("bprice"));
		
		System.out.println(bname);
		
		System.out.println(bauthor);
		
		System.out.println(bprice);
		
		Book b=new Book();
		
		
		b.setBname(bname);
		
		b.setBauthor(bauthor);
		
		b.setPrice(bprice);
		
		int i=DataAcess.addBook(b);
		
		if(i != 0)
		{
			System.out.println("Book added");
			resp.sendRedirect("Welcome.jsp");
		}
		else
		{
			System.out.println("error");
			resp.sendRedirect("addBook.jsp");
		}
	}

}
