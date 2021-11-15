package web.spa;

import java.io.IOException;

import bean.spa.SPA;
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

	//private static final long serialVersionUID = 1L;
	//private AccountDAO accountDAO;
	
public SPAServlet() {
this.spaDAO = new SPADAO();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
	SPA spa = new SPA();
	spa.setName(request.getParameter("spa_name"));
	spa.setPhone(request.getParameter("phone"));
	spa.setLicense(request.getParameter("license"));
	String email = request.getParameter("email");
	
	spa.setSeller(new AccountDAO().getUser(email));
	
	if(spaDAO.createSPA(spa)) {
		HttpSession session = request.getSession();
		session.setAttribute("spaErrMessage", "CreatedSuccessfully");
		response.sendRedirect("login.jsp");
		
	}
	else {
		HttpSession session = request.getSession();
		session.setAttribute("spaErrMessage", "Provide Complete Info");
		response.sendRedirect("spaInfor.jsp");
		
	}
}
}