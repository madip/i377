package yl3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Unit;
import dao.UnitDao;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		UnitDao unitDao = new UnitDao();
		request.setAttribute("listLowerUnit", unitDao.findAllUnits());
		request.getRequestDispatcher("jsp/Add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		addItem(request);
		response.sendRedirect("Search");
	}

	private void addItem(HttpServletRequest request) {
		Unit unit = new Unit();
		unit.setName(request.getParameter("name"));
		unit.setCode(request.getParameter("code"));

		String success = request.getParameter("superUnitCode");
		if (!success.isEmpty()) {
			Unit newUnit = new UnitDao().findByCode(success);
			System.out.println(newUnit);
			unit.setSuper_unit_id(newUnit.getId());
		}

		new UnitDao().save(unit);
	}
}
