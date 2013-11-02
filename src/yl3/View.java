package yl3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Unit;
import dao.UnitDao;

public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listLowerUnit", new UnitDao().findAllUnits());
		Unit temp = new UnitDao().findById(Long.parseLong(request.getParameter("id")));

		if (temp.getSuper_unit_id() != null){
		request.setAttribute("superUnit",new UnitDao().findById(temp.getSuper_unit_id()));
		request.setAttribute("unitName", temp.getName());
		request.setAttribute("unitCode", temp.getCode());
		request.setAttribute("subUnit",new UnitDao().findChildUnits(temp.getId()));
		request.getRequestDispatcher("jsp/View.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Search");
	}

}
