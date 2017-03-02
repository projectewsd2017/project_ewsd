package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.fpt.ec.actions.Login;
import vn.fpt.ec.connection.DBConnection;

public class LoginDAO {

	public Login login(String name, String password) {
		Connection conn = DBConnection.open();
		String loginUser = "SELECT * FROM Users WHERE username=? AND password=?";
		Login l = new Login();
		try {
			PreparedStatement pstmt = conn.prepareStatement(loginUser);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			l.setUsername(rs.getString("username"));
			l.setRoleId(rs.getInt("roleId"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l;

	}
}
