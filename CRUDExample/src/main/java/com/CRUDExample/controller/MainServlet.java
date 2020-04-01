package com.CRUDExample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/", name = "MainServlet")
public class MainServlet extends HttpServlet {
	MainDao dao;
	
	@Override
	public void init() throws ServletException {
		String jdbcUrl = getServletContext().getInitParameter("jdbcUrl");
		String userName = getServletContext().getInitParameter("userName");
		String password = getServletContext().getInitParameter("password");
		
		dao = new MainDao(jdbcUrl, userName, password);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("addBook")) {
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				float price = Float.parseFloat(request.getParameter("price"));
				
				System.out.println(title+" !!! "+author+" !!! "+price);
				
				dao.AddBook(0, title, author, price);
				System.out.println("done");
				
				try {
					List<Main> listBook = dao.listAllBooks();
					request.setAttribute("listBook", listBook);
					
					RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if(request.getParameter("action").equals("editBook")) {
				int id = Integer.parseInt(request.getParameter("id"));

				Main existingBook = dao.getBook(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("AddBook.jsp");
		        request.setAttribute("book", existingBook);
		        dispatcher.forward(request, response);
			} else if(request.getParameter("action").equals("updateBook")) {
				System.out.println("dasdas");
				int id = Integer.parseInt(request.getParameter("id"));
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				float price = Float.parseFloat(request.getParameter("price"));
				
				dao.AddBook(id, title, author, price);
				System.out.println("done");
				
				try {
					List<Main> listBook = dao.listAllBooks();
					request.setAttribute("listBook", listBook);
					
					RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if(request.getParameter("action").equals("deleteBook")) {
				System.out.println("dasdas");
				int id = Integer.parseInt(request.getParameter("id"));
				
				dao.DeleteBook(id);
				System.out.println("done");
				
				try {
					List<Main> listBook = dao.listAllBooks();
					request.setAttribute("listBook", listBook);
					
					RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
					rd.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} else {
			try {
				List<Main> listBook = dao.listAllBooks();
				request.setAttribute("listBook", listBook);
				
				RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
