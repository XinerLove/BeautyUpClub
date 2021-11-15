package dao.Login;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

import bean.account.Account;
import bean.userLogin.UserLogin;
	import Database.DatabaseConnection;

     
		
	public class LoginDAO {

		   public boolean login(UserLogin login) {
			   
			   Connection con = DatabaseConnection.getConnection();
			   //change username to email
			   String query = "SELECT email FROM login WHERE email = ? AND password = ?";
			  
			  
			   PreparedStatement ps;
			   try {
				ps = con.prepareStatement(query);
				ps.setString(1,  login.getEmail());
				ps.setString(2,  login.getPassword());
				ResultSet rs = ps.executeQuery();
				if(rs.next())
					return true;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			   return false;
		   }
		   public String checkUserType(String email) {
			   Connection con = DatabaseConnection.getConnection();
			   String query1 = "SELECT * FROM spa_register WHERE email = ?";
			   PreparedStatement ps;
			   String role = "";
			   try {
				ps = con.prepareStatement(query1);
				ps.setString(1,  email);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
						role = "spaOwner";
				}else {
					String query2 = "SELECT * FROM customers_register WHERE email = ?";
					 PreparedStatement ps2;
					 try {
							 ps2 = con.prepareStatement(query2);
							 ps2.setString(1,  email);
							ResultSet rs2 = ps2.executeQuery();
							if(rs2.next()) {
								role = "customer";
							}else {
								role = "no";
							}
							}catch (Exception e) {
								// TODO: handle exception
							}
				}
		   }catch (Exception e) {
				// TODO: handle exception
			}
			
			   return role;
		   }
	
	}

