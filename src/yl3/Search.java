package yl3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UnitDao;

public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		setSearchResults(request);
		request.getRequestDispatcher("jsp/Search.jsp").forward(request,
				response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String searchString = request.getParameter("searchString");
		response.sendRedirect("Search?searchString=" + searchString);
	}

	private void setSearchResults(HttpServletRequest request) {
		UnitDao unitDao = new UnitDao();
		System.out.println(unitDao.findAllUnits());
		String searchString = request.getParameter("searchString");

		if (searchString == null || searchString.equals("")) {
			request.setAttribute("searchResults", unitDao.findAllUnits());
		} else {
			request.setAttribute("searchResults", unitDao.search(searchString));
		}
	}
}
