package vn.fpt.ec.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import vn.fpt.ec.dao.ClaimTypeDAO;

import com.opensymphony.xwork2.ActionSupport;

public class ClaimType extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646075181611906596L;
	private int id;
	private String claimName;
	private String description;
	private List<ClaimType> listType;

	public String getAllType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			listType = claimTypeDAO.select();

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

	public String addType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			claimTypeDAO.insert(this);

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
			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String updateType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			claimTypeDAO.update(this);

			return "SUCCESS";
		} else {
			return "error";
		}
	}

	public String deleteType() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();

		String s = (String) session.getAttribute("login");
		if (s != null && s.equals("admin")) {
			ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
			claimTypeDAO.delete(id);
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

	public ClaimType searchById() {
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		ClaimType claimType = new ClaimType();
		claimType = claimTypeDAO.findById(id);
		id = claimType.getId();
		claimName = claimType.getClaimName();
		description = claimType.getDescription();

		return claimType;
	}

	/*--------------getter & setter & constructor-----------*/
	public ClaimType() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimName() {
		return claimName;
	}

	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ClaimType> getListType() {
		return listType;
	}

	public void setListType(List<ClaimType> listType) {
		this.listType = listType;
	}

}
