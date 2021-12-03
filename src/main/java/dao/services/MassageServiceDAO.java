package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import bean.account.Account;
import bean.services.Facial;
import bean.services.Massage;
import bean.spa.SPA;
import dao.spa.SPADAO;

public class MassageServiceDAO {

	SPADAO spaDAO;
	public MassageServiceDAO() {
		this.spaDAO = new SPADAO();
	}
	static Connection con 
	= DatabaseConnection.getConnection();
	

	public List<Massage> getAllServices(){
		List<Massage> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM massage";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("massage_id");
				String type = rs.getString("type");
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 services.add(new Massage(id, price, type,spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return services;
	}
	
	public List<Massage> getAllSPAServices(int id){
		List<Massage> services = new ArrayList<>();
		String SELECT_ALL_SERVICES = "SELECT * FROM massage WHERE spa_id = ?";
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(SELECT_ALL_SERVICES);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
	
			while(rs.next())
			{
				int massage_id = rs.getInt("massage_id");
				String type = rs.getString("type");
				double price = Double.parseDouble(rs.getString("price"));
				
				 SPA spa =   this.spaDAO.getSPAByID(Integer.parseInt(rs.getString("spa_id")));
				
				 services.add(new Massage(massage_id, price, type,spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
}