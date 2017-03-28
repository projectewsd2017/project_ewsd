package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.ClaimType;
import vn.fpt.ec.actions.Claims;
import vn.fpt.ec.actions.Faculties;
import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class ClaimsDAO {

	public List<Claims> getAllClaims() {
		Connection conn = DBConnection.open();
		List<Claims> list = new ArrayList<Claims>();
		Claims claims = null;
		Statement stmt = null;
		ResultSet rs = null;
		String selectString = "SELECT C.id as claimId,C.title,C._content,C.status,C.createdDate,"
				+ "C.dueDate,C.ecCoordinatorID,C.pathEvidence1,C.pathEvidence2,C.pathEvidence3, "
				+ "S.id as sId,S.firstName,S.lastName,S.dob,S.email,S.address,S.sex,"
				+ "S.phonenumber,S.fatherName,S.motherName,S.fatherProfession,"
				+ "S.motherProfession,S.fatherPlaceOfWork,S.motherPlaceOfWork,S.facultyID,"
				+ "CT.id as cTypeId,CT.ClaimName,CT.Description "
				+ "FROM Claims C INNER JOIN Students S ON C.studentID = S.id "
				+ "INNER JOIN ClaimType CT on C.claimTypeID = CT.id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Students students = new Students();
				students.setId(rs.getInt("sId"));
				students.setFirstName(rs.getString("firstName"));
				students.setLastName(rs.getString("lastName"));
				students.setDob(rs.getDate("dob"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setSex(rs.getString("sex"));
				students.setPhoneNumber(rs.getString("phonenumber"));
				students.setFatherName(rs.getString("fatherName"));
				students.setMotherName(rs.getString("motherName"));
				students.setFatherProfession(rs.getString("fatherProfession"));
				students.setMotherProfession(rs.getString("motherProfession"));
				students.setFatherOfWork(rs.getString("fatherPlaceOfWork"));
				students.setMotherOfWork(rs.getString("motherPlaceOfWork"));
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("facultyID"));
				students.setFaculty(faculties);

				ClaimType claimType = new ClaimType();
				claimType.setId(rs.getInt("cTypeId"));
				claimType.setClaimName(rs.getString("ClaimName"));
				claimType.setDescription(rs.getString("Description"));

				claims = new Claims();
				claims.setId(rs.getInt("claimId"));
				claims.setContent(rs.getString("_content"));
				claims.setTitle(rs.getString("title"));

				// claims.setFacultyId(rs.getInt(students.getFacultyId()));
				claims.setStatus(rs.getString("status"));
				claims.setCreateDate(rs.getDate("createdDate"));
				claims.setDueDate(rs.getDate("dueDate"));
				claims.setStudent(students);
				claims.setPathEvidence1FileName(rs.getString("pathEvidence1"));
				claims.setPathEvidence2FileName(rs.getString("pathEvidence2"));
				claims.setPathEvidence3FileName(rs.getString("pathEvidence3"));
				claims.setClaimType(claimType);

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
		String insertString = "INSERT INTO Claims(studentID,title,_content,ecCoordinatorID,status,"
				+ "createdDate,dueDate,pathEvidence1,pathEvidence2,pathEvidence3,claimTypeID,facutlyID) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?) ";

		try {

			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setInt(4, 1);
			pstmt.setString(5, c.getStatus());
			pstmt.setDate(6, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(7, new Date(c.getDueDate().getTime()));
			pstmt.setString(8, c.getPathEvidence1FileName());
			pstmt.setString(9, c.getPathEvidence2FileName());
			pstmt.setString(10, c.getPathEvidence3FileName());
			pstmt.setInt(11, c.getClaimType().getId());
			pstmt.setInt(12, c.getStudent().getFaculty().getId());

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

		try {
			// String insertString = ""
			// + "pathEvidence2 = ?,pathEvidence3 = ?,status =?,"
			// +
			// "createdDate = ?,dueDate = ?,claimTypeID =? ,facutlyID = ?,ecCoordinatorID = ?,comment = ? WHERE id =?";
			StringBuilder builder = new StringBuilder();
			builder.append("UPDATE Claims set studentID =?,title = ?,_content =?,status =?,createdDate = ?,dueDate = ?,claimTypeID =? ,facutlyID = ?,ecCoordinatorID = ?,comment = ? ");
			if (c.getPathEvidence1FileName() != null) {
				builder.append(",pathEvidence1 = ? ");
			}
			if (c.getPathEvidence1FileName() != null) {
				builder.append(",pathEvidence2 = ? ");
			}
			if (c.getPathEvidence1FileName() != null) {
				builder.append(",pathEvidence3 = ? ");
			}
			builder.append("WHERE id =?");
			String insertString = builder.toString();
			pstmt = conn.prepareStatement(insertString);
			pstmt.setInt(1, c.getStudentId());
			pstmt.setString(2, c.getTitle());
			pstmt.setString(3, c.getContent());
			pstmt.setString(4, c.getStatus());
			pstmt.setDate(5, new Date(c.getCreateDate().getTime()));
			pstmt.setDate(6, new Date(c.getDueDate().getTime()));
			pstmt.setInt(7, c.getClaimType().getId());
			pstmt.setInt(8, c.getStudent().getFaculty().getId());
			pstmt.setInt(9, c.getStaffs().getId());
			pstmt.setString(10, c.getComment());
			if (c.getPathEvidence1FileName() != null) {
				pstmt.setString(11, c.getPathEvidence1FileName());
			}
			if (c.getPathEvidence1FileName() != null) {
				pstmt.setString(12, c.getPathEvidence2FileName());
			}
			if (c.getPathEvidence1FileName() != null) {
				pstmt.setString(13, c.getPathEvidence3FileName());
			}

			pstmt.setInt(14, c.getId());

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
			if (rs.next()) {
				claim.setId(rs.getInt("id"));
				claim.setStudentId(rs.getInt("studentID"));
				claim.setTitle(rs.getString("title"));
				claim.setContent(rs.getString("_content"));
				claim.setPathEvidence1FileName(rs.getString("pathEvidence1"));
				claim.setPathEvidence2FileName(rs.getString("pathEvidence2"));
				claim.setPathEvidence3FileName(rs.getString("pathEvidence3"));
				claim.setCreateDate(rs.getDate("createdDate"));
				claim.setDueDate(rs.getDate("dueDate"));
				claim.setStatus(rs.getString("status"));
				claim.setComment(rs.getString("comment"));
				claim.setEcCoordinatorID(rs.getInt("ecCoordinatorID"));
				ClaimType claimType = new ClaimType();
				claimType.setId(rs.getInt("claimTypeID"));
			
				claim.setClaimType(claimType);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claim;

	}

	public List<Claims> selectClaimByStudent(int id) {
		Connection conn = DBConnection.open();
		List<Claims> list = new ArrayList<Claims>();
		Claims claims = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String searchString = "SELECT C.id as claimId,C.title,C._content,C.status,C.createdDate,"
				+ "C.dueDate,C.ecCoordinatorID,C.pathEvidence1,C.pathEvidence2,C.pathEvidence3, "
				+ "S.id as sId,S.firstName,S.lastName,S.dob,S.email,S.address,S.sex,"
				+ "S.phonenumber,S.fatherName,S.motherName,S.fatherProfession,"
				+ "S.motherProfession,S.fatherPlaceOfWork,S.motherPlaceOfWork,S.facultyID,"
				+ "CT.id as cTypeId,CT.ClaimName,CT.Description "
				+ "FROM Claims C INNER JOIN Students S ON C.studentID = S.id "
				+ "INNER JOIN ClaimType CT on C.claimTypeID = CT.id"
				+ " WHERE S.id = ?";
		try {
			pstmt = conn.prepareStatement(searchString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Students students = new Students();
				students.setId(rs.getInt("sId"));
				students.setFirstName(rs.getString("firstName"));
				students.setLastName(rs.getString("lastName"));
				students.setDob(rs.getDate("dob"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setSex(rs.getString("sex"));
				students.setPhoneNumber(rs.getString("phonenumber"));
				students.setFatherName(rs.getString("fatherName"));
				students.setMotherName(rs.getString("motherName"));
				students.setFatherProfession(rs.getString("fatherProfession"));
				students.setMotherProfession(rs.getString("motherProfession"));
				students.setFatherOfWork(rs.getString("fatherPlaceOfWork"));
				students.setMotherOfWork(rs.getString("motherPlaceOfWork"));
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("facultyID"));
				students.setFaculty(faculties);

				ClaimType claimType = new ClaimType();
				claimType.setId(rs.getInt("cTypeId"));
				claimType.setClaimName(rs.getString("ClaimName"));
				claimType.setDescription(rs.getString("Description"));

				claims = new Claims();
				claims.setId(rs.getInt("claimId"));
				claims.setContent(rs.getString("_content"));
				claims.setTitle(rs.getString("title"));

				// claims.setFacultyId(rs.getInt(students.getFacultyId()));
				claims.setStatus(rs.getString("status"));
				claims.setCreateDate(rs.getDate("createdDate"));
				claims.setDueDate(rs.getDate("dueDate"));
				claims.setStudent(students);
				claims.setPathEvidence1FileName(rs.getString("pathEvidence1"));
				claims.setPathEvidence2FileName(rs.getString("pathEvidence2"));
				claims.setPathEvidence3FileName(rs.getString("pathEvidence3"));
				claims.setClaimType(claimType);

				list.add(claims);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
