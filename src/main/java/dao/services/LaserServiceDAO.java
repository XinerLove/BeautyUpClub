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
import bean.services.Massage;
import bean.spa.SPA;
import dao.spa.SPADAO;

public class LaserServiceDAO {

	SPADAO spaDAO;
	public LaserServiceDAO() {
		this.spaDAO = new SPADAO();
	}

	static Connection con 
	= DatabaseConnection.getConnection();
	
	//SPADAO spaDao = new SPADAO();
	
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
				String type = rs.getString("type");
				Double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
	
				
				//SPA spa = spaDao.getSPAByID(id);
				
				String image = rs.getString("image");
				services.add(new Laser(id, price, type, image, spa));
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
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 services.add(new Laser(laser_id, price, type,spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
	
public Laser getSingleService(int id){
		
		Laser service;
		
		String SELECT_SERVICE_QUERY = "SELECT * FROM laser WHERE laser_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_SERVICE_QUERY);
			ps.setInt(1,id);
//			System.out.print("getSingleService");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.print("NULL"+rs.getInt("massage_id"));
				int laser_id = rs.getInt("laser_id");
				String type = rs.getString("type");
//				System.out.print("Price"+rs.getString("price"));
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 service = new Laser(laser_id, price, type,spa);
				 
				 return service;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}

}