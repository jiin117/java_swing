package com.sms.model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeptDAO {

	public boolean insertDept(DeptDTO registerDept) {
		String query = "INSERT INTO departments VALUES (?, ?);";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, registerDept.getDept_code());
			pstmt.setString(2, registerDept.getDept_name());
			return pstmt.executeUpdate() > 0;
		} catch(Exception e) {
			System.out.println("학과 정보 등록 DB 오류");
			e.printStackTrace();
		}
		return false;
	}
}
