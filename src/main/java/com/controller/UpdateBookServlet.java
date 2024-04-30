package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UpdateBookDao;


@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UpdateBookDao ub=new UpdateBookDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String bauthor=request.getParameter("bauthor");
		String bedition=request.getParameter("bedition");
		String result=null;
		try {
			result=ub.updateBookDetails(bid,bname,bauthor,bedition);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("updated")) {
			RequestDispatcher rd=request.getRequestDispatcher("Dashboard.html");
			rd.forward(request, response);
		}
		else {
			out.println("fail");
			RequestDispatcher rd=request.getRequestDispatcher("UpdateBook.html");
			rd.forward(request, response);
		}
	}

}
