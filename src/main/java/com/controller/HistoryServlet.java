package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDao;
import model.HistoryPojo;


@WebServlet("/HistoryServlet")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HistoryDao hd=new HistoryDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	try {
	List<HistoryPojo> h=hd.view();
	PrintWriter pw=response.getWriter();
	String htmlResponse ="<html><table border=1><tr><th>name</th><th>email</th><th>bookName</th></tr>";
	for(HistoryPojo history:h) {
		htmlResponse+="<tr><td>"+history.getName()+"</td><td>"+history.getEmail()+"</td><td>"+history.getBookName()+"</td></tr>";
	}
	htmlResponse+="</table></html>";
	pw.println(htmlResponse);
	}catch(Exception e) {
		e.printStackTrace();
	}

}
}