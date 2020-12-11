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
 * Servlet implementation class deleteBook
 */
@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		System.out.println(id);
		
		Book b=new Book();
		
		b.setId(id);
		
		int i=DataAcess.deleteBook(b);
		
		if(i != 0)
		{
			System.out.println("Book deleted");
			resp.sendRedirect("Welcome.jsp");
		}
		else
		{
			System.out.println("error");
			resp.sendRedirect("deleteBook.jsp");
		}
	}

}
