package dao.spa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.account.Account;
import bean.spa.SPA;
import dao.account.AccountDAO;
import Database.DatabaseConnection;

public class SPADAO {

	static Connection con 
	= DatabaseConnection.getConnection();
	AccountDAO account = new AccountDAO();
	public boolean createSPA(SPA spa,String street,String city,String state,String country,String zip_code)
	{
		//change username to email
		String query ="Insert into spa_register(spa_name, phone, license, email)"
				+ "VALUES(?,?,?,?)";
		String update_user_query ="UPDATE `customers_register` SET `street` = ?, `city` = ?, `state` = ?, `country` = ?, `zip_code` = ?  WHERE  email = ?";
		
		
		if(account.isSeller(spa.getSeller().getEmail()))
		{
			System.out.println("Wecolme Beauty Up Club");
			PreparedStatement ps;
			
			try {
				ps = con.prepareStatement(query);
				ps.setString(1, spa.getName());
				ps.setString(2, spa.getPhone());
				ps.setString(3, spa.getLicense());
				ps.setString(4, spa.getSeller().getEmail());
				ps.execute();
				
//				ps = con.prepareStatement(update_user_query);
//				ps.setString(1, street);
//				ps.setString(2, city);
//				ps.setString(3, state);
//				ps.setString(4, country);
//				ps.setString(4, zip_code);
//				ps.setString(4, spa.getSeller().getEmail());
//				ps.execute();
				
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("SPADAO"+e);
				return false;
			}
		}
		
		
		return false; 
	}
	//change username to email
	
	public List<SPA> getAllSPA(){
		System.out.print("DONE");
		List<SPA> spas = new ArrayList<>();
		String SELECT_ALL_SPAS = "SELECT * FROM spa_register";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SPAS);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				int id = rs.getInt("spa_id");
				String name = rs.getString("spa_name");
				String phone = rs.getString("phone");
				String license = rs.getString("license");
				Account email = account.getUser(rs.getString("email"));
				
				spas.add(new SPA(id, name, phone, license, email));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return spas;
	}
	
	public SPA getSPA(String sellerEmail)
	{
		String query = "Select * from spa_register where email = ?";
		
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(query);
			ps.setString(1, sellerEmail);
			ResultSet rs = ps.executeQuery();
			SPA spa = new SPA();
			while(rs.next())
			{
				spa.setName(rs.getString("spa_name"));
				spa.setPhone(rs.getString("phone"));
				spa.setLicense(rs.getString("license"));
				spa.setSeller(account.getUser(sellerEmail));
			}
			return spa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
				
		
	}
	public SPA getSPAByID(int id)
	{
		String query = "Select * from spa_register where spa_id = ?";
		
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			SPA spa = new SPA();
			while(rs.next())
			{
				spa.setId(id);
				spa.setName(rs.getString("spa_name"));
				spa.setPhone(rs.getString("phone"));
				spa.setLicense(rs.getString("license"));
				spa.setSeller(account.getUser(rs.getString("email")));
			
			}
			return spa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
				
		
	}
	
}