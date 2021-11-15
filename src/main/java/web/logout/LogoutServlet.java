package web.logout;

import java.io.IOException;

import dao.logout.LogoutDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/gologout")
public class LogoutServlet extends HttpServlet {

	LogoutDAO logout;
	public LogoutServlet() {
		
		this.logout = new LogoutDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		System.out.println("LogoutServlet");
		    HttpSession session = request.getSession();
//		    boolean logoutBehavior = this.logout.logout(session.getAttribute("email").toString(), session.getAttribute("password").toString());
		    
		    	session.removeAttribute("auth");
			    session.removeAttribute("email");
			    session.removeAttribute("password");
			    response.sendRedirect("");
		    
		    
		   
		}
}