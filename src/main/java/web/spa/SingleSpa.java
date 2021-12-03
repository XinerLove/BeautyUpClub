
package web.spa;

import java.io.IOException;
import java.util.List;

import bean.account.Account;
import bean.services.Facial;
import bean.services.Laser;
import bean.services.Massage;
import bean.spa.SPA;
import dao.account.AccountDAO;
import dao.services.FacialServiceDAO;
import dao.services.LaserServiceDAO;
import dao.services.MassageServiceDAO;
import dao.spa.SPADAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/singleSpa")
public class SingleSpa extends HttpServlet implements Servlet{
	SPADAO spaDAO;
	AccountDAO account;
	MassageServiceDAO massageDAO;
	FacialServiceDAO facialDAO;
	LaserServiceDAO laserDAO;
	
public SingleSpa() {
	this.spaDAO = new SPADAO();
	this.account = new AccountDAO();
	this.massageDAO = new MassageServiceDAO();
	this.facialDAO = new FacialServiceDAO();
	this.laserDAO = new LaserServiceDAO();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
	   
	System.out.print(request.getParameter("id"));
	   SPA spa =  this.spaDAO.getSPAByID(Integer.parseInt(request.getParameter("id")));

	   
		request.setAttribute("name", spa.getName());
		Account seller  = spa.getSeller();
		request.setAttribute("spa_id", request.getParameter("id"));
		request.setAttribute("email", seller.getEmail());
		request.setAttribute("phone", spa.getPhone());
		request.setAttribute("license", spa.getLicense());
		
		Account account  = this.account.getUser(seller.getEmail());
		request.setAttribute("city", account.getCity());
		request.setAttribute("state", account.getState());
		request.setAttribute("street", account.getStreet());
		request.setAttribute("zipcode", account.getZip_code());
		request.setAttribute("country", account.getCountry());
		
		List<Massage> massageServices =  this.massageDAO.getAllSPAServices(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("massageServices", massageServices);
		
		List<Facial> facialServices = facialDAO.getAllSPAServices(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("facialServices", facialServices);
		
		List<Laser> laserService = laserDAO.getAllSPAServices(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("laserServices", laserService);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("store_details.jsp");
		dispatcher.forward(request, response);
		
	}
}