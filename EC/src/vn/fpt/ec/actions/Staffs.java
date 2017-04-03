package vn.fpt.ec.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vn.fpt.ec.dao.FacultyDAO;
import vn.fpt.ec.dao.RoleDAO;
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
	private String sex;
	private String dateOfHiring;
	private double salary;
	private int ecMangerID;
	private String phoneNumber;
	private String fatherName;
	private String motherName;
	private String fatherPlaceOfWork;
	private String motherPlaceOfWork;
	private String dobString;
	private Faculties faculty;
	private Roles role;
	private List<Staffs> listStaffs;
	private List<Faculties> listAllFaculty;
	private List<Roles> listRole;

	public String selectAllStaffs() {
		StaffsDAO staffsDAO = new StaffsDAO();
		listStaffs = staffsDAO.selectAllStaff();
		return "SUCCESS";
	}

	public String add() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			FacultyDAO facultyDAO = new FacultyDAO();
			listAllFaculty = new ArrayList<Faculties>();
			listAllFaculty = facultyDAO.select();
			RoleDAO roleDAO = new RoleDAO();
			listRole = new ArrayList<Roles>();
			listRole = roleDAO.selectAll();
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String addStaff() throws ParseException {
		StaffsDAO staffDAO = new StaffsDAO();
		password = "Abc123!";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dob = format.parse(dobString);

		staffDAO.insert(this);
		Staffs s = new Staffs();
		s = staffDAO.findByUsername(username);
		s.setUsername(username + s.getId());
		s.setEmail(s.getUsername().concat("@gmail.com"));
		staffDAO.update(s);
		return "SUCCESS";
	}

	public String update() {

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			FacultyDAO facultyDAO = new FacultyDAO();
			listAllFaculty = new ArrayList<Faculties>();
			listAllFaculty = facultyDAO.select();
			RoleDAO roleDAO = new RoleDAO();
			listRole = new ArrayList<Roles>();
			listRole = roleDAO.selectAll();
			Staffs st = new Staffs();
			StaffsDAO sDao = new StaffsDAO();
			st = sDao.findById(id);
			this.setDob(st.getDob());
			
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String updateStaff() {
		StaffsDAO staffDAO = new StaffsDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dob = format.parse(dobString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		staffDAO.update(this);
		return "SUCCESS";
	}

	public String deleteStaff() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			StaffsDAO staffDAO = new StaffsDAO();
			staffDAO.delete(id);
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String search() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && !s.equals("student")) {
			searchById();
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public Staffs searchById() {
		StaffsDAO staffsDAO = new StaffsDAO();
		Staffs staff = new Staffs();
		staff = staffsDAO.findById(id);
		username = staff.getUsername();
		password = staff.getPassword();
		firstName = staff.getFirstName();
		lastName = staff.getLastName();
		dob = staff.getDob();
		email = staff.getEmail();
		address = staff.getAddress();
		sex = staff.getSex();
		phoneNumber = staff.getPhoneNumber();
		fatherName = staff.getFatherName();
		motherName = staff.getMotherName();
		placeOfBirth = staff.getPlaceOfBirth();

		role = new Roles();
		RoleDAO roleDAO = new RoleDAO();
		role = roleDAO.findById(staff.getRole().getId());
		fatherPlaceOfWork = staff.getFatherPlaceOfWork();
		motherPlaceOfWork = staff.getMotherPlaceOfWork();
		FacultyDAO facultyDAO = new FacultyDAO();
		faculty = facultyDAO.findById(staff.getFaculty().getId());

		return staff;
	}

	public String searchStaffByUsername() {
		StaffsDAO staffDAO = new StaffsDAO();
		listStaffs = staffDAO.searchByUsername(username);
		return "SUCCESS";
	}
	/*--------------getter & setter & constructor-----------*/
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getDobString() {
		return dobString;
	}

	public void setDobString(String dobString) {
		this.dobString = dobString;
	}

	public List<Faculties> getListAllFaculty() {
		return listAllFaculty;
	}

	public void setListAllFaculty(List<Faculties> listAllFaculty) {
		this.listAllFaculty = listAllFaculty;
	}

	public List<Roles> getListRole() {
		return listRole;
	}

	public void setListRole(List<Roles> listRole) {
		this.listRole = listRole;
	}

}
