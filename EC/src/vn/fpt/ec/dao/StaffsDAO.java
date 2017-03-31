package vn.fpt.ec.dao;

import java.sql.Connection;
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
				staff.setSex(rs.getBoolean("sex"));
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
			rs.next();
			staff.setId(rs.getInt("id"));
			staff.setEmail(rs.getString("email"));

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

}
