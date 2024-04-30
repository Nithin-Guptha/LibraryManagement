package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateHistorydao {

	public String updateValues(String name, String email, String bookName) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="Update booking set email=?,bookName=? where name=?";
			pst=con.prepareStatement(query);
			//i=pst.executeUpdate();
			pst.setString(3, name);
			pst.setString(1, email);
			pst.setString(2, bookName);
			i=pst.executeUpdate();
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		if(i>0) {
			return "updated";
			
		}else {
			return "fail to update";
		}
		}
	}


