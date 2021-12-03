package dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.account.Account;
import bean.role.Role;
import bean.spa.SPA;
import bean.userLogin.UserLogin;
import Database.DatabaseConnection;

public class AccountDAO {

	static Connection con 
		= DatabaseConnection.getConnection();
	
	
	public boolean signUpSecond(String fname,String lname,String email,String password,String type) {
				//change username to email
				String accountQuery = "insert into customers_register(first_name, last_name,  email, street, city, state, country, zip_code) VALUES (?, ?, ?)";
				//change username to email
				String loginQuery = "insert into login(email, password) VALUES (?,?)";
				String roleQuery = "insert into role(type, email) VALUES (?,?)";
				
				PreparedStatement ps;
				
				try {
					
					//Adding data in login
					
					ps = con.prepareStatement(loginQuery);
					//change username to email
					ps.setString(1,email);
					ps.setString(2, password);
					ps.execute();
					
					//Added data in Account
					ps = con.prepareStatement(accountQuery);
					ps.setString(1,fname);
					ps.setString(2, lname);
					ps.setString(3, email);
					ps.setString(4, email);
					ps.setString(5, email);
					ps.setString(6, email);
					ps.setString(7, email);
					ps.setString(8, email);
					ps.execute();
					
					//Adding data in Role
					ps = con.prepareStatement(roleQuery);
					ps.setString(1, type);
					//change username to email
					ps.setString(2, email);
					ps.execute();
					
					return true;

				} catch (SQLException e) {
					
					System.out.println(e);
					return false;
				}
				
	}
	public int getUserId(String email) {
		String  updateQuery = "SELECT spa_id from spa_register WHERE email = ?";
		PreparedStatement ps;
		
		try {
			
			//Adding data in login
			
			ps = con.prepareStatement(updateQuery);
			//change username to email
			
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			int id =0;
			while(rs.next())
			{
				
				id = rs.getInt("spa_id");
			}
			
			return id;

		} catch (SQLException e) {
			
			System.out.println(e);
			return 0;
		}
	}
	public boolean addAccountDetails(String email,String street,String city,String state,String country, String zip_code) {
		String  updateQuery = "UPDATE customers_register SET street=?, city=?, state=?, country=?, zip_code=? WHERE email = ?";
		PreparedStatement ps;
		
		try {
			
			//Adding data in login
			
			ps = con.prepareStatement(updateQuery);
			//change username to email
			
			ps.setString(1, street);
			ps.setString(2, city);
			ps.setString(3, state);
			ps.setString(4, country);
			ps.setString(5, zip_code);
			ps.setString(6,email);
			ps.execute();
			
			return true;

		} catch (SQLException e) {
			
			System.out.println(e);
			return false;
		}
	}
	public boolean signUp(Account account, UserLogin login, Role role)
	{
		//change username to email
		String accountQuery = "insert into customers_register(first_name, last_name,  street, "
		          + "city, state, country, zip_code, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		//change username to email
		String loginQuery = "insert into login(email, password) VALUES (?,?)";
		String roleQuery = "insert into role(type, email) VALUES (?,?)";
		
		PreparedStatement ps;
		
		try {
			
			//Adding data in login
			
			ps = con.prepareStatement(loginQuery);
			//change username to email
			ps.setString(1,login.getEmail());
			ps.setString(2, login.getPassword());
			ps.execute();
			
			//Added data in Account
			ps = con.prepareStatement(accountQuery);
			ps.setString(1, account.getFname());
			ps.setString(2, account.getLname());
			
			ps.setString(3, account.getStreet());
			ps.setString(4, account.getCity());
			ps.setString(5, account.getState());
			ps.setString(6, account.getCountry());
			ps.setString(7, account.getZip_code());
			//change username to email
			ps.setString(8, account.getEmail());
			ps.execute();
			
			//Adding data in Role
			ps = con.prepareStatement(roleQuery);
			ps.setString(1, role.getType());
			//change username to email
			ps.setString(2, role.getEmail());
			ps.execute();
			
			return true;

		} catch (SQLException e) {
			
			System.out.println(e);
			return false;
		}
	}
	//change username to email
	public boolean emailExist(String email)
	{
		String query = "Select email from login where email = ?";
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
				return true;
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
	//change username to email
	public Account getUser(String email)
	{
		
		String query = "Select * from customers_register where email = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Account account = new Account();
			while(rs.next())
			{
				
				account.setFname(rs.getString("first_name"));
				account.setLname(rs.getString("last_name"));
				
				account.setStreet(rs.getString("street"));
				account.setCity(rs.getString("city"));
				account.setState(rs.getString("state"));
				account.setCountry(rs.getString("country"));
				account.setZip_code(rs.getString("zip_code"));
				//setUsername change to setemail
				account.setEmail(email);	
			}
			return account;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
	}
	//change username to email
	public boolean isSeller(String email)
	{
		System.out.println(email);
		String query = "Select email from login where email = ?";
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(query);
			//change username to email
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				String roleQuery = "Select type from role where email = ?";
				ps = con.prepareStatement(roleQuery);
				ps.setString(1, email);
				ResultSet role = ps.executeQuery();
				while(role.next())
				{
					if(role.getString("type").equals("Spa"))	
						return true;
					else
						System.out.println("It's not a seller.");
				}
				
				
			}
			
			System.out.println(" It's not a user");
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ACCOUNTDAO: "+e);
			return false;
		}
	}
	
	
}