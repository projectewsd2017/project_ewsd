package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.ClaimType;
import vn.fpt.ec.actions.Faculties;
import vn.fpt.ec.connection.DBConnection;

public class FacultyDAO {
	public List<Faculties> select() {
		Connection conn = null;
		Statement stmt = null;
		List<Faculties> list = new ArrayList<Faculties>();
		Faculties faculties = null;
		ResultSet rs = null;
		String selectString = "SELECT id,facutlyName FROM Faculties";

		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				faculties = new Faculties();
				faculties.setId(rs.getInt("id"));
				faculties.setFacutlyName((rs.getString("facutlyName")));
				

				list.add(faculties);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, stmt, rs);
		}
		return list;
	}
	
	
	public Faculties findById(int id) {
		Connection conn = null;
		String findByIdString = "Select * From Faculties Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Faculties faculties = new Faculties();
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			faculties.setId(rs.getInt("id"));
			faculties.setFacutlyName(rs.getString("facutlyName"));
			

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return faculties;

	}
}
