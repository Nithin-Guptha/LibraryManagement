package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookingDao;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookingDao bd=new BookingDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String bookName=request.getParameter("book");
	String result=null;
	try {
		result=bd.bookingInsert(name,email,bookName);
	}catch(Exception e) {
		e.printStackTrace();
	}
	PrintWriter out=response.getWriter();
	if(result.equalsIgnoreCase("inserted")) {
		RequestDispatcher rd=request.getRequestDispatcher("BookingSuccess.html");
		rd.forward(request, response);
	}else {
		out.println("fail");
		RequestDispatcher rd=request.getRequestDispatcher("Bookinghtml.html");
		rd.forward(request, response);
	}
	}

}
