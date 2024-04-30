package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateUserDao {

	public String updateUserValues(String uid, String username, String password, String dob, String email) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="update userData set username=?,password=?,dob=?,email=? where uid=?";
			pst=con.prepareStatement(query);
			pst.setString(5, uid);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, dob);
			pst.setString(4, email);
			i=pst.executeUpdate();
			
		}catch(Exception e) {
			  e.printStackTrace();  
		}
		if(i>0) {
			return"updated";
		}
		else {
			return"fail to update try again";
		}
	}

}
