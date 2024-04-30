package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLogindao {

	public String CheckLogin(String username, String password)  {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query = "SELECT username, password FROM userData WHERE username = ? AND password = ?";
			pst=con.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			rs=pst.executeQuery();
			if(rs.next()) {
				return "valid details";
			}
			else {
				return "invalid details try again";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error due to DB";
		}
	
	}

}