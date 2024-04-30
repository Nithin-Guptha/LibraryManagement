package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginBothServlet")
public class LoginBothServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin", "root", "root");

            PreparedStatement pst = con.prepareStatement("select * from libraryadmin where username=? AND password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            boolean isAdmin = rs.next();

            PreparedStatement psmt = con.prepareStatement("select username, password from userData where username=? AND password=?");
            psmt.setString(1, username);
            psmt.setString(2, password);
            ResultSet rss = psmt.executeQuery();
            boolean isStudent = rss.next();

            if (isAdmin) {
                response.sendRedirect("Dashboard.html");
            } else if (isStudent) {
                response.sendRedirect("userLoginNew.html");
            } else {
                out.println("Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
