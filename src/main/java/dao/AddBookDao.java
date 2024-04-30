package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddBookDao {

	public String insertBookDetails(String bid, String bname, String bauthor, String bedition) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query = "INSERT INTO AddedBooks VALUES (?, ?, ?, ?)";
			pst=con.prepareStatement(query);
			pst.setString(1, bid);
			pst.setString(2, bname);
			pst.setString(3, bauthor);
			pst.setString(4, bedition);
			i=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			
			if(i>0) {
				return "inserted successfully";
			}
			else {
				return"fail to insert";
			}
		
	}

}
