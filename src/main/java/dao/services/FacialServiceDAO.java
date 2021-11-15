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
import bean.spa.SPA;
import dao.spa.SPADAO;

public class FacialServiceDAO {
	static Connection con 
	= DatabaseConnection.getConnection();
	
	SPADAO spaDao = new SPADAO();
	
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
				
				Double price = Double.parseDouble(rs.getString("price"));
				
				String type = rs.getString("type");
				
				SPA spa = spaDao.getSPAByID(id);
				
				services.add(new Facial(id, price, type, spa));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	
			return services;
	}
}
