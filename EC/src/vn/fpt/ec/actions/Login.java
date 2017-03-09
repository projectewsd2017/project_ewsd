package vn.fpt.ec.actions;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import vn.fpt.ec.dao.LoginDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842810348962024259L;
	private String username;
	private String pass;
	private int roleId;
	SessionMap<String, String> sessionmap;

	public String login() {
		return SUCCESS;
	}

	public String loginUser() {
		Login login = new Login();
		LoginDAO loginDAO = new LoginDAO();
		if (!username.isEmpty() && username != null && !pass.isEmpty() && pass != null) {
			login = loginDAO.login(username, pass);
			if (login.getRoleId() == 1) {
				return "ADMIN";
			} else if (login.getRoleId() == 2) {
				return "EC";
			} else if (login.getRoleId() == 3) {
				return "STUDENT";
			} else {
				return "ERROR";
			}
		}else{
			return "LOGINERROR";
		}
		
	}

	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String username, String pass, int roleId) {
		super();
		this.username = username;
		this.pass = pass;
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public SessionMap<String, String> getSessionmap() {
		return sessionmap;
	}

	public void setSession(Map map) {
		sessionmap = (SessionMap) map;
		sessionmap.put("login", "true");
	}
}
