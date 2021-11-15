package web.profile;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet implements Servlet{

	public ProfileServlet() {
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
			
		}
	
}