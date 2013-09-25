package yl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idee = request.getSession().getId();
		String par = request.getParameter("param"); 
		
		request.getSession().setAttribute("Id", idee);
		
		response.getWriter().println("Hello! Your session id is " +	idee
				+ "Session attribute is " + par);
		
	}

}
