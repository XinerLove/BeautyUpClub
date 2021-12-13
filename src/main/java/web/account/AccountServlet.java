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

@WebServlet("/account")
public class AccountServlet extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;
	public AccountServlet() {
		accountDAO = new AccountDAO();
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		//username change to email
		
     String email = request.getParameter("email");
	 String password = request.getParameter("password");
	 
    //username change to email 
	
	if(accountDAO.emailExist(email))
	{
		HttpSession session = request.getSession();
		session.setAttribute("accErrMessage", "email already Exists");
		response.sendRedirect("Account.jsp");
		
}
	else {
		if(password.equals(request.getParameter("confirm_password")))
				{
			
					Account account =  new Account();
					account.setCity(" ");
					account.setCountry("USA");
					account.setEmail(email);
					account.setFname(request.getParameter("fname"));
					account.setLname(request.getParameter("lname"));
					
					account.setState(" ");
					account.setStreet(" ");
					
					//account.setUsername(username); change int to string for zip_code
					account.setZip_code("75001");
//					
					Role role = new Role();
					String[]str = request.getParameter("type").split(" ");
					role.setType(str[str.length-1]);
					//change username to email
					role.setEmail(email);
//					
					UserLogin login = new UserLogin();
					login.setEmail(email);
					login.setPassword(password);
					
			
					if(accountDAO.signUp(account, login, role))
					{	
						request.setAttribute("email", email);
						HttpSession session = request.getSession();
						session.setAttribute("email",email);
						session.setAttribute("accErrMessage", "");
						if(role.getType().equals("Spa"))
							response.sendRedirect("spaInfor.jsp");
						else
						response.sendRedirect("customer_details_form.jsp");
					}
					else
					{
						HttpSession session = request.getSession();
						session.setAttribute("accErrMessage", "Unable to create account. Incomplete info.");
						response.sendRedirect("Account.jsp");
					}
					
				}
				else
				{
					HttpSession session = request.getSession();
				session.setAttribute("accErrMessage", "Password and Confirm Password doesn't match.");
				response.sendRedirect("Account.jsp");
					
				}
		
	}
	}
}