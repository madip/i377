package yl3;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.Dao;


public class Delete extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      deleteItems(request);
      response.sendRedirect("Search");
   }

   private void deleteItems(HttpServletRequest request) {
	   Dao unitDao = new Dao();
		if (request.getParameter("id").equalsIgnoreCase("All")) {
			unitDao.delete();
		} else {
			Long id = Long.parseLong(request.getParameter("id"));
			unitDao.delete(id);
		}
   }
}
