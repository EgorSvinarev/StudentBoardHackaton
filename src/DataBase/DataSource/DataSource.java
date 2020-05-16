package DataBase.DataSource;

import java.sql.DriverManager;

import java.sql.*;

public abstract class DataSource {
	
	protected String url;
	protected String user;
	protected String password;
	
	public DataSource(String url, String user, String password) {
		this.url = url;
		this.user = user;
		this.password = password;
	}
	
	public abstract Connection getConnection();
		
	
}
