package yl2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener
{
	public static int sessionCount = 0;
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

