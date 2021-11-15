package web.login;


import java.io.IOException;
import java.sql.ResultSet;

import bean.userLogin.UserLogin;
import dao.Login.LoginDAO;
import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;



	/**
	 * Servlet implementation class LoginServlet
	 */
	@WebServlet("/login")
	public class LoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       private LoginDAO loginDAO;
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public LoginServlet() {
	    	loginDAO =new LoginDAO();
	       
	    }
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// change username to email
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		 
		 
		 UserLogin login = new UserLogin(email, password);
		 boolean isloggedin=loginDAO.login(login);
		 if(isloggedin)
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("email", email);
			 session.setAttribute("password", password);
			 
			 String role = loginDAO.checkUserType(email);
			 if(role == "customer") {
				 System.out.println("CUSTOMER");
				 session.setAttribute("auth", "pass");
				 response.sendRedirect("customer-profile");
			 }else if(role == "spaOwner") {
				 session.setAttribute("auth", "pass");
				 response.sendRedirect("profile");
			 }else {
				 
			 }
			
			 
		 }
		 else {
			 HttpSession session = request.getSession();
			 session.setAttribute("errorMessage", " invalid email and Password");
			 response.sendRedirect("login.jsp");
		 }
		}

	}

