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
	private static int sessionCount;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sessionCount++;
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sessionCount--;
	}

	public static int getActiveSessions() {
		return sessionCount;
	}
}

