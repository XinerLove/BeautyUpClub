
package web.service;

import java.io.IOException;
import java.util.List;

import bean.services.Facial;
import bean.services.Laser;
import bean.services.Massage;
import bean.spa.SPA;
import dao.services.FacialServiceDAO;
import dao.services.LaserServiceDAO;
import dao.services.MassageServiceDAO;
import dao.services.ServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit-service")

public class EditServiceServlet extends HttpServlet implements Servlet {
	ServiceDAO service;
	MassageServiceDAO massage;
	FacialServiceDAO facial;
	LaserServiceDAO laser;
	public EditServiceServlet() {
//		System.out.print("FacialServices");
		service = new ServiceDAO();
		massage = new MassageServiceDAO();
		facial = new FacialServiceDAO();
		laser = new LaserServiceDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
			String id = request.getParameter("id");			
			String serviceName = request.getParameter("service");
			String type = request.getParameter("type");
			double price = Double.parseDouble(request.getParameter("price"));
		
			
			Boolean result = service.updateSingleService(id, serviceName, type, price);
			if(result) {
				response.sendRedirect("profile");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("serviceErrMessage", "Service Not Updated.");
			}
		

			
		}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			System.out.print("Edit Servlet");	
			System.out.print("Edit"+type);
			
			if(type.equals("massage")) {
				Massage service = massage.getSingleService(Integer.parseInt(id));
				request.setAttribute("id", id);
				request.setAttribute("name", "massage");
				request.setAttribute("type", service.getType());
				request.setAttribute("price", service.getPrice());
			}
			if(type.equals("laser")) {
				Laser service = laser.getSingleService(Integer.parseInt(id));
				request.setAttribute("id", id);
				request.setAttribute("name", "laser");
				request.setAttribute("type", service.getType());
				request.setAttribute("price", service.getPrice());
				
			}
			if(type.equals("facial")) {
				Facial service = facial.getSingleService(Integer.parseInt(id));
				request.setAttribute("id", id);
				request.setAttribute("name", "facial");
				request.setAttribute("type", service.getType());
				request.setAttribute("price", service.getPrice());
				
				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_services.jsp");
			dispatcher.forward(request, response);

			
		}
}

