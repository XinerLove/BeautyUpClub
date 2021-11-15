package web.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DatabaseConnection;
import bean.account.Account;
import bean.services.Facial;
import bean.services.Laser;
import bean.services.Massage;
import bean.services.Service;
import bean.spa.SPA;
import dao.services.ServiceDAO;
import dao.spa.SPADAO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addService")
public class ServiceServlet extends HttpServlet implements Servlet{

	static Connection con 
	= DatabaseConnection.getConnection();
	ServiceDAO serviceDAO;
	
	public ServiceServlet()
	{
		serviceDAO = new ServiceDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String serviceName = request.getParameter("service");
		String type = request.getParameter("type");
		double price = Double.parseDouble(request.getParameter("price"));
		int spaId = 0;
				HttpSession session2 = request.getSession();
				if(session2.getAttribute("email") != null) {
					String email = 	session2.getAttribute("email").toString();
					
					String query = "Select * from spa_register where email = ?";
					
					PreparedStatement ps;
					
					try {
						
						ps = con.prepareStatement(query);
						ps.setString(1, email);
						ResultSet rs = ps.executeQuery();
						SPA spa = new SPA();
						while(rs.next())
						{
							spaId = Integer.parseInt(rs.getString("spa_id"));
						}
					} catch (SQLException e) {
						
					}
				}
			

		SPA spa = new SPADAO().getSPAByID(spaId);
		if(spa!=null)
		{
			Service service = null;
			switch(serviceName)
			{
			case "laser":
				service = new Laser(price, type, spa);
				break;
			case "massage":
				service = new Massage(price, type,  spa);
				break;
			case "facial":
				service = new Facial(price, type,  spa);
				break;
			}
			
			if(serviceDAO.addService(service, spaId))
			{
				HttpSession session = request.getSession();
				session.setAttribute("serviceErrMessage", "Service Added Successfully.");
				response.sendRedirect("/BeautyUpClub/profile");
			}
			else
			{
				HttpSession session = request.getSession();
				session.setAttribute("serviceErrMessage", "Incomplete Info.");
				response.sendRedirect("addService.jsp");
			}
			
		}
		else
		{
			HttpSession session = request.getSession();
			session.setAttribute("serviceErrMessage", "Invalid spa id.");
			response.sendRedirect("addService.jsp");
		}
		
	}
}