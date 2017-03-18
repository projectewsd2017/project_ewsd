package vn.fpt.ec.actions;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import vn.fpt.ec.dao.ClaimsDAO;

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
	private String pathEvidenceContentType1;
	private String pathEvidenceContentType2;
	private String pathEvidenceContentType3;
	private String pathEvidenceFileName1;
	private String pathEvidenceFileName2;
	private String pathEvidenceFileName3;
	private List<Claims> listClaims;
	private Students student;
	private ClaimType claimType;

	private SessionMap<String, Object> sessionmap;

	public String getAllClaims() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		listClaims = claimsDAO.getAllClaims();

		return "SUCCESS";
	}

	public String add() {
		return "SUCCESS";
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

		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);
			File fileToCreate1 = new File(filePath, pathEvidenceFileName1);
			File fileToCreate2 = new File(filePath, pathEvidenceFileName2);
			File fileToCreate3 = new File(filePath, pathEvidenceFileName3);
			FileUtils.copyFile(pathEvidence1, fileToCreate1);
			FileUtils.copyFile(pathEvidence2, fileToCreate2);
			FileUtils.copyFile(pathEvidence3, fileToCreate3);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................

		claimsDAO.insert(this);
		return "SUCCESS";
	}

	// public void validate() {
	// if (title == null || title.trim().length() < 1)
	// addFieldError("name", "Name can't be blank");
	// if (content == null ||content.length() < 6)
	// addFieldError("password", "Password must be greater than 5");
	// }
	public String update() {

		return "SUCCESS";
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

		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);
			File fileToCreate1 = new File(filePath, pathEvidenceFileName1);
			File fileToCreate2 = new File(filePath, pathEvidenceFileName2);
			File fileToCreate3 = new File(filePath, pathEvidenceFileName3);
			FileUtils.copyFile(pathEvidence1, fileToCreate1);
			FileUtils.copyFile(pathEvidence2, fileToCreate2);
			FileUtils.copyFile(pathEvidence3, fileToCreate3);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................
		claimsDAO.update(this);
		return "SUCCESS";
	}

	public String search() {
		searchById();
		return "SUCCESS";
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
		pathEvidenceFileName1 = claim.getPathEvidenceFileName1();
		pathEvidenceFileName2 = claim.getPathEvidenceFileName2();
		pathEvidenceFileName3 = claim.getPathEvidenceFileName3();
		return claim;
	}

	public String deleteClaim() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		claimsDAO.delete(id);
		return "SUCCESS";
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

	public String getPathEvidenceContentType1() {
		return pathEvidenceContentType1;
	}

	public void setPathEvidenceContentType1(String pathEvidenceContentType1) {
		this.pathEvidenceContentType1 = pathEvidenceContentType1;
	}

	public String getPathEvidenceContentType2() {
		return pathEvidenceContentType2;
	}

	public void setPathEvidenceContentType2(String pathEvidenceContentType2) {
		this.pathEvidenceContentType2 = pathEvidenceContentType2;
	}

	public String getPathEvidenceContentType3() {
		return pathEvidenceContentType3;
	}

	public void setPathEvidenceContentType3(String pathEvidenceContentType3) {
		this.pathEvidenceContentType3 = pathEvidenceContentType3;
	}

	public String getPathEvidenceFileName1() {
		return pathEvidenceFileName1;
	}

	public void setPathEvidenceFileName1(String pathEvidenceFileName1) {
		this.pathEvidenceFileName1 = pathEvidenceFileName1;
	}

	public String getPathEvidenceFileName2() {
		return pathEvidenceFileName2;
	}

	public void setPathEvidenceFileName2(String pathEvidenceFileName2) {
		this.pathEvidenceFileName2 = pathEvidenceFileName2;
	}

	public String getPathEvidenceFileName3() {
		return pathEvidenceFileName3;
	}

	public void setPathEvidenceFileName3(String pathEvidenceFileName3) {
		this.pathEvidenceFileName3 = pathEvidenceFileName3;
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

	public void setSession(Map map) {
		sessionmap = (SessionMap) map;

	}

}
