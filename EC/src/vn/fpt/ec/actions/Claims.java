package vn.fpt.ec.actions;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import vn.fpt.ec.dao.ClaimTypeDAO;
import vn.fpt.ec.dao.ClaimsDAO;
import vn.fpt.ec.dao.StaffsDAO;
import vn.fpt.ec.dao.StudentsDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;

public class Claims extends ActionSupport implements ValidationAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4954629570486141056L;
	private final String open = "OPEN";
	private final String processing = "PROCESSING";
	private final String processed = "PROCESSED";
	private final String noEvidence = "NO EVIDENCE";
	private final String overDue = "OVER DUE";
	private int id;
	private String title;
	private String content;
	private int studentId;
	private int facultyId;
	private int ecCoordinatorID;
	private String status;
	private Date createDate;
	private Date dueDate;
	private File pathEvidence1;
	private File pathEvidence2;
	private File pathEvidence3;
	private String pathEvidence1ContentType;
	private String pathEvidence2ContentType;
	private String pathEvidence3ContentType;
	private String pathEvidence1FileName;
	private String pathEvidence2FileName;
	private String pathEvidence3FileName;
	private List<Claims> listClaims;
	private Students student;
	private ClaimType claimType;
	private String comment;
	private List<ClaimType> listType;
	private List<Staffs> listStaffs;
	private Staffs staffs;
	private SessionMap<String, Object> sessionmap;

	public String getAllClaims() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		listClaims = claimsDAO.getAllClaims();

		return "SUCCESS";
	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("student")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			listType = claimTypeDAO.select();
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String addClaim() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		Date today = new Date(System.currentTimeMillis());
		// SimpleDateFormat timeFormat= new
		// SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(today);
		c2.setTime(today);
		c2.roll(Calendar.DATE, 14);
		createDate = c1.getTime();
		dueDate = c2.getTime();
		this.setStatus(open);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		studentId = (int) session.getAttribute("id");
		StudentsDAO studentsDAO = new StudentsDAO();
		student = new Students();
		student = studentsDAO.findById(studentId);

		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);
			if (pathEvidence1FileName != null) {
				File fileToCreate1 = new File(filePath, pathEvidence1FileName);
				FileUtils.copyFile(pathEvidence1, fileToCreate1);
			}
			if (pathEvidence2FileName != null) {
				File fileToCreate2 = new File(filePath, pathEvidence2FileName);
				FileUtils.copyFile(pathEvidence2, fileToCreate2);
			}
			if (pathEvidence3FileName != null) {
				File fileToCreate3 = new File(filePath, pathEvidence3FileName);
				FileUtils.copyFile(pathEvidence3, fileToCreate3);
			}

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................
		StaffsDAO staffsDAO = new StaffsDAO();
		List<String> emailAdmin = new ArrayList<String>();
		emailAdmin = staffsDAO.selectAllAdmin();
		
		claimsDAO.insert(this);
		Emailer emailer = new Emailer();
		for (String mail : emailAdmin) {//send mail to all admin
			emailer.setTo(mail);
			emailer.execute();
		}
		
		return "SUCCESS";
	}

	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && !s.equals("student")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			StaffsDAO staffsDAO = new StaffsDAO();
			listStaffs = staffsDAO.selectAllStaff();
			listType = claimTypeDAO.select();
			return "SUCCESS";
		} else {
			return "error";
		}

	}

	public String updateClaim() {

		ClaimsDAO claimsDAO = new ClaimsDAO();
		Date today = new Date(System.currentTimeMillis());
		// SimpleDateFormat timeFormat= new
		// SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(today);
		c2.setTime(today);
		c2.roll(Calendar.DATE, 14);
		createDate = c1.getTime();
		dueDate = c2.getTime();
		Staffs st = new Staffs();
		StaffsDAO dao = new StaffsDAO();
		Emailer emailer = new Emailer();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			st = dao.findById(staffs.getId());
			emailer.setTo(st.getEmail());
			this.setStatus(processing);
		} else if (s != null && s.equals("ec")) {
			StudentsDAO studentsDAO = new StudentsDAO();
			Students students = new Students();
			students = studentsDAO.findById(studentId);
			emailer.setTo(students.getEmail());
			this.setStatus(processed);
		}
		StudentsDAO studentsDAO = new StudentsDAO();
		student = studentsDAO.findById(studentId);
		Claims claim = new Claims();
		claim = claimsDAO.findById(id);
		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);
			if (pathEvidence1FileName != null) {
				File fileToCreate1 = new File(filePath, pathEvidence1FileName);
				FileUtils.copyFile(pathEvidence1, fileToCreate1);
			} else {
				pathEvidence1FileName = claim.getPathEvidence1FileName();

			}
			if (pathEvidence2FileName != null) {
				File fileToCreate2 = new File(filePath, pathEvidence2FileName);
				FileUtils.copyFile(pathEvidence2, fileToCreate2);
			} else {
				pathEvidence2FileName = claim.getPathEvidence2FileName();
			}
			if (pathEvidence3FileName != null) {
				File fileToCreate3 = new File(filePath, pathEvidence3FileName);
				FileUtils.copyFile(pathEvidence3, fileToCreate3);
			} else {
				pathEvidence3FileName = claim.getPathEvidence3FileName();
			}
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................
		
		
		
		
		emailer.execute();
		claimsDAO.update(this);
		return "SUCCESS";
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

	public Claims searchById() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		Claims claim = new Claims();
		claim = claimsDAO.findById(id);
		title = claim.getTitle();
		student = claim.getStudent();
		studentId = claim.getStudentId();
		content = claim.getContent();
		status = claim.getStatus();
		createDate = claim.getCreateDate();
		dueDate = claim.getDueDate();
		pathEvidence1FileName = claim.getPathEvidence1FileName();
		pathEvidence2FileName = claim.getPathEvidence2FileName();
		pathEvidence3FileName = claim.getPathEvidence3FileName();
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		claimType = claimTypeDAO.findById(claim.getClaimType().getId());

		return claim;
	}

	public String deleteClaim() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && !s.equals("student")) {
			ClaimsDAO claimsDAO = new ClaimsDAO();
			claimsDAO.delete(id);
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	/*--------------getter & setter & constructor-----------*/
	public Claims() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getEcCoordinatorID() {
		return ecCoordinatorID;
	}

	public void setEcCoordinatorID(int ecCoordinatorID) {
		this.ecCoordinatorID = ecCoordinatorID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<Claims> getListClaims() {
		return listClaims;
	}

	public void setListClaims(List<Claims> listClaims) {
		this.listClaims = listClaims;
	}

	public Students getStudent() {
		return student;
	}

	public void setStudent(Students student) {
		this.student = student;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getPathEvidence1() {
		return pathEvidence1;
	}

	public void setPathEvidence1(File pathEvidence1) {
		this.pathEvidence1 = pathEvidence1;
	}

	public File getPathEvidence2() {
		return pathEvidence2;
	}

	public void setPathEvidence2(File pathEvidence2) {
		this.pathEvidence2 = pathEvidence2;
	}

	public File getPathEvidence3() {
		return pathEvidence3;
	}

	public void setPathEvidence3(File pathEvidence3) {
		this.pathEvidence3 = pathEvidence3;
	}

	public String getPathEvidence1ContentType() {
		return pathEvidence1ContentType;
	}

	public void setPathEvidence1ContentType(String pathEvidence1ContentType) {
		this.pathEvidence1ContentType = pathEvidence1ContentType;
	}

	public String getPathEvidence2ContentType() {
		return pathEvidence2ContentType;
	}

	public void setPathEvidence2ContentType(String pathEvidence2ContentType) {
		this.pathEvidence2ContentType = pathEvidence2ContentType;
	}

	public String getPathEvidence3ContentType() {
		return pathEvidence3ContentType;
	}

	public void setPathEvidence3ContentType(String pathEvidence3ContentType) {
		this.pathEvidence3ContentType = pathEvidence3ContentType;
	}

	public String getPathEvidence1FileName() {
		return pathEvidence1FileName;
	}

	public void setPathEvidence1FileName(String pathEvidence1FileName) {
		this.pathEvidence1FileName = pathEvidence1FileName;
	}

	public String getPathEvidence2FileName() {
		return pathEvidence2FileName;
	}

	public void setPathEvidence2FileName(String pathEvidence2FileName) {
		this.pathEvidence2FileName = pathEvidence2FileName;
	}

	public String getPathEvidence3FileName() {
		return pathEvidence3FileName;
	}

	public void setPathEvidence3FileName(String pathEvidence3FileName) {
		this.pathEvidence3FileName = pathEvidence3FileName;
	}

	public ClaimType getClaimType() {
		return claimType;
	}

	public void setClaimType(ClaimType claimType) {
		this.claimType = claimType;
	}

	public SessionMap<String, Object> getSessionmap() {
		return sessionmap;
	}

	public List<ClaimType> getListType() {
		return listType;
	}

	public void setListType(List<ClaimType> listType) {
		this.listType = listType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<Staffs> getListStaffs() {
		return listStaffs;
	}

	public void setListStaffs(List<Staffs> listStaffs) {
		this.listStaffs = listStaffs;
	}

	public Staffs getStaffs() {
		return staffs;
	}

	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}

	public void setSession(Map map) {
		sessionmap = (SessionMap) map;

	}

}
