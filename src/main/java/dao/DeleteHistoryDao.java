package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteHistoryDao {

	public String deleteValues(String name) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="delete from booking where name=?";
			pst=con.prepareStatement(query);
			pst.setString(1, name);
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
