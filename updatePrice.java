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
 * Servlet implementation class updatePrice
 */
@WebServlet("/updatePrice")
public class updatePrice extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		int bprice=Integer.parseInt(req.getParameter("bprice"));
		
		System.out.println(id);
		
		System.out.println(bprice);
		
		Book b=new Book();
		
		b.setId(id);
		
		b.setPrice(bprice);
		
		int i=DataAcess.UpdatePrice(b);
				
				if(i != 0)
				{
					System.out.println("price updated");
					resp.sendRedirect("AdminActivity.jsp");
				}
				else
				{
					System.out.println("error");
					resp.sendRedirect("updatePrice.jsp");
				}
		
	}

}
