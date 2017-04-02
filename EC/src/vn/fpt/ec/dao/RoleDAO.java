package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.Roles;
import vn.fpt.ec.connection.DBConnection;

public class RoleDAO {
	
	public List<Roles> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		List<Roles> list = new ArrayList<Roles>();
		Roles role = null;
		ResultSet rs = null;
		String selectString = "SELECT id,roleName FROM Roles";

		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				role = new Roles();
				role.setId(rs.getInt("id"));
				role.setRoleName((rs.getString("roleName")));
				

				list.add(role);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, stmt, rs);
		}
		return list;
	}
	
	public Roles findById(int id) {
		Connection conn = null;
		String findByIdString = "Select * From Roles Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Roles role = new Roles();
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			role.setId(rs.getInt("id"));
			role.setRoleName(rs.getString("roleName"));
			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;

	}
}
