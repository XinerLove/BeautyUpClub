package web.hompage;

import java.io.IOException;
import java.util.List;

import bean.spa.SPA;
import dao.spa.SPADAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet({"/index", "", "/"})
public class HomePageServlet extends HttpServlet implements Servlet {
	private SPADAO spaDao;
	
	public HomePageServlet() {
		this.spaDao = new SPADAO();
		System.out.print("HomePageServlet");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		System.out.print("HomePageServlet");
			List<SPA> allSpa =   this.spaDao.getAllSPA();
			request.setAttribute("allSpa", allSpa);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
		 

}