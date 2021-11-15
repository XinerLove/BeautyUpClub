package dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Database.DatabaseConnection;
import bean.account.Account;
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
}