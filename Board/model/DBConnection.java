package com.board.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static Properties properties = new Properties();
	
	static {
		try (
			InputStream input = new FileInputStream("db.properties")){
			properties.load(input);
			Class.forName(properties.getProperty("db.driver"));
		} catch (IOException e) {
			System.out.println("db 정보 파일 읽기 오류");
			e.printStackTrace();
		} catch( ClassNotFoundException ex) {
			System.out.println("MYSQL 드라이버 오류");
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				properties.getProperty("db.url"),
				properties.getProperty("db.user"),
				properties.getProperty("db.password"));
	}
}
