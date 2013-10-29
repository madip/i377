package yl3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Unit;
import db.Dao;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.getRequestDispatcher("jsp/Add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   addItem(request);
	   response.sendRedirect("Search");
	}

   private void addItem(HttpServletRequest request) {
	   Unit u = new Unit();
		u.setName(request.getParameter("name"));
		u.setCode(request.getParameter("code"));
		
		String suc = request.getParameter("superUnitCode");
		if (!suc.isEmpty())
		{
			Unit temp=new Dao().findByCode(suc);
			System.out.println(temp);
			u.setSuper_unit_id(temp.getId());
		}
		
		new Dao().save(u);
   }
}
