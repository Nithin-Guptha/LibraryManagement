package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteHistoryDao;


@WebServlet("/DeleteHistoryServlet")
public class DeleteHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DeleteHistoryDao dh=new DeleteHistoryDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String result=null;
		try {
			result=dh.deleteValues(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(result.equalsIgnoreCase("deleted")) {
			response.sendRedirect(request.getContextPath()+"/HistoryAdminView");
		}else {
			out.println("fail to delete");
		}
	}
	

}
