package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteUserDao;


@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DeleteUserDao du=new DeleteUserDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid=request.getParameter("uid");
		String result=null;
		try {
			result=du.deleteValues(uid);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("deleted")) {
			RequestDispatcher rd=request.getRequestDispatcher("Dashboard.html");
			rd.forward(request,response);
		}else {
			out.println("fail");
			RequestDispatcher rd=request.getRequestDispatcher("UserLogin.html");
			rd.forward(request,response);
		}
	}

}
