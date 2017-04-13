package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.Academics;
import vn.fpt.ec.actions.ClaimType;
import vn.fpt.ec.connection.DBConnection;

public class AcademicDAO {
	public List<Academics> select() {
		Connection conn = null;
		Statement stmt = null;
		List<Academics> list = new ArrayList<Academics>();
		Academics academic = null;
		ResultSet rs = null;
		String selectString = "SELECT id,openDate,closureDate,name FROM Academics";

		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				academic = new Academics();
				academic.setId(rs.getInt("id"));
				academic.setOpenDate((rs.getDate("openDate")));
				academic.setClosureDate((rs.getDate("closureDate")));
				academic.setName(rs.getString("name"));
				list.add(academic);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, stmt, rs);
		}
		return list;
	}

	public void insert(Academics a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String insertString = "INSERT INTO Academics(openDate,closureDate,name) values(?,?,?)";

		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(insertString);
			pstmt.setDate(1, new Date(a.getOpenDate().getTime()));
			pstmt.setDate(2, new Date(a.getClosureDate().getTime()));
			pstmt.setString(3, a.getName());

			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public void update(Academics a) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String updateString = "UPDATE Academics SET openDate = ?, closureDate = ?,name = ? WHERE id = ?";

		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(updateString);
			pstmt.setDate(1, new Date(a.getOpenDate().getTime()));
			pstmt.setDate(2, new Date(a.getClosureDate().getTime()));
			pstmt.setString(3, a.getName());
			pstmt.setInt(4, a.getId());

			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public void delete(int id) {
		Connection conn = null;
		String deleteString = "DELETE FROM Academics WHERE id = ? ";
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(deleteString);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public Academics findById(int id) {
		Connection conn = null;
		String findByIdString = "Select * From Academics Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Academics academics = new Academics();
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				academics.setId(rs.getInt("id"));
				academics.setName(rs.getString("name"));
				academics.setOpenDate(rs.getDate("openDate"));
				academics.setClosureDate(rs.getDate("closureDate"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return academics;

	}
}
