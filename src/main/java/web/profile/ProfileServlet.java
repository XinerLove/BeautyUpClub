package web.profile;

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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet implements Servlet{
	SPADAO spaDAO;
	MassageServiceDAO massageDAO;
	FacialServiceDAO facialDAO;
	LaserServiceDAO laserDAO;
	AccountDAO accountDAO;
	public ProfileServlet() {
		System.out.print("PROFILE");
		this.spaDAO = new SPADAO();
		this.facialDAO = new FacialServiceDAO();
		this.massageDAO = new MassageServiceDAO();
		this.laserDAO = new LaserServiceDAO();
		this.accountDAO = new AccountDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 session.getAttribute("email");
		 int  id = this.accountDAO.getUserId(session.getAttribute("email").toString()); 
		
		 SPA spa =   this.spaDAO.getSPA(session.getAttribute("email").toString());
		   
			request.setAttribute("name", spa.getName());
			Account seller  = spa.getSeller();
			System.out.print(spa.getId());
			request.setAttribute("spa_id", spa.getId());
			request.setAttribute("email", seller.getEmail());
			request.setAttribute("phone", spa.getPhone());
			request.setAttribute("license", spa.getLicense());
			
			List<Massage> massageServices = massageDAO.getAllSPAServices(id);
			request.setAttribute("massageServices", massageServices);
			
			List<Facial> facialServices = facialDAO.getAllSPAServices(id);
			
			request.setAttribute("facialServices", facialServices);
			
			List<Laser> laserService = laserDAO.getAllSPAServices(id);
			request.setAttribute("laserService", laserService);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
			
		}
	
}