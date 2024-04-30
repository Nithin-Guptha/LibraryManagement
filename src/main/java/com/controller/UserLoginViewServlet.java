package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserLoginViewDaao;
import model.BookData;


@WebServlet("/UserLoginViewServlet")
public class UserLoginViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserLoginViewDaao ulv=new UserLoginViewDaao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<BookData> b=ulv.view();
			//List<BookData> b=bvv.view();
			PrintWriter pw=response.getWriter();
			String htmlResponse="<html><table border=1><tr><th>bid</th><th>bname</th><th>bauthor</th><th>bedition</th><th>Booking</th></tr>";
			for(BookData books:b) {
				htmlResponse += "<tr><td>"+books.getBid()+"</td><td>"+books.getBname()+"</td><td>"+books.getBauthor()+"</td><td>"+books.getBedition()+"</td>";
				htmlResponse +="<td><a href='Bookinghtml.html?bid="+books.getBid()+"'>Book</a></td></tr>";
				//htmlResponse +="<td><form method='post' action='DeleteBookServlet'><input type='hidden' name='bid' value='"+books.getBid()+"'><input type='submit' value='Delete'></form></td></tr>";
			}
			htmlResponse +="</table></html>";
			pw.println(htmlResponse);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
	}

}
