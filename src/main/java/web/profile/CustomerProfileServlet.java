package web.profile;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/customer-profile")
public class CustomerProfileServlet extends HttpServlet implements Servlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_profile.jsp");
			dispatcher.forward(request, response);
			
		}
}
