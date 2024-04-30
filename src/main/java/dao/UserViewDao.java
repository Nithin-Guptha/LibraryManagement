package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.UserData;

public class UserViewDao {

	public List<UserData> view() {
		Connection con = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	    List<UserData> users=new ArrayList<UserData>();
	    
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nithin", "root", "root");
	        pst = con.prepareStatement("select * from userData");
	        rs = pst.executeQuery();
	        
	        while(rs.next()) {
	        	UserData u=new UserData();
	        	u.setUid(rs.getString("uid"));
	        	u.setUsername(rs.getString("username"));
	        	u.setPassword(rs.getString("password"));
	        	u.setDob(rs.getString("dob"));
	        	u.setEmail(rs.getString("email"));
	        	users.add(u);
	        	
	        }

	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return users;
	}

}
