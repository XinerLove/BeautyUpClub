package web.spa;

import java.io.IOException;

import bean.account.Account;
import bean.role.Role;
import bean.spa.SPA;
import bean.userLogin.UserLogin;
import dao.account.AccountDAO;
import dao.spa.SPADAO;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/spaCreation")
public class SPAServlet extends HttpServlet implements Servlet{
	SPADAO spaDAO;
	AccountDAO accountDAO;

	//private static final long serialVersionUID = 1L;
	//private AccountDAO accountDAO;
	
public SPAServlet() {
this.spaDAO = new SPADAO();
this.accountDAO = new AccountDAO();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
	
	HttpSession session = request.getSession();
	
	SPA spa = new SPA();
	spa.setName(request.getParameter("spa_name"));
	spa.setPhone(request.getParameter("spa_phone"));
	spa.setLicense(request.getParameter("spa_licenece"));
	
	String email = session.getAttribute("email").toString();
	spa.setSeller(new AccountDAO().getUser(email));
	
	
	if(spaDAO.createSPA(spa, request.getParameter("street"), request.getParameter("city"), request.getParameter("state"), request.getParameter("country"), request.getParameter("zip_code") )) {
		
		session.setAttribute("spaErrMessage", "CreatedSuccessfully");
		response.sendRedirect("profile");
		
	}
	else {
		
		session.setAttribute("spaErrMessage", "Provide Complete Info");
		response.sendRedirect("spaInfor.jsp");
		
	}
}
}