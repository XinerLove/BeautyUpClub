
package web.service;

import java.io.IOException;
import java.util.List;

import bean.services.Laser;
import bean.services.Massage;
import bean.spa.SPA;
import dao.services.MassageServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/massage-services")

public class MassageServiceServelt extends HttpServlet implements Servlet {
	MassageServiceDAO dao;
	public MassageServiceServelt() {
		this.dao = new MassageServiceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		List<Massage> allServices =   this.dao.getAllServices();
		request.setAttribute("allServices", allServices);
			RequestDispatcher dispatcher = request.getRequestDispatcher("massage_services.jsp");
			dispatcher.forward(request, response);
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		List<Massage> allServices =   this.dao.getAllServices();
		request.setAttribute("allServices", allServices);
			RequestDispatcher dispatcher = request.getRequestDispatcher("massage_services.jsp");
			dispatcher.forward(request, response);
			
			
		}
	
	
}

