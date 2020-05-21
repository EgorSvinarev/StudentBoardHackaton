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
		
		synchronized(pool) {
			pool.putConnection(connection);
			ctx.setAttribute("ConnectionPool", pool);
		}
		
		request.setAttribute("person", person);
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("StudentPage/index.jsp").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String town = request.getParameter("town");
		String group_id = request.getParameter("group_id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		person.setSurname(surname);
		person.setAge(age);
		person.setGender(gender);
		person.setTown(town);
		
		Student student = new Student();
		student.setId(id);
		student.setGroupId(group_id);
		
		pDao.updateEntryById(id, person);
		sDao.updateEntryById(id, student);
		
		synchronized(pool) {
			pool.putConnection(connection);
			ctx.setAttribute("ConnectionPool", pool);
		}
		
		response.sendRedirect("student?id=" + id);
	}

}
