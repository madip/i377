package yl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String sessionParameter = "param";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession();
		String sessId = sess.getId();
		
		response.getWriter().println("Hello! ");
		response.getWriter().println("Your session id is "+sessId);
		
		Object urlParam = request.getParameter(sessionParameter);
		sess.setAttribute(sessionParameter, urlParam);
		
		response.getWriter().println(" Session attribute is "+sessionParameter);
		
	}
}

