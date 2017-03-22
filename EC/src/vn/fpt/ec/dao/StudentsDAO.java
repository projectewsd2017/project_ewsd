package vn.fpt.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vn.fpt.ec.actions.Students;
import vn.fpt.ec.connection.DBConnection;

public class StudentsDAO {
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
