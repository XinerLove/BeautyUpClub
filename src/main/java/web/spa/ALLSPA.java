package web.spa;

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

@WebServlet("/spas")
public class ALLSPA extends HttpServlet implements Servlet{
	SPADAO spaDAO;

	//private static final long serialVersionUID = 1L;
	//private AccountDAO accountDAO;
	
public ALLSPA() {
	System.out.println("ALLSPA");
this.spaDAO = new SPADAO();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
		List<SPA> allSpa =   this.spaDAO.getAllSPA();
		request.setAttribute("allSpa", allSpa);
		RequestDispatcher dispatcher = request.getRequestDispatcher("stores.jsp");
		dispatcher.forward(request, response);
		
	}
}