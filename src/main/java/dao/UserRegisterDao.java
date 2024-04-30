package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserRegisterDao {
	public String insertValues(String uid,String username,String password, String dob,String email) {
	{
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			String url="jdbc:mysql://localhost:3306/nithin";
			String uname="root";
			String pass="root";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
			String query="insert into userData values(?,?,?,?,?)";
			pst=con.prepareStatement(query);
			pst.setString(1, uid);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, dob);
			pst.setString(5, email);
			
			i=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return "inserted successfully";
		}
		else {
			return "fail to insert";
		}
	}

	}
}
