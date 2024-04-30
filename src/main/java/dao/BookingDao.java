package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BookingDao {

	public String bookingInsert(String name, String email, String bookName) {
		Connection con=null;
		PreparedStatement pst=null;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query=("insert into booking values(?,?,?)");
			pst=con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,bookName);
			i=pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
			return"inserted";
		}else {
			return"Fail to insert";
		}
	}

}
