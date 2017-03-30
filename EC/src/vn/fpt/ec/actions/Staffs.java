package vn.fpt.ec.actions;

import java.util.Date;
import java.util.List;

import vn.fpt.ec.dao.StaffsDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Staffs extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4576401124048131151L;
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private Date dob;
	private String placeOfBirth;
	private String email;
	private String address;
	private boolean sex;
	private String dateOfHiring;
	private double salary;
	private int ecMangerID;
	private int roleID;
	private String phoneNumber;
	private String fatherName;
	private String motherName;
	private String fatherPlaceOfWork;
	private String motherPlaceOfWork;
	private Faculties faculty;
	private Roles role;
	private List<Staffs> listStaffs;

	public String selectAllStaffs(){
		StaffsDAO staffsDAO = new StaffsDAO();
		listStaffs = staffsDAO.selectAllStaff();
		return "SUCCESS";
	}
	
	public Staffs() {
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

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
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

	public String getDateOfHiring() {
		return dateOfHiring;
	}

	public void setDateOfHiring(String dateOfHiring) {
		this.dateOfHiring = dateOfHiring;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEcMangerID() {
		return ecMangerID;
	}

	public void setEcMangerID(int ecMangerID) {
		this.ecMangerID = ecMangerID;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
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

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherPlaceOfWork() {
		return fatherPlaceOfWork;
	}

	public void setFatherPlaceOfWork(String fatherPlaceOfWork) {
		this.fatherPlaceOfWork = fatherPlaceOfWork;
	}

	public String getMotherPlaceOfWork() {
		return motherPlaceOfWork;
	}

	public void setMotherPlaceOfWork(String motherPlaceOfWork) {
		this.motherPlaceOfWork = motherPlaceOfWork;
	}

	public Faculties getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public List<Staffs> getListStaffs() {
		return listStaffs;
	}

	public void setListStaffs(List<Staffs> listStaffs) {
		this.listStaffs = listStaffs;
	}
	

}
