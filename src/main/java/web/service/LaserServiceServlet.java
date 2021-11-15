
package web.service;

import java.io.IOException;
import java.util.List;

import bean.services.Facial;
import bean.services.Laser;
import bean.spa.SPA;
import dao.services.LaserServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/laser-services")

public class LaserServiceServlet extends HttpServlet implements Servlet {
	LaserServiceDAO dao;
	public LaserServiceServlet() {
		this.dao = new LaserServiceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		List<Laser> allServices =   this.dao.getAllServices();
		request.setAttribute("allServices", allServices);
			RequestDispatcher dispatcher = request.getRequestDispatcher("laser_services.jsp");
			dispatcher.forward(request, response);
			
		}
}
