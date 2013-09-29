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
		HttpSession sess = request.getSession();
		String id = sess.getId();

		Object attr = request.getParameter("param");
		sess.setAttribute("param", attr);
		String sessAttr = (String) sess.getAttribute("param");

		response.getWriter().println("Hello");
		response.getWriter().println("Session ID: " + id);
		response.getWriter().println("Session attribute is " + sessAttr);
	}

}
