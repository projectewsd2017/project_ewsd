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
import vn.fpt.ec.actions.Roles;
import vn.fpt.ec.actions.Staffs;
import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class StaffsDAO {
	public List<Staffs> selectAllStaff() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Staffs> list = new ArrayList<Staffs>();
		Staffs staff = null;
		String selectString = "SELECT S.id as sId,S.username,S.password,S.firstName,S.lastName,S.dob,"
				+ "S.placeOfBirth,S.email,S.address,S.sex,S.facultyID,S.phonenumber,S.fatherName,S.motherName,"
				+ "S.fatherPlaceOfWork,S.motherPlaceOfWork,S.salary,S.ecMangerID,S.roleID ,"
				+ "R.id as rId,R.roleName,F.id as fId,F.facutlyName FROM Staffs S INNER JOIN Roles R ON S.roleID = R.id "
				+ "INNER JOIN Faculties F ON S.facultyID = F.id";
		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("fId"));
				faculties.setFacutlyName(rs.getString("facutlyName"));

				Roles role = new Roles();
				role.setId(rs.getInt("rId"));
				role.setRoleName(rs.getString("roleName"));

				staff = new Staffs();
				staff.setId(rs.getInt("sId"));
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setFirstName(rs.getString("firstName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setDob(rs.getDate("dob"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setSex(rs.getString("sex"));
				staff.setPhoneNumber(rs.getString("phonenumber"));
				staff.setFatherName(rs.getString("motherName"));
				staff.setFatherPlaceOfWork(rs.getString("fatherPlaceOfWork"));
				staff.setMotherPlaceOfWork(rs.getString("motherPlaceOfWork"));
				staff.setFaculty(faculties);
				staff.setRole(role);
				list.add(staff);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	
	public List<Staffs> selectCoo() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Staffs> list = new ArrayList<Staffs>();
		Staffs staff = null;
		String selectString = "SELECT S.id as sId,S.username,S.password,S.firstName,S.lastName,S.dob,"
				+ "S.placeOfBirth,S.email,S.address,S.sex,S.facultyID,S.phonenumber,S.fatherName,S.motherName,"
				+ "S.fatherPlaceOfWork,S.motherPlaceOfWork,S.salary,S.ecMangerID,S.roleID ,"
				+ "R.id as rId,R.roleName,F.id as fId,F.facutlyName FROM Staffs S INNER JOIN Roles R ON S.roleID = R.id "
				+ "INNER JOIN Faculties F ON S.facultyID = F.id WHERE S.id = 2";
		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("fId"));
				faculties.setFacutlyName(rs.getString("facutlyName"));

				Roles role = new Roles();
				role.setId(rs.getInt("rId"));
				role.setRoleName(rs.getString("roleName"));

				staff = new Staffs();
				staff.setId(rs.getInt("sId"));
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));
				staff.setFirstName(rs.getString("firstName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setDob(rs.getDate("dob"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setSex(rs.getString("sex"));
				staff.setPhoneNumber(rs.getString("phonenumber"));
				staff.setFatherName(rs.getString("motherName"));
				staff.setFatherPlaceOfWork(rs.getString("fatherPlaceOfWork"));
				staff.setMotherPlaceOfWork(rs.getString("motherPlaceOfWork"));
				staff.setFaculty(faculties);
				staff.setRole(role);
				list.add(staff);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public Staffs findById(int id) {
		Connection conn = null;
		String findByIdString = "Select * From Staffs Where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staffs staff = new Staffs();
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				staff = new Staffs();
				staff.setId(rs.getInt("id"));
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("facultyID"));
				staff.setFaculty(faculties);
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));

				staff.setFirstName(rs.getString("firstName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setDob(rs.getDate("dob"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setSex(rs.getString("sex"));
				staff.setPhoneNumber(rs.getString("phonenumber"));
				staff.setFatherName(rs.getString("fatherName"));
				staff.setMotherName(rs.getString("motherName"));
				staff.setPlaceOfBirth(rs.getString("placeOfBirth"));
				Roles role = new Roles();
				role.setId(rs.getInt("roleID"));
				staff.setRole(role);
				staff.setFatherPlaceOfWork(rs.getString("fatherPlaceOfWork"));
				staff.setMotherPlaceOfWork(rs.getString("motherPlaceOfWork"));
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;

	}

	public List<String> selectAllAdmin() {
		Connection conn = null;
		String selectString = "Select * From Staffs Where RoleID = 1";
		Statement stmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		Staffs staff = null;
		try {
			conn = DBConnection.getMySQLConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectString);
			while (rs.next()) {
				staff = new Staffs();
				staff.setId(rs.getInt("id"));
				staff.setEmail(rs.getString("email"));
				list.add(staff.getEmail());
			}

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public void insert(Staffs s) {
		Connection conn = null;
		String insertString = "INSERT INTO Staffs(username,password,firstName,lastName,dob,"
				+ "email,address,sex,facultyID,phonenumber,fatherName,motherName,"
				+ "fatherPlaceOfWork,motherPlaceOfWork,placeOfBirth,roleID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(insertString);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getPassword());
			pstmt.setString(3, s.getFirstName());
			pstmt.setString(4, s.getLastName());
			pstmt.setDate(5, new Date(s.getDob().getTime()));
			pstmt.setString(6, s.getEmail());
			pstmt.setString(7, s.getAddress());
			pstmt.setString(8, s.getSex());
			pstmt.setInt(9, s.getFaculty().getId());
			pstmt.setString(10, s.getPhoneNumber());
			pstmt.setString(11, s.getFatherName());
			pstmt.setString(12, s.getMotherName());

			pstmt.setString(13, s.getFatherPlaceOfWork());
			pstmt.setString(14, s.getMotherPlaceOfWork());
			pstmt.setString(15, s.getPlaceOfBirth());
			pstmt.setInt(16, s.getRole().getId());

			pstmt.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, pstmt, null);
		}

	}

	public void update(Staffs s) {
		Connection conn = null;
		String updateString = "UPDATE Staffs SET username = ?,firstName = ?,lastName = ?,dob = ?,"
				+ "email = ?,address = ?,sex = ?,facultyID = ?,phonenumber = ?,fatherName = ?,motherName = ?,placeOfBirth = ?,"
				+ "roleID = ?,fatherPlaceOfWork = ?,motherPlaceOfWork = ? WHERE id = ?";
		PreparedStatement pstmt = null;

		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(updateString);
			pstmt.setString(1, s.getUsername());
			pstmt.setString(2, s.getFirstName());
			pstmt.setString(3, s.getLastName());
			pstmt.setDate(4, new Date(s.getDob().getTime()));
			pstmt.setString(5, s.getEmail());
			pstmt.setString(6, s.getAddress());
			pstmt.setString(7, s.getSex());
			pstmt.setInt(8, s.getFaculty().getId());
			pstmt.setString(9, s.getPhoneNumber());
			pstmt.setString(10, s.getFatherName());
			pstmt.setString(11, s.getMotherName());
			pstmt.setString(12, s.getPlaceOfBirth());
			pstmt.setInt(13, s.getRole().getId());
			pstmt.setString(14, s.getFatherPlaceOfWork());
			pstmt.setString(15, s.getMotherPlaceOfWork());
			pstmt.setInt(16, s.getId());

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
		String deleteString = "DELETE FROM Staffs WHERE id = ? ";
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

	public Staffs findByUsername(String username) {
		Connection conn = null;
		String findByIdString = "Select * From Staffs Where username = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staffs staff = null;
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				staff = new Staffs();
				staff.setId(rs.getInt("id"));
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("facultyID"));
				staff.setFaculty(faculties);
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));

				staff.setFirstName(rs.getString("firstName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setDob(rs.getDate("dob"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setSex(rs.getString("sex"));
				staff.setPhoneNumber(rs.getString("phonenumber"));
				staff.setFatherName(rs.getString("fatherName"));
				staff.setMotherName(rs.getString("motherName"));
				Roles role = new Roles();
				role.setId(rs.getInt("roleID"));
				staff.setRole(role);
				staff.setPlaceOfBirth(rs.getString("placeOfBirth"));
				staff.setFatherPlaceOfWork(rs.getString("fatherPlaceOfWork"));
				staff.setMotherPlaceOfWork(rs.getString("motherPlaceOfWork"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;

	}

	public List<Staffs> searchByUsername(String username) {
		Connection conn = null;
		String findByIdString = "Select * From Staffs Where username like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Staffs staff = null;
		List<Staffs> list = new ArrayList<Staffs>();
		try {
			conn = DBConnection.getMySQLConnection();
			pstmt = conn.prepareStatement(findByIdString);
			pstmt.setString(1, "%" + username + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				staff = new Staffs();
				staff.setId(rs.getInt("id"));
				Faculties faculties = new Faculties();
				faculties.setId(rs.getInt("facultyID"));
				staff.setFaculty(faculties);
				staff.setUsername(rs.getString("username"));
				staff.setPassword(rs.getString("password"));

				staff.setFirstName(rs.getString("firstName"));
				staff.setLastName(rs.getString("lastName"));
				staff.setDob(rs.getDate("dob"));
				staff.setEmail(rs.getString("email"));
				staff.setAddress(rs.getString("address"));
				staff.setSex(rs.getString("sex"));
				staff.setPhoneNumber(rs.getString("phonenumber"));
				staff.setFatherName(rs.getString("fatherName"));
				staff.setMotherName(rs.getString("motherName"));
				Roles role = new Roles();
				role.setId(rs.getInt("roleID"));
				staff.setRole(role);
				staff.setPlaceOfBirth(rs.getString("placeOfBirth"));
				staff.setFatherPlaceOfWork(rs.getString("fatherPlaceOfWork"));
				staff.setMotherPlaceOfWork(rs.getString("motherPlaceOfWork"));
				list.add(staff);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
