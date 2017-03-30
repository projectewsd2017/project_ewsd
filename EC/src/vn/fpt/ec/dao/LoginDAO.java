package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.fpt.ec.actions.Login;
import vn.fpt.ec.connection.DBConnection;

public class LoginDAO {

	public Login loginStudent(String name, String password) {
		Connection conn = DBConnection.open();
		String loginUser = "SELECT * FROM Students WHERE username=? AND password=?";
		Login l = new Login();
		try {
			PreparedStatement pstmt = conn.prepareStatement(loginUser);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				l.setId(rs.getInt("id"));
				l.setUsername(rs.getString("username"));
				l.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l;

	}

	public Login loginStaff(String name, String password) {
		Connection conn = DBConnection.open();

		String loginUser = "SELECT * FROM Staffs WHERE username=? AND password=?";
		Login l = new Login();
		try {
			PreparedStatement pstmt = conn.prepareStatement(loginUser);

			pstmt.setString(1, name);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				l.setId(rs.getInt("id"));
				l.setUsername(rs.getString("username"));
				l.setRoleId(rs.getInt("roleID"));
				l.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return l;

	}
}
