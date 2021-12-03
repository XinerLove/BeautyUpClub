package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import bean.services.Facial;
import bean.services.Laser;
import bean.spa.SPA;
import dao.spa.SPADAO;

public class LaserServiceDAO {

	static Connection con 
	= DatabaseConnection.getConnection();
	
	SPADAO spaDao = new SPADAO();
	
	public List<Laser> getAllServices(){
		List<Laser> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM laser";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ResultSet rs = ps.executeQuery();
		
	
			while(rs.next())
			{
				int id = rs.getInt("laser_id");
				
				Double price = Double.parseDouble(rs.getString("price"));
				
				String type = rs.getString("type");
				
				SPA spa = spaDao.getSPAByID(id);
				
				services.add(new Laser(id, price, type, spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
	
	public List<Laser> getAllSPAServices(int id){
		List<Laser> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM laser WHERE spa_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
	
			while(rs.next())
			{
				int laser_id = rs.getInt("laser_id");
				String type = rs.getString("type");
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDao.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 services.add(new Laser(laser_id, price, type,spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
}