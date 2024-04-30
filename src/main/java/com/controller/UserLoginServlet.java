package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserLogindao;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserLogindao ul=new UserLogindao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String result=null;
		try {
			result=ul.CheckLogin(username,password);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("valid details")) {
			RequestDispatcher rd=request.getRequestDispatcher("UserLoginViewServlet");
			rd.forward(request,response);
		}
		else {
			out.println("fail");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
			rd.forward(request, response);
		}
		
				}

}
