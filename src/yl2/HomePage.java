package yl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello!");		
		HttpSession sess = request.getSession();
		String name = request.getParameter("param");
		if(name != null){
			sess.setAttribute("param", name);
		}
		
		response.getWriter().println("Your session id is " + sess.getId());
		response.getWriter().println("Session attribute is " + sess.getAttribute("param"));

	}
}
