package Servlets.ServletCtxListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import DataBase.ConnectionPool.ConnectionPool;
import DataBase.DataSource.*;

/**
 * Application Lifecycle Listener implementation class ServletCtxListener
 *
 */

public class ServletCtxListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletCtxListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    /**
     *
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        ServletContext ctx = sce.getServletContext();
        ConnectionPool pool = (ConnectionPool) ctx.getAttribute("ConnectionPool");
        pool.closeAllConnections();
        ctx.setAttribute("ConnectionPool", pool);
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext ctx = sce.getServletContext();
    	
        String dbURL = ctx.getInitParameter("DataBaseURL");
        String dbUser = ctx.getInitParameter("DataBaseUser");
        String dbPassword = ctx.getInitParameter("DataBasePassword");
        
        DataSource source = new SQLSource(dbURL, dbUser, dbPassword);
        ConnectionPool pool = new ConnectionPool(10, source);
        
        ctx.setAttribute("ConnectionPool", pool);
    }
	
}
