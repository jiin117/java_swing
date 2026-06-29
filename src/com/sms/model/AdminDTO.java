package com.sms.model;

public class AdminDTO {
	String admin_id;
	String password;
	String admin_name;
	public AdminDTO(String admin_id, String password, String admin_name) {
		this.admin_id = admin_id;
		this.password = password;
		this.admin_name = admin_name;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}	
}