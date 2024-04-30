package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.BookData;

public class UserLoginViewDaao {
	public List<BookData> view() {
	    Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    List<BookData> books = new ArrayList<BookData>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin", "root", "root");
	        pst = con.prepareStatement("select * from AddedBooks");
	        rs = pst.executeQuery();

	        while (rs.next()) {
	            BookData b = new BookData();
	            b.setBid(rs.getString("bid"));
	            b.setBname(rs.getString("bname"));
	            b.setBauthor(rs.getString("bauthor"));
	            b.setBedition(rs.getString("bedition"));
	            books.add(b); 
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pst != null) {
	                pst.close();
	            }
	            if (con != null) {
	                con.close();
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	    return books;
	}
}
