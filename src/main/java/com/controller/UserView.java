package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserViewDao;
import model.UserData;


@WebServlet("/UserView")
public class UserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	UserViewDao uv=new UserViewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try {
		List<UserData> u=uv.view();
	PrintWriter pw=response.getWriter();
	String htmlResponse="<html><table border=1><tr><th>uid</th><th>username</th><th>password</th><th>dob</th><th>email</th><th>Update</th><th>Delete</th></tr>";
	
	for(UserData users:u) {
		htmlResponse +="<tr><td>"+users.getUid()+"</td><td>"+users.getUsername()+"</td><td>"+users.getPassword()+"</td><td>"+users.getDob()+"</td><td>"+users.getEmail()+"</td>";
		htmlResponse +="<td><a href='UpdateUser.html?uid="+users.getUid()+"'>update</a></td>";
		htmlResponse +="<td><form method='post' action='DeleteUserServlet'><input type='hidden' name='uid' value='"+users.getUid()+"'><input type='submit' value='Delete'></form></td></tr>";

	}
	htmlResponse +="</table></html>";
	pw.println(htmlResponse);
	}catch(Exception e) {
		e.printStackTrace();
	}

	}
}
