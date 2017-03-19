package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.ClaimType;
import vn.fpt.ec.connection.DBConnection;

public class ClaimTypeDAO {

	public void insert(ClaimType c) {
		Connection conn = DBConnection.open();
		PreparedStatement pstmt = null;
		String insertString = "INSERT INTO ClaimType(ClaimName,Description) values(?,?)";

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setString(1, c.getClaimName());
			pstmt.setString(2, c.getDescription());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public void update(ClaimType c) {
		Connection conn = DBConnection.open();
		PreparedStatement pstmt = null;
		String updateString = "UPDATE ClaimType SET ClaimName = ?, Description = ? WHERE id = ?";

		try {
			pstmt = conn.prepareStatement(updateString);
			pstmt.setString(1, c.getClaimName());
			pstmt.setString(2, c.getDescription());
			pstmt.setInt(3, c.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public List<ClaimType> select() {
		Connection conn = DBConnection.open();
		Statement stmt = null;
		List<ClaimType> list = new ArrayList<ClaimType>();
		ClaimType claimType = null;
		ResultSet rs = null;
		String selectString = "SELECT id,ClaimName,Description FROM ClaimType";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				claimType = new ClaimType();
				claimType.setId(rs.getInt("id"));
				claimType.setClaimName(rs.getString("ClaimName"));
				claimType.setDescription(rs.getString("Description"));

				list.add(claimType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, stmt, rs);
		}
		return list;
	}

	public void delete(int id) {
		Connection conn = DBConnection.open();
		String deleteString = "DELETE FROM ClaimType WHERE id = ? ";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(deleteString);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public ClaimType findById(int id) {
		Connection conn = DBConnection.open();
		String findByIdString = "Select * From ClaimType Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClaimType claimType = new ClaimType();
		try {
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			claimType.setId(rs.getInt("id"));
			claimType.setClaimName(rs.getString("ClaimName"));
			claimType.setDescription(rs.getString("Description"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claimType;

	}

}
