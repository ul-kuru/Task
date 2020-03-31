package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
	//データベース接続情報
		private static final String JDBC_URL = "jdbc:mysql://localhost:3306/task?serverTimezone=JST";
		private static final String DB_USER = "root";
		private static final String DB_PASS = "Ulkuru3396yuuki";

	public static Connection createConnection()throws SQLException{
		return DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

	}

}
