package web.service;

import java.io.IOException;
import java.util.List;

import bean.services.Facial;
import bean.spa.SPA;
import dao.services.FacialServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/facial-services")

public class FacialServiceServlet extends HttpServlet implements Servlet {
	
	FacialServiceDAO dao;
	public FacialServiceServlet() {
		dao = new FacialServiceDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
			List<Facial> allServices =   this.dao.getAllServices();
		
			request.setAttribute("allServices", allServices);
			RequestDispatcher dispatcher = request.getRequestDispatcher("facial_services.jsp");
			dispatcher.forward(request, response);
			
		}
}
