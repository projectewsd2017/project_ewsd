package vn.fpt.ec.actions;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import vn.fpt.ec.dao.LoginDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8842810348962024259L;
	private String username;
	private String pass;
	private int roleId;
	private int id;
	private String email;
	private SessionMap<String, Object> sessionmap;

	public String login() {
		return SUCCESS;
	}

	public String loginUser() throws ClassNotFoundException, SQLException {
		Login login = new Login();
		LoginDAO loginDAO = new LoginDAO();
		Claims claims = new Claims();
		
		login = loginDAO.loginStudent(username, pass);
		if (login.username != null) {
			sessionmap.put("login", "student");
			sessionmap.put("id", login.id);
			sessionmap.put("username", username);
			sessionmap.put("pass", pass);
			sessionmap.put("email", login.email);
			return "STUDENT";
		} else {
			login = loginDAO.loginStaff(username, pass);
			if (login.username == null) {
				return "LOGINERROR";
			} else {

				sessionmap.put("username", username);
				sessionmap.put("role", login.getRoleId());
				sessionmap.put("id", login.id);
				sessionmap.put("pass", pass);
				if (login.getRoleId() == 1) {
					sessionmap.put("login", "admin");
					claims.checkAdmin();
					claims.checkEC();
					return "ADMIN";
				} else if (login.getRoleId() == 2) {
					claims.checkAdmin();
					claims.checkEC();
					sessionmap.put("login", "ec");
					return "EC";
				}
			}
		}
		claims.checkAdmin();
		claims.checkEC();
		return "LOGINERROR";
	}

	public String logout() {
		sessionmap.invalidate();
		return "SUCCESS";
	}

	public String test() {
		return "SUCCESS";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SessionMap<String, Object> getSessionmap() {
		return sessionmap;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSession(Map map) {
		sessionmap = (SessionMap) map;
		sessionmap.put("login", "true");
	}

	
	
}
