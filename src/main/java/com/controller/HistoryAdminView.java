package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryAdminViewDao;
import model.HistoryPojo;


@WebServlet("/HistoryAdminView")
public class HistoryAdminView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HistoryAdminViewDao ha =new HistoryAdminViewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		try {
			List<HistoryPojo> h=ha.view();
			PrintWriter pw=response.getWriter();
			String htmlResponse ="<html><table border=1><tr><th>name</th><th>email</th><th>bookName</th><th>Update</th><th>Delete</th></tr>";
			for(HistoryPojo history:h) {
				htmlResponse+="<tr><td>"+history.getName()+"</td><td>"+history.getEmail()+"</td><td>"+history.getBookName()+"</td>";
				htmlResponse+="<td><a href='UpdateHistory.html?name="+history.getName()+"'>update</a></td>";
			
				htmlResponse +="<td><form method='post' action='DeleteHistoryServlet'><input type='hidden' name='name' value='"+history.getName()+"'><input type='submit' value='Delete'></form></td></tr>";

			}
			htmlResponse+="</table></html>";
			pw.println(htmlResponse);
			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
