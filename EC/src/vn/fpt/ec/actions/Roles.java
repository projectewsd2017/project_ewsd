package vn.fpt.ec.actions;

import vn.fpt.ec.dao.RoleDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Roles extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8470478780171064014L;
	private int id;
	private String roleName;
	
	public String findById(int id){
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.findById(id);
		return roleName;
	}
	
	public Roles() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
