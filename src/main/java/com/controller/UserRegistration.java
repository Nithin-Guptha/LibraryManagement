package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserRegisterDao;


@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	UserRegisterDao ur=new UserRegisterDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uid=request.getParameter("uid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		
		String result=null;
		try {
			result=ur.insertValues(uid,username,password,dob,email);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("inserted successfully")) {
			out.println("inserted");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
			rd.forward(request,response);
		}
		else {
			out.println("fail");
			RequestDispatcher rd=request.getRequestDispatcher("UserRegistration.html");
			rd.forward(request,response);
		}
		}

}
