package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookViewDao;
import model.BookData;


@WebServlet("/BookView")
public class BookView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookViewDao bv=new BookViewDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	try {
	List<BookData> b=bv.view();
	PrintWriter pw=response.getWriter();
	String htmlResponse="<html><table border=1><tr><th>bid</th><th>bname</th><th>bauthor</th><th>bedition</th><th>Update</th><th>Delete</th></tr>";
	for(BookData books:b) {
		htmlResponse += "<tr><td>"+books.getBid()+"</td><td>"+books.getBname()+"</td><td>"+books.getBauthor()+"</td><td>"+books.getBedition()+"</td>";
		htmlResponse +="<td><a href='UpdateBook.html?bid="+books.getBid()+"'>update</a></td>";
		htmlResponse +="<td><form method='post' action='DeleteBookServlet'><input type='hidden' name='bid' value='"+books.getBid()+"'><input type='submit' value='Delete'></form></td></tr>";
	}
	htmlResponse +="</table></html>";
	pw.println(htmlResponse);
	}
	catch(Exception e) {
		e.printStackTrace();
	}

}
}
