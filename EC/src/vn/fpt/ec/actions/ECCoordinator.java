package vn.fpt.ec.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ECCoordinator extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1602903324781648662L;
	private int id;
	private String ecCoordinatorName;
	private String email;
	private int ecManagerID;
	private int facultyID;

	public ECCoordinator() {
		// TODO Auto-generated constructor stub
	}

	public ECCoordinator(int id, String ecCoordinatorName, String email,
			int ecManagerID, int facultyID) {
		super();
		this.id = id;
		this.ecCoordinatorName = ecCoordinatorName;
		this.email = email;
		this.ecManagerID = ecManagerID;
		this.facultyID = facultyID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEcCoordinatorName() {
		return ecCoordinatorName;
	}

	public void setEcCoordinatorName(String ecCoordinatorName) {
		this.ecCoordinatorName = ecCoordinatorName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEcManagerID() {
		return ecManagerID;
	}

	public void setEcManagerID(int ecManagerID) {
		this.ecManagerID = ecManagerID;
	}

	public int getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}

}
