package vn.fpt.ec.actions;

import java.io.File;
import java.io.IOException;
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
	private int studentId;
	private int facultyId;
	private int ecCoordinatorID;
	private boolean status;
	private Date createDate;
	private Date dueDate;
	private List<Claims> listClaims;
	private Students student;
	private ECCoordinator coordinator;
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	public String getAllClaims() {
		ClaimsDAO claimsDAO = new ClaimsDAO();
		listClaims = claimsDAO.getAllClaims();
		return "SUCCESS";
	}

	public String add() {
		return "SUCCESS";
	}

	public String addClaim() throws IOException {
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
		String filePath = "C://Temp//file"; 
		File fileToCreate = new File(filePath, userImageFileName);
		try {
			FileUtils.copyFile(userImage, fileToCreate);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//....................................
		

		claimsDAO.insert(this);
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

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public ECCoordinator getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(ECCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	
}
