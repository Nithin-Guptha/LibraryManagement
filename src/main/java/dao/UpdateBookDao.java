package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateBookDao {

	public String updateBookDetails(String bid, String bname, String bauthor, String bedition) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="update AddedBooks set bname=?,bauthor=?,bedition=? where bid=?";
			pst=con.prepareStatement(query);
			pst.setString(4, bid);
			pst.setString(1, bname);
			pst.setString(2, bauthor);
			pst.setString(3, bedition);
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
