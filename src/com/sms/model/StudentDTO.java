package com.sms.model;

public class StudentDTO {
	private String student_id;
	private String password;
	private String name;
	private String dept_code;
	private String phone;
		
	public StudentDTO(String student_id, String password, String name, String dept_code, String phone) {
		super();
		this.student_id = student_id;
		this.password = password;
		this.name = name;
		this.dept_code = dept_code;
		this.phone = phone;
	}
	
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_code() {
		return dept_code;
	}
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
}