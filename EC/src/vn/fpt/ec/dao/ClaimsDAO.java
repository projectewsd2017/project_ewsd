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
		String selectString = "SELECT C.id as claimId,C.status,C.createDate,C.dueDate,C.ecCoordinatorID,C.file1, "
				+ "S.id as sId,S.studentID,S.studentName,S.email,S.address,S.facultyID,"
				+ "EC.id as ecId,EC.ecCoordinatorName,EC.email as ecMail "
				+ "FROM Claims C INNER JOIN Students S ON C.studentID = S.id "
				+ "INNER JOIN ECCoordinator EC ON C.ecCoordinatorID = EC.id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Students students = new Students();
				students.setId(rs.getInt("sId"));
				students.setStudentID(rs.getInt("studentID"));
				students.setStudentName(rs.getString("studentName"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setFacultyId(rs.getInt("facultyID"));
				ECCoordinator coordinator = new ECCoordinator();
				coordinator.setId(rs.getInt("ecId"));
				coordinator.setEcCoordinatorName(rs.getString("ecCoordinatorName"));
				claims = new Claims();
				claims.setId(rs.getInt("claimId"));
				claims.setStudentId(rs.getInt(students.getStudentID()));
				claims.setFacultyId(rs.getInt(students.getFacultyId()));
				claims.setEcCoordinatorID(rs.getInt("ecCoordinatorID"));
				claims.setStatus(rs.getBoolean("status"));
				claims.setCreateDate(rs.getDate("createDate"));
				claims.setDueDate(rs.getDate("dueDate"));
				claims.setStudent(students);
				claims.setUserImageFileName(rs.getString("file1"));
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
		String insertString = "INSERT INTO Claims(studentID,facultyID,ecCoordinatorID,status,createDate,dueDate,file1) "
				+ "values (?,?,?,?,?,?,?) ";
		 int len;

		try {
//			File file = new File(c.getFilename());
//            FileInputStream fis = new FileInputStream(file);
//            len = (int)file.length();

			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setInt(2, c.getFacultyId());
			pstmt.setInt(3, 1);
			pstmt.setBoolean(4, c.isStatus());
			pstmt.setDate(5, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(6, new Date(c.getDueDate().getTime()));
			pstmt.setString(7, c.getUserImageFileName());
			
//			 pstmt.setBinaryStream(7, fis, len); 
			
			pstmt.executeUpdate();
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
	}

	public void update(Claims c) {
		Connection conn = DBConnection.open();
		PreparedStatement pstmt = null;
		String insertString = "UPDATE Claims set studentID =?,facultyID = ?,ecCoordinatorID =?,status =?,"
				+ "createDate = ?,dueDate = ? WHERE id =?";

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setInt(2, c.getFacultyId());
			pstmt.setInt(3, 1);
			pstmt.setBoolean(4, c.isStatus());
			pstmt.setDate(5, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(6, new Date(c.getDueDate().getTime()));
			pstmt.setInt(7, c.getId());

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
}
