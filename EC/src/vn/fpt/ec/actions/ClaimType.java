package vn.fpt.ec.actions;

import com.opensymphony.xwork2.ActionSupport;

public class ClaimType extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3646075181611906596L;
	private int id;
	private String claimName;
	private String description;
	public ClaimType(){
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
	
	

}
