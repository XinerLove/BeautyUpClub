package web.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.services.Facial;
import bean.services.Laser;
import bean.services.Massage;
import bean.services.Service;
import bean.spa.SPA;
import dao.services.ServiceDAO;
import dao.spa.SPADAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.google.gson.Gson; 
import com.google.gson.GsonBuilder; 
@WebServlet("/search-service")
public class SearchServlet extends HttpServlet implements Servlet{

	ServiceDAO serviceDAO;
	
	public SearchServlet()
	{
		System.out.print("Search_DONE");
		serviceDAO = new ServiceDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print(request.getParameter("search-input"));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String serviceName = request.getParameter("service");
		String type = request.getParameter("type");
		System.out.print(serviceName);	
	}
}