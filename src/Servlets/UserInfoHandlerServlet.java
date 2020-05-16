package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import DataBase.ConnectionPool.*;
import DataBase.DAO.PersonDAO;
import DataBase.DAO.StudentDAO;
import DataBase.TableModel.*;

/**
 * Servlet implementation class UserInfoHandlerServlet
 */

public class UserInfoHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoHandlerServlet() {
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
		
		int primaryKey = Integer.parseInt(request.getParameter("id"));
		
		Person person = pDao.getEntryByPrimaryKey(primaryKey);
		Student student = sDao.getEntryByPrimaryKey(primaryKey);
		
		request.setAttribute("person", person);
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("StudentPage/index.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
