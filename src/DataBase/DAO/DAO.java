package DataBase.DAO;

import java.sql.Connection;

public abstract class DAO {

	protected Connection connection; 
	
	public DAO (Connection connection) {
		this.connection = connection;
	}
	
	public DAO() { }
	
	public void setConnection(Connection connection) { this.connection = connection; }
	
}
