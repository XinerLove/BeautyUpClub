
package web.account;

import java.io.IOException;

import bean.account.Account;
import bean.role.Role;
import bean.userLogin.UserLogin;
import dao.account.AccountDAO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/account-details")
public class AccountDetailsServlet extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;
	public AccountDetailsServlet() {
		accountDAO = new AccountDAO();
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		//username change to email
		HttpSession session = request.getSession();
		if(accountDAO.addAccountDetails(session.getAttribute("email").toString(), request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("country"), request.getParameter("zip_code"))) {
			response.sendRedirect("login.jsp");
		}else {
			session.setAttribute("accErrMessage", "Information Mismatched.");
		}
	
	
	
	}
}