package vn.fpt.ec.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Students extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -871025309049738154L;
	private int id;
	private String studentName;
	private String email;
	private String address;
	private int facultyId;

	/*--------------getter & setter & constructor-----------*/
	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(int id, String studentName, String email,
			String address, int facultyId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.email = email;
		this.address = address;
		this.facultyId = facultyId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

}
