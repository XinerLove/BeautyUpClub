package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.services.Massage;
import bean.services.Service;
import bean.spa.SPA;
import dao.spa.SPADAO;
import Database.DatabaseConnection;

public class ServiceDAO {

	SPADAO spaDAO;
	public ServiceDAO() {
		this.spaDAO = new SPADAO();
	}
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
	
	public Boolean updateSingleService(String id, String service, String type, double price) {
		System.out.print(id);
		String massage_id = id;
		System.out.println("ServiceName: "+service);
//		System.out.print(type);
//		System.out.print(price);
		String UPDATE_SERVICE_QUERY = "";
		if(service.equals("massage")) {
			 UPDATE_SERVICE_QUERY = "UPDATE massage SET type = ?, price = ? WHERE massage_id = ? ";
		}
		if(service.equals("facial")) {
			 UPDATE_SERVICE_QUERY = "UPDATE facial SET type = ?, price = ? WHERE Faical_id = ? ";
		}
		if(service.equals("laser")) {
			 UPDATE_SERVICE_QUERY = "UPDATE laser SET type = ?, price = ? WHERE laser_id = ? ";
		}
		
		PreparedStatement ps;
		
		try {
			ps= con.prepareStatement(UPDATE_SERVICE_QUERY);
			
			ps.setString(1, type);
			ps.setDouble(2, price);
			ps.setInt(3, Integer.parseInt(massage_id));
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}
	}
	
public Massage getSingleService(int id){
		
		Massage service;
		
		String SELECT_SERVICE_QUERY = "SELECT * FROM massage WHERE massage_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_SERVICE_QUERY);
			ps.setInt(1,id);
//			System.out.print("getSingleService");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.print("NULL"+rs.getInt("massage_id"));
				int massage_id = rs.getInt("massage_id");
				String type = rs.getString("type");
//				System.out.print("Price"+rs.getString("price"));
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 service = new Massage(massage_id, price, type,spa);
				 
				 return service;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
}