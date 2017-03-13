package vn.fpt.ec.actions;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import vn.fpt.ec.dao.ClaimsDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ValidationAware;

public class Claims extends ActionSupport implements ValidationAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4954629570486141056L;
	private int id;
	private String title;
	private String content;
	private int studentId;
	private int facultyId;
	private int ecCoordinatorID;
	private boolean status;
	private Date createDate;
	private Date dueDate;
	private List<Claims> listClaims;
	private Students student;
	private ECCoordinator coordinator;
	private File pathEvidence;
	private String pathEvidenceContentType;
	private String pathEvidenceFileName;

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
		status = false;
		// --------------------------------------
		// String filePath = "C://Temp//file";
		// File fileToCreate = new File(filePath, userImageFileName);
		// try {
		// FileUtils.copyFile(userImage, fileToCreate);
		// } catch (IOException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// ....................................

		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);// see the server
																// console for
																// actual
																// location
			File fileToCreate = new File(filePath, pathEvidenceFileName);
			FileUtils.copyFile(pathEvidence, fileToCreate);// copying source
															// file to new file

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................

		claimsDAO.insert(this);
		return "SUCCESS";
	}
	
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
		status = false;
		try {

			String filePath = ServletActionContext.getServletContext()
					.getRealPath("/").concat("evidence");

			System.out.println("Image Location:" + filePath);// see the server
																// console for
																// actual
																// location
			File fileToCreate = new File(filePath, pathEvidenceFileName);
			FileUtils.copyFile(pathEvidence, fileToCreate);// copying source
															// file to new file

		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}

		// ....................................

		claimsDAO.update(this);
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
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

	public File getPathEvidence() {
		return pathEvidence;
	}

	public void setPathEvidence(File pathEvidence) {
		this.pathEvidence = pathEvidence;
	}

	public String getPathEvidenceContentType() {
		return pathEvidenceContentType;
	}

	public void setPathEvidenceContentType(String pathEvidenceContentType) {
		this.pathEvidenceContentType = pathEvidenceContentType;
	}

	public String getPathEvidenceFileName() {
		return pathEvidenceFileName;
	}

	public void setPathEvidenceFileName(String pathEvidenceFileName) {
		this.pathEvidenceFileName = pathEvidenceFileName;
	}

	public ECCoordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(ECCoordinator coordinator) {
		this.coordinator = coordinator;
	}

}
