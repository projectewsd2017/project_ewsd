package vn.fpt.ec.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class Students extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -871025309049738154L;
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private String address;
	private boolean sex;
	private int facultyId;
	private String phoneNumber;
	private String fatherName;
	private String motherNumber;
	private String fatherProfession;
	private String motherProfession;
	private String fatherOfWork;
	private String motherOfWork;

	/*--------------getter & setter & constructor-----------*/
	public Students() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherNumber() {
		return motherNumber;
	}

	public void setMotherNumber(String motherNumber) {
		this.motherNumber = motherNumber;
	}

	public String getFatherProfession() {
		return fatherProfession;
	}

	public void setFatherProfession(String fatherProfession) {
		this.fatherProfession = fatherProfession;
	}

	public String getMotherProfession() {
		return motherProfession;
	}

	public void setMotherProfession(String motherProfession) {
		this.motherProfession = motherProfession;
	}

	public String getFatherOfWork() {
		return fatherOfWork;
	}

	public void setFatherOfWork(String fatherOfWork) {
		this.fatherOfWork = fatherOfWork;
	}

	public String getMotherOfWork() {
		return motherOfWork;
	}

	public void setMotherOfWork(String motherOfWork) {
		this.motherOfWork = motherOfWork;
	}
	
	

}