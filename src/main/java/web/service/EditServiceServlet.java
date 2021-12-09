
package web.service;

import java.io.IOException;
import java.util.List;

import bean.services.Facial;
import bean.services.Massage;
import bean.spa.SPA;
import dao.services.FacialServiceDAO;
import dao.services.LaserServiceDAO;
import dao.services.MassageServiceDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit-service")

public class EditServiceServlet extends HttpServlet implements Servlet {
	
	MassageServiceDAO massage;
	FacialServiceDAO facial;
	LaserServiceDAO laser;
	public EditServiceServlet() {
//		System.out.print("FacialServices");
		massage = new MassageServiceDAO();
		facial = new FacialServiceDAO();
		laser = new LaserServiceDAO();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
			String id = request.getParameter("id");
			String type = request.getParameter("type");
			if(type =="massage")
			{
				Massage service = massage.getSingleService(Integer.parseInt(id));
				System.out.print("Edit"+service.getPrice());
			}else if(type =="facial") {
				
			}else if(type=="laser") {
				
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_services.jsp");
			dispatcher.forward(request, response);

//			System.out.println("Path: "+dispatcher.toString());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("facial_services.jsp");
//			System.out.print("FacialServicesPOST");
//			dispatcher.forward(request, response);
			
		}
}

