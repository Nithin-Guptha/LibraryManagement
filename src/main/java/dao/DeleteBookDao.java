package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteBookDao {

	public String deleteBookValues(String bid) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="delete from AddedBooks where bid=?";
			pst=con.prepareStatement(query);
			pst.setString(1, bid);
			i=pst.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return "deleted";
		}else {
			return"not deleted";
		}
	}

}
