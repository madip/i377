package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import db.SetupDao;

public class ServletContextInitializer implements ServletContextListener{

   @Override
   public void contextInitialized(ServletContextEvent arg0) {
	   SetupDao setupDao = new SetupDao();
       setupDao.createSchema();
       setupDao.addTestData();
   }

   @Override
   public void contextDestroyed(ServletContextEvent arg0) {      
   }

}
