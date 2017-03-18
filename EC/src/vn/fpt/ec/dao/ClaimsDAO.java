package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.Claims;
import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class ClaimsDAO {

	public List<Claims> getAllClaims() {
		Connection conn = DBConnection.open();
		List<Claims> list = new ArrayList<Claims>();
		Claims claims = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectString = "SELECT C.id as claimId,C.title,C._content,C.status,C.createdDate,C.dueDate,C.ecCoordinatorID,C.pathEvidence1,C.pathEvidence2,C.pathEvidence3, "
				+ "S.id as sId,S.studentName,S.email,S.address,S.facultyID "
				+ "FROM Claims C INNER JOIN Students S ON C.studentID = S.id ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Students students = new Students();
				students.setId(rs.getInt("sId"));
				students.setFirstName(rs.getString("firstName"));
				students.setLastName(rs.getString("lastName"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setFacultyId(rs.getInt("facultyID"));
			
				claims = new Claims();
				claims.setId(rs.getInt("claimId"));
				claims.setContent(rs.getString("_content"));
				claims.setTitle(rs.getString("title"));
				claims.setStudentId(rs.getInt(students.getId()));
				claims.setFacultyId(rs.getInt(students.getFacultyId()));
				claims.setEcCoordinatorID(rs.getInt("ecCoordinatorID"));
				claims.setStatus(rs.getString("status"));
				claims.setCreateDate(rs.getDate("createDate"));
				claims.setDueDate(rs.getDate("dueDate"));
				claims.setStudent(students);
				claims.setPathEvidenceFileName1(rs.getString("pathEvidence1"));
				claims.setPathEvidenceFileName2(rs.getString("pathEvidence2"));
				claims.setPathEvidenceFileName3(rs.getString("pathEvidence3"));
				
				list.add(claims);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, stmt, rs);
		}
		return list;

	}

	public void insert(Claims c) {
		Connection conn = DBConnection.open();
		PreparedStatement pstmt = null;
		String insertString = "INSERT INTO Claims(studentID,title,_content,ecCoordinatorID,status,createDate,dueDate,pathEvidence1,pathEvidence2,pathEvidence3) "
				+ "values (?,?,?,?,?,?,?,?,?,?) ";

		try {

			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setInt(4, 1);
			pstmt.setString(5, c.getStatus());
			pstmt.setDate(6, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(7, new Date(c.getDueDate().getTime()));
			pstmt.setString(8, c.getPathEvidenceFileName1());
			pstmt.setString(9, c.getPathEvidenceFileName2());
			pstmt.setString(10, c.getPathEvidenceFileName3());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
	}

	public void update(Claims c) {
		Connection conn = DBConnection.open();
		PreparedStatement pstmt = null;
		String insertString = "UPDATE Claims set studentID =?,title = ?,_content =?,pathEvidence1 = ?,pathEvidence2 = ?,pathEvidence3 = ?,status =?,"
				+ "createDate = ?,dueDate = ? WHERE id =?";

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setString(4, c.getPathEvidenceFileName1());
			pstmt.setString(5, c.getPathEvidenceFileName1());
			pstmt.setString(6, c.getPathEvidenceFileName1());
			pstmt.setString(7, c.getStatus());
			pstmt.setDate(8, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(9, new Date(c.getDueDate().getTime()));
			pstmt.setInt(10, c.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
	}

	public void delete(int id) {
		Connection conn = DBConnection.open();
		String deleteString = "DELETE FROM Claims WHERE id = ? ";
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

	public Claims findById(int id) {
		Connection conn = DBConnection.open();
		String findByIdString = "Select * From Claims Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Claims claim = new Claims();
		try {
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			claim.setId(rs.getInt("id"));
			claim.setStudentId(rs.getInt("studentID"));
			claim.setTitle(rs.getString("title"));
			claim.setContent(rs.getString("_content"));
			claim.setPathEvidenceFileName1(rs.getString("pathEvidence1"));
			claim.setPathEvidenceFileName2(rs.getString("pathEvidence2"));
			claim.setPathEvidenceFileName3(rs.getString("pathEvidence3"));
			claim.setCreateDate(rs.getDate("createDate"));
			claim.setDueDate(rs.getDate("dueDate"));
			claim.setStatus(rs.getString("status"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claim;

	}
}
