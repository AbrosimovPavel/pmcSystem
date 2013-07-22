package com.epam.training.model.domain.database.connection;

import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;
import org.h2.jdbcx.JdbcConnectionPool;

public final class DBConnectionPool {
	private LinkedBlockingQueue<Connection> connectionList;
	private Integer capacity = 0;

	public DBConnectionPool() {
		JdbcConnectionPool cp = JdbcConnectionPool.create("jdbc:h2:d://Documentation//work//Epam//WS//pmcSystemTask//db//pmcDatabase", "sa", "");
		cp.setLoginTimeout(600000);
		capacity = cp.getMaxConnections();
		connectionList = new LinkedBlockingQueue<Connection>();
		try {
			for (int i = 0; i < capacity ;i++) {
				connectionList.put(cp.getConnection());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//cp.dispose();
	}

	public Connection getConnection(){
		if (connectionList.isEmpty()){
			return null;
		}
		return connectionList.poll();
	}
	
	public void returnConnection(Connection connection) {
		if (connectionList.size() < capacity) {
			try {
				connectionList.put(connection);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
