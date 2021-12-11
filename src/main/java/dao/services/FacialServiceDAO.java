package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import bean.services.Facial;
import bean.services.Massage;
import bean.spa.SPA;
import dao.spa.SPADAO;

public class FacialServiceDAO {

	SPADAO spaDAO;
	public FacialServiceDAO() {
		this.spaDAO = new SPADAO();
	}

	static Connection con 
	= DatabaseConnection.getConnection();
	
	//SPADAO spaDao = new SPADAO();
	
	public List<Facial> getAllServices(){
		List<Facial> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM facial";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ResultSet rs = ps.executeQuery();
		
	
			while(rs.next())
			{
				int id = rs.getInt("Faical_id");
								
				String type = rs.getString("type");
				Double price = Double.parseDouble(rs.getString("price"));
				

				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				//SPA spa = spaDao.getSPAByID(id);
				String image = rs.getString("image");
				services.add(new Facial(id, price, type, image, spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
	
	public List<Facial> getAllSPAServices(int id){
		
		List<Facial> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM facial WHERE spa_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
	
			while(rs.next())
			{
				int facial_id = rs.getInt("Faical_id");	
				String type = rs.getString("type");
				double price = Double.parseDouble(rs.getString("price"));
				
					//System.out.print(rs.getString("spa_id"));
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 services.add(new Facial(facial_id, price, type,spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
	
public Facial getSingleService(int id){
		
	Facial service;
		
		String SELECT_SERVICE_QUERY = "SELECT * FROM facial WHERE Faical_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_SERVICE_QUERY);
			ps.setInt(1,id);
//			System.out.print("getSingleService");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
//				System.out.print("NULL"+rs.getInt("massage_id"));
				int facial_id = rs.getInt("Faical_id");
				String type = rs.getString("type");
//				System.out.print("Price"+rs.getString("price"));
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 service = new Facial(facial_id, price, type,spa);
				 
				 return service;
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return null;
	}
}