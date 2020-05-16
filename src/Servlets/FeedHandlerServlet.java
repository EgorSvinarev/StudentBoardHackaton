package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import DataBase.ConnectionPool.ConnectionPool;
import DataBase.DAO.PersonDAO;
import DataBase.DAO.StudentDAO;
import DataBase.TableModel.*;
import java.util.ArrayList;

/**
 * Servlet implementation class FeedHandlerServlet
 */

public class FeedHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx = getServletContext();
		ConnectionPool pool = (ConnectionPool) ctx.getAttribute("ConnectionPool");
		Connection connection = null;
		
		synchronized(pool) {
			connection = pool.getConnection();
			ctx.setAttribute("ConnectionPool", pool);
		}
		
		PersonDAO pDao = new PersonDAO(connection);
		StudentDAO sDao = new StudentDAO(connection);
		
		Person[] persons= pDao.getAllEntries();
		
		int[] personsId = new int[persons.length];
		for (int i = 0; i < personsId.length; i++) {
			personsId[i] = persons[i].getId();
		}
		
		Student[] students = sDao.getEntriesByArrayOfPrimaryKeys(personsId);
		
		synchronized(pool) {
			pool.putConnection(connection);
			ctx.setAttribute("ConnectionPool", pool);
		}
		
		request.setAttribute("persons", persons);
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
