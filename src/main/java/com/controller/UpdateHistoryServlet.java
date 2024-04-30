package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UpdateHistorydao;


@WebServlet("/UpdateHistoryServlet")
public class UpdateHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UpdateHistorydao uh=new UpdateHistorydao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String BookName=request.getParameter("BookName");
		String result=null;
		try {
			result=uh.updateValues(name,email,BookName);
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
			RequestDispatcher rd=request.getRequestDispatcher("UpdateHistory.html");
			rd.forward(request, response);
		}
	}

}
