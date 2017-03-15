package vn.fpt.ec.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.Claims;
import vn.fpt.ec.actions.ECCoordinator;
import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class ClaimsDAO {

	public List<Claims> getAllClaims() {
		Connection conn = DBConnection.open();
		List<Claims> list = new ArrayList<Claims>();
		Claims claims = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectString = "SELECT C.id as claimId,C.title,C._content,C.status,C.createDate,C.dueDate,C.ecCoordinatorID,C.pathEvidence, "
				+ "S.id as sId,S.studentName,S.email,S.address,S.facultyID,"
				+ "EC.id as ecId,EC.ecCoordinatorName,EC.email as ecMail "
				+ "FROM Claims C INNER JOIN Students S ON C.studentID = S.id "
				+ "INNER JOIN ECCoordinator EC ON C.ecCoordinatorID = EC.id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Students students = new Students();
				students.setId(rs.getInt("sId"));
				students.setStudentName(rs.getString("studentName"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setFacultyId(rs.getInt("facultyID"));
				ECCoordinator coordinator = new ECCoordinator();
				coordinator.setId(rs.getInt("ecId"));
				coordinator.setEcCoordinatorName(rs
						.getString("ecCoordinatorName"));
				claims = new Claims();
				claims.setId(rs.getInt("claimId"));
				claims.setContent(rs.getString("_content"));
				claims.setTitle(rs.getString("title"));
				claims.setStudentId(rs.getInt(students.getId()));
				claims.setFacultyId(rs.getInt(students.getFacultyId()));
				claims.setEcCoordinatorID(rs.getInt("ecCoordinatorID"));
				claims.setStatus(rs.getBoolean("status"));
				claims.setCreateDate(rs.getDate("createDate"));
				claims.setDueDate(rs.getDate("dueDate"));
				claims.setStudent(students);
				claims.setPathEvidenceFileName(rs.getString("pathEvidence"));
				claims.setCoordinator(coordinator);
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
		String insertString = "INSERT INTO Claims(studentID,title,_content,ecCoordinatorID,status,createDate,dueDate,pathEvidence) "
				+ "values (?,?,?,?,?,?,?,?) ";
		int len;

		try {
			// File file = new File(c.getFilename());
			// FileInputStream fis = new FileInputStream(file);
			// len = (int)file.length();

			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setInt(4, 1);
			pstmt.setBoolean(5, c.isStatus());
			pstmt.setDate(6, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(7, new Date(c.getDueDate().getTime()));
			pstmt.setString(8, c.getPathEvidenceFileName());

			// pstmt.setBinaryStream(7, fis, len);

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
		String insertString = "UPDATE Claims set studentID =?,title = ?,_content =?,pathEvidence = ?,status =?,"
				+ "createDate = ?,dueDate = ? WHERE id =?";

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setString(4, c.getPathEvidenceFileName());
			pstmt.setBoolean(5, c.isStatus());
			pstmt.setDate(6, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(7, new Date(c.getDueDate().getTime()));
			pstmt.setInt(8, c.getId());

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
	
	public Claims findById(int id){
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
			claim.setPathEvidenceFileName(rs.getString("pathEvidence"));
			claim.setCreateDate(rs.getDate("createDate"));
			claim.setDueDate(rs.getDate("dueDate"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claim;
		
	}
}
