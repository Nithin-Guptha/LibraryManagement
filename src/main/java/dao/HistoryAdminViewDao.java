package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.HistoryPojo;

public class HistoryAdminViewDao {

	public List<HistoryPojo> view() {
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<HistoryPojo> history= new ArrayList<HistoryPojo>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin","root","root");
			String query="select*from booking";
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next()) {
				HistoryPojo h=new HistoryPojo();
				h.setName(rs.getString("name"));
				h.setEmail(rs.getString("email"));
				h.setBookName(rs.getString("bookName"));
				history.add(h);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return history;
	}
	
}
