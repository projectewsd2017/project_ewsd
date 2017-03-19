package vn.fpt.ec.actions;

import java.util.List;

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
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		listType = claimTypeDAO.select();

		return "SUCCESS";
	}

	public String add() {
		return "SUCCESS";
	}

	public String addType() {
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		claimTypeDAO.insert(this);

		return "SUCCESS";
	}

	public String update() {

		return "SUCCESS";
	}

	public String updateType() {
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		claimTypeDAO.update(this);

		return "SUCCESS";
	}

	public String deleteType() {
		ClaimTypeDAO claimTypeDAO = new ClaimTypeDAO();
		claimTypeDAO.delete(id);
		return "SUCCESS";
	}

	public String search() {
		searchById();
		return "SUCCESS";
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
