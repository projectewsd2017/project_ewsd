package vn.fpt.ec.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Roles extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8470478780171064014L;
	private int id;
	private String roleName;
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
