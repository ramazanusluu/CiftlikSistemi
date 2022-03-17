package Model;

import Helper.DBConnection;

public class User {
	
	private int id;
	private String name, tcno, username, password, phone, type;
	
	DBConnection conn = new DBConnection();
	
	public User(int id, String name, String tcno, String username, String password, String phone, String type) {
		this.id = id;
		this.name = name;
		this.tcno = tcno;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.type = type;
	}
	
	public User() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcno() {
		return tcno;
	}
	public void setTcno(String tcno) {
		this.tcno = tcno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
