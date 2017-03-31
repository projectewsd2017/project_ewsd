package vn.fpt.ec.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static Connection open() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;Database=ProjectEWSD;user=sa;password=123456;");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getMySQLConnection()
			throws ClassNotFoundException, SQLException {
		String hostName = "localhost";
		String dbName = "ProjectEWSD";
		String userName = "root";
		String password = "123456";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName,
			String userName, String password) throws SQLException,
			ClassNotFoundException {
		// Khai báo class Driver cho DB MySQL
		// Việc này cần thiết với Java 5
		// Java6 trở lên tự động tìm kiếm Driver thích hợp.
		// Nếu bạn dùng Java > 5, thì ko cần dòng này cũng được.
		Class.forName("com.mysql.jdbc.Driver");

		// Cấu trúc URL Connection dành cho MySQL
		// Ví dụ: jdbc:mysql://localhost:3306/simplehr
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

		Connection conn = DriverManager.getConnection(connectionURL, userName,
				password);
		return conn;
	}

}
