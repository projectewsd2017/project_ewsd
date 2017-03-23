package vn.fpt.ec.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Faculties extends ActionSupport {
	private int id;
	private String facutlyName;

	public Faculties() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacutlyName() {
		return facutlyName;
	}

	public void setFacutlyName(String facutlyName) {
		this.facutlyName = facutlyName;
	}

}
