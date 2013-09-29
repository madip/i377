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
	private static int countOfSessions = 0;	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		countOfSessions++;		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		countOfSessions--;		
	}	
	public static int getSessionsCount(){
		return countOfSessions;
	}

}

