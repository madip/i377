package yl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer count = (Integer) request.getSession().getAttribute("count");
		
		if(count == null){
			count = 0;
		}
		count++;
		
		request.getSession().setAttribute("count", count);
		response.getWriter().println("count is " + count);
	}

}
