package web.profile;

import java.io.IOException;

import bean.account.Account;
import dao.account.AccountDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customer-profile")
public class CustomerProfileServlet extends HttpServlet implements Servlet {

	AccountDAO accountDao;
	public CustomerProfileServlet () {
		this.accountDao = new AccountDAO();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		HttpSession session = request.getSession();
		 session.getAttribute("email");
		 Account account = this.accountDao.getUser(session.getAttribute("email").toString());
		    request.setAttribute("fname", account.getFname());
		    request.setAttribute("lname", account.getLname());
		    request.setAttribute("email", account.getEmail());
		    request.setAttribute("city", account.getCity());
		    request.setAttribute("state", account.getState());
		    request.setAttribute("street", account.getStreet());
		    request.setAttribute("country", account.getCountry());
		    request.setAttribute("zipCode", account.getZip_code());
		   
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer_profile.jsp");
			dispatcher.forward(request, response);
	}
}