package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteUserDao {

	public String deleteValues(String uid) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="delete from userData where uid=?";
			pst=con.prepareStatement(query);
			pst.setString(1, uid);
			i=pst.executeUpdate();
			
			
		}catch(Exception e) {
			  e.printStackTrace();  
		}
		if(i>0) {
			return"deleted";
		}
		else {
			return"fail to delete try again";
		}
	}

}
