package yl2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener
{
	private static int totalActiveSessions = 0;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		if (totalActiveSessions > 0){
			totalActiveSessions--;	
		}
	}
	
	public static int getActiveSessions() {
		return totalActiveSessions;
	}	


}

