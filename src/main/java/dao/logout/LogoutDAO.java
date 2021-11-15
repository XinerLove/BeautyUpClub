package dao.logout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;

public class LogoutDAO {
	public boolean logout(String email,String password) {
		   
		   Connection con = DatabaseConnection.getConnection();
		
		   String query = "DELETE FROM login WHERE email = ? AND password = ?";
		  
		  
		   PreparedStatement ps;
		   try {
			ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		   return false;
	   }
}
