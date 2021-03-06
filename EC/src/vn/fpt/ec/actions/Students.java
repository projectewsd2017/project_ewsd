package vn.fpt.ec.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vn.fpt.ec.dao.AcademicDAO;
import vn.fpt.ec.dao.FacultyDAO;
import vn.fpt.ec.dao.StudentsDAO;

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
	private String sex;
	private String phoneNumber;
	private String fatherName;
	private String motherName;
	private String fatherProfession;
	private String motherProfession;
	private String fatherOfWork;
	private String motherOfWork;
	private String dobString;
	private Faculties faculty;
	private List<Students> listAllStudents;
	private List<Faculties> listAllFaculty;
	private List<Students> listStudent;
	private List<Academics> listAcademics;
	private Academics academics;

	public String getAllStudent() {
		StudentsDAO studentsDAO = new StudentsDAO();
		listAllStudents = studentsDAO.selectAllStudent();

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
			AcademicDAO academicDAO = new AcademicDAO();
			listAcademics = new ArrayList<Academics>();
			listAcademics = academicDAO.select();
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String addStudent() throws ParseException {
		StudentsDAO studentsDAO = new StudentsDAO();
		password = "Abc123!";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		dob = format.parse(dobString);

		studentsDAO.insert(this);
		Students s = new Students();
		s = studentsDAO.findByUsername(username);
		s.setUsername(username + s.getId());
		s.setEmail(s.getUsername().concat("@gmail.com"));
		studentsDAO.update(s);
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
			AcademicDAO academicDAO = new AcademicDAO();
			listAcademics = new ArrayList<Academics>();
			listAcademics = academicDAO.select();
			Students st = new Students();
			StudentsDAO sDao = new StudentsDAO();
			st = sDao.findById(id);
			this.setDob(st.getDob());
			;
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String updateStudent() {
		StudentsDAO studentsDAO = new StudentsDAO();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dob = format.parse(dobString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentsDAO.update(this);
		return "SUCCESS";
	}

	public String deleteStudent() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			StudentsDAO studentsDAO = new StudentsDAO();
			studentsDAO.delete(id);
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

	public Students searchById() {
		StudentsDAO studentsDAO = new StudentsDAO();
		Students student = new Students();
		student = studentsDAO.findById(id);
		username = student.getUsername();
		password = student.getPassword();
		firstName = student.getFirstName();
		lastName = student.getLastName();
		dob = student.getDob();
		email = student.getEmail();
		address = student.getAddress();
		sex = student.getSex();
		phoneNumber = student.getPhoneNumber();
		fatherName = student.getFatherName();
		motherName = student.getMotherName();
		fatherProfession = student.getFatherProfession();
		motherProfession = student.getMotherProfession();
		fatherOfWork = student.getFatherOfWork();
		motherOfWork = student.getMotherOfWork();
		FacultyDAO facultyDAO = new FacultyDAO();
		faculty = facultyDAO.findById(student.getFaculty().getId());
		AcademicDAO academicDAO = new AcademicDAO();
		academics = academicDAO.findById(student.getAcademics().getId());

		return student;
	}

	public String searchST() {
		return "SUCCESS";
	}

	public String searchStudentByUsername() {
		StudentsDAO studentsDAO = new StudentsDAO();
		listAllStudents = studentsDAO.searchByUsername(username);
		return "SUCCESS";
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public Faculties getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}

	public List<Students> getListAllStudents() {
		return listAllStudents;
	}

	public void setListAllStudents(List<Students> listAllStudents) {
		this.listAllStudents = listAllStudents;
	}

	public List<Faculties> getListAllFaculty() {
		return listAllFaculty;
	}

	public void setListAllFaculty(List<Faculties> listAllFaculty) {
		this.listAllFaculty = listAllFaculty;
	}

	public String getDobString() {
		return dobString;
	}

	public void setDobString(String dobString) {
		this.dobString = dobString;
	}

	public List<Students> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Students> listStudent) {
		this.listStudent = listStudent;
	}

	public List<Academics> getListAcademics() {
		return listAcademics;
	}

	public void setListAcademics(List<Academics> listAcademics) {
		this.listAcademics = listAcademics;
	}

	public Academics getAcademics() {
		return academics;
	}

	public void setAcademics(Academics academics) {
		this.academics = academics;
	}

}