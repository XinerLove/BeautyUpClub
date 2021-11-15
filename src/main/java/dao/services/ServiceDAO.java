package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.services.Service;
import Database.DatabaseConnection;

public class ServiceDAO {

	static Connection con 
	= DatabaseConnection.getConnection();
	
	public boolean addService(Service service, int id)
	{
		String table = service.getClass().getSimpleName().toLowerCase();
		String query = "Insert into "+table+"(type,price,spa_id) VALUES(?, ?, ?) ";
		
		PreparedStatement ps;
		
		try {
			ps= con.prepareStatement(query);
			ps.setString(1, service.getType());
			ps.setDouble(2, service.getPrice());
			ps.setInt(3, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}
		
	}
}