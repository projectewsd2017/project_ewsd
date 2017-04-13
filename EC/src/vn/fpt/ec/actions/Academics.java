package vn.fpt.ec.actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vn.fpt.ec.dao.AcademicDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Academics extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2130777671593335286L;
	private int id;
	private Date openDate;
	private Date closureDate;
	private String name;
	private List<Academics> listAcademics;
	private String openDateString;
	private String closureDateString;
	

	public String getAllAcademics() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			AcademicDAO academicDAO = new AcademicDAO();
			listAcademics = academicDAO.select();

			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String addAcademic() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			openDate = format.parse(openDateString);
			closureDate = format.parse(closureDateString);
			AcademicDAO academicDAO = new AcademicDAO();
			academicDAO.insert(this);

			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			AcademicDAO academicDAO = new AcademicDAO();
			Academics academic = new Academics();
			academic = academicDAO.findById(id);
			this.setOpenDate(academic.getOpenDate());
			this.setClosureDate(academic.getClosureDate());
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String updateAcademic() throws ParseException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			openDate = format.parse(openDateString);
			closureDate = format.parse(closureDateString);
			AcademicDAO academicDAO = new AcademicDAO();
			academicDAO.update(this);

			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String deleteAcademic() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			AcademicDAO academicDAO = new AcademicDAO();
			academicDAO.delete(id);
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String search() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			searchById();
			return "SUCCESS";
		} else {
			return "error";
		}

	}

	public Academics searchById() {
		AcademicDAO academicDAO = new AcademicDAO();
		
		Academics academics = new Academics();
		academics = academicDAO.findById(id);
		id = academics.getId();
		name = academics.getName();
		openDate = academics.getOpenDate();
		closureDate = academics.getClosureDate();

		return academics;
	}
	
	public Academics() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public List<Academics> getListAcademics() {
		return listAcademics;
	}

	public void setListAcademics(List<Academics> listAcademics) {
		this.listAcademics = listAcademics;
	}

	public String getOpenDateString() {
		return openDateString;
	}

	public void setOpenDateString(String openDateString) {
		this.openDateString = openDateString;
	}

	public String getClosureDateString() {
		return closureDateString;
	}

	public void setClosureDateString(String closureDateString) {
		this.closureDateString = closureDateString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
