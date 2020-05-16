package DataBase.DataSource;

import java.sql.*;
import DataBase.DataSource.DataSource;

public class SQLSource extends DataSource {

	public SQLSource(String url, String user, String password) {
		super(url, user, password);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection connection = DriverManager.getConnection(this.url, this.user, this.password);
			return connection;
		}
		catch (Exception ex) {
			ex.fillInStackTrace();
			System.out.println(ex);
		}
		return null;
	}

}
