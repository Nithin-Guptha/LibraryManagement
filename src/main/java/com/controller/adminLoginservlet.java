package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.adminLoginDao;


@WebServlet("/adminLoginservlet")
public class adminLoginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	adminLoginDao al=new adminLoginDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String result=null;
		try {
			result=al.checkValues(username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("valid details")) {
			RequestDispatcher rd=request.getRequestDispatcher("Dashboard.html");
			rd.forward(request, response);
		}
		else {
			out.println("fail");
			RequestDispatcher rd=request.getRequestDispatcher("adminLogin.html");
			rd.forward(request, response);
		}
	}

}
