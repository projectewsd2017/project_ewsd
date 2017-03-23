package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vn.fpt.ec.actions.Faculties;
import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class StudentsDAO {

	public List<Students> selectAllStudent() {
		Connection conn = DBConnection.open();
		Statement stmt = null;
		ResultSet rs = null;
		List<Students> list = new ArrayList<Students>();
		Students students = null;
		String selectString = "SELECT S.id as sId,S.username,S.password,S.firstName,S.lastName,S.dob,"
				+ "S.email,S.address,S.sex,S.facultyID,S.phonenumber,S.fatherName,S.motherName,"
				+ "S.fatherProfession,S.motherProfession,S.fatherPlaceOfWork,S.motherPlaceOfWork,"
				+ "F.id as fId,F.facutlyName FROM Students S INNER JOIN Faculties F ON S.facultyID = F.id";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("fId"));
				faculties.setFacutlyName(rs.getString("facutlyName"));
				
				students = new Students();
				students.setId(rs.getInt("sId"));
				students.setUsername(rs.getString("username"));
				students.setFirstName(rs.getString("firstName"));
				students.setLastName(rs.getString("lastName"));
				students.setDob(rs.getDate("dob"));
				students.setEmail(rs.getString("email"));
				students.setAddress(rs.getString("address"));
				students.setSex(rs.getBoolean("sex"));
				students.setPhoneNumber(rs.getString("phonenumber"));
				students.setFatherName(rs.getString("motherName"));
				students.setFatherProfession(rs.getString("fatherProfession"));
				students.setMotherProfession(rs.getString("motherProfession"));
				students.setFatherOfWork(rs.getString("fatherPlaceOfWork"));
				students.setMotherOfWork(rs.getString("motherPlaceOfWork"));
				students.setFaculty(faculties);

				list.add(students);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void insert(Students s) {
		Connection conn = DBConnection.open();
		String insertString = "INSERT INTO Students(username,password,firstName,lastName,dob,"
				+ "email,address,sex,facultyID,phonenumber,fatherName,motherName,fatherProfession,"
				+ "motherProfession,fatherPlaceOfWork,motherPlaceOfWork) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getPassword());
			pstmt.setString(3, s.getFirstName());
			pstmt.setString(4, s.getLastName());
			pstmt.setDate(5, new Date(s.getDob().getTime()));
			pstmt.setString(6, s.getEmail());
			pstmt.setString(7, s.getAddress());
			pstmt.setBoolean(8, s.isSex());
			pstmt.setInt(9, s.getFaculty().getId());
			pstmt.setString(10, s.getPhoneNumber());
			pstmt.setString(11, s.getFatherName());
			pstmt.setString(12, s.getMotherName());
			pstmt.setString(13, s.getFatherProfession());
			pstmt.setString(14, s.getMotherProfession());
			pstmt.setString(15, s.getFatherOfWork());
			pstmt.setString(16, s.getMotherOfWork());

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public void update(Students s) {
		Connection conn = DBConnection.open();
		String insertString = "UPDATE Students SET username = ?,password = ?,firstName = ?,lastName = ?,dob = ?,"
				+ "email = ?,address = ?,sex = ?,facultyID = ?,phonenumber = ?,fatherName = ?,motherName = ?,fatherProfession = ?,"
				+ "motherProfession = ?,fatherPlaceOfWork = ?,motherPlaceOfWork = ? WHERE id = ?";

		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(insertString);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getPassword());
			pstmt.setString(3, s.getFirstName());
			pstmt.setString(4, s.getLastName());
			pstmt.setDate(5, new Date(s.getDob().getTime()));
			pstmt.setString(6, s.getEmail());
			pstmt.setString(7, s.getAddress());
			pstmt.setBoolean(8, s.isSex());
			pstmt.setInt(9, s.getFacultyId());
			pstmt.setString(10, s.getPhoneNumber());
			pstmt.setString(11, s.getFatherName());
			pstmt.setString(12, s.getMotherName());
			pstmt.setString(13, s.getFatherProfession());
			pstmt.setString(14, s.getMotherProfession());
			pstmt.setString(15, s.getFatherOfWork());
			pstmt.setString(16, s.getMotherOfWork());
			pstmt.setInt(17, s.getId());

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}
	}

	public void delete(int id) {
		Connection conn = DBConnection.open();
		String deleteString = "DELETE FROM Students WHERE id = ? ";
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

	public Students findById(int id) {
		Connection conn = DBConnection.open();
		String findByIdString = "Select * From Students Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Students student = null;
		try {
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			student = new Students();
			student.setId(rs.getInt("id"));
			student.setFacultyId(rs.getInt("facultyID"));
			student.setUsername(rs.getString("username"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;

	}
}
