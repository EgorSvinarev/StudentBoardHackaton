package DataBase.ConnectionPool;

import java.util.Stack;
import java.sql.Connection;
import DataBase.DataSource.DataSource;

public class ConnectionPool {

	private Stack<Connection> pool;
	private DataSource source;
	
	public ConnectionPool(int initialPoolSize, DataSource source) {
		this.source = source;
		this.pool = new Stack<>();
		
		this.createConnections(initialPoolSize);
	}
	
	private void createConnections(int size) {
		for (int i = 0; i < size; i++) {
			pool.push(this.source.getConnection());
		}
	}
	
	public void closeAllConnections() {
		for (int i = 0; i < this.pool.size(); i++) {
			try {
				this.pool.pop().close();
			}
			catch (Exception ex) {
				ex.fillInStackTrace();
				System.out.println(ex);
			}
		}	
	}
	
	public synchronized Connection getConnection() {
		if (this.pool.size() != 0 ) {
			return this.pool.pop();
		}
		else {
			this.createConnections(1);
			return this.pool.pop();
		}
	}
	
	public synchronized void putConnection(Connection connection) {
		this.pool.push(connection);
	}
}
