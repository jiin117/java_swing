package com.sms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public AdminDTO loginAdmin(String id, String password) {
		String query = "SELECT * FROM admins Where admin_id = ? And password = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt =  conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new AdminDTO(rs.getString("admin_id"), 
						rs.getString("password"),
						rs.getString("admin_name")
						);
			}
		} catch (SQLException e) {
			System.out.println("관리자 로그인 DB 오류");
			e.printStackTrace();
		}
		return null;
		
	}
	public StudentDTO loginStudent(String id, String password) {
		String query = "SELECT * FROM students Where student_id = ? And password = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt =  conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return new StudentDTO(rs.getString("student_id"), 
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("dept_code"), 
						rs.getString("phone"));
			}
		} catch (SQLException e) {
			System.out.println("학생 로그인 DB 오류");
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateStudent(StudentDTO updateData) {
		String query = "UPDATE students SET password = ?, phone = ? WHERE student_id = ?";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  updateData.getPassword());
			pstmt.setString(2, updateData.getPhone());
			pstmt.setString(3, updateData.getStudent_id());
			
			return pstmt.executeUpdate() > 0;
		} catch(Exception e) {
			System.out.println("학생 DB 수정 오류");
			e.printStackTrace();			
		}
		return false;
	}
	
	public List<String> getDeptList() {
		List<String> list = new ArrayList<String>();
		String query = "SELECT dept_name FROM departments";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		}catch(Exception e) {
			System.out.println("학과 DB 로드 오류");
			e.printStackTrace();			
		}
		return list;	
	}
	public boolean insertStudent(StudentDTO registerStudent) {
		String query = "INSERT INTO students "
				+ "values (?, ?, ?, "
				+ "(SELECT dept_code FROM departments WHERE dept_name = ?), ?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, registerStudent.getStudent_id());
			pstmt.setString(2, registerStudent.getPassword());
			pstmt.setString(3, registerStudent.getName());
			pstmt.setString(4, registerStudent.getDept_code());
			pstmt.setString(5, registerStudent.getPhone());
			return pstmt.executeUpdate() > 0;
		} catch(Exception e) {
			System.out.println("학생 등록 DB 오류");
			e.printStackTrace();
		}
		return false;
	}
	
	public List<StudentDTO> getStudentByDept(String deptName){
		List<StudentDTO> list = new ArrayList<StudentDTO>();
		String query = "SELECT * FROM students WHERE dept_code = "
				+ "(SELECT dept_code FROM departments WHERE dept_name = ?)";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deptName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString("student_id"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("dept_code"),
						rs.getString("phone")));				
			}		
		}catch(Exception e){
			System.out.println("학과 정보 조회 DB 오류");
			e.printStackTrace();			
		}
		return list;
	}
}
