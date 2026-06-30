package com.sms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sms.model.AdminDTO;
import com.sms.model.StudentDAO;
import com.sms.model.StudentDTO;
import com.sms.view.StudentEditView;
import com.sms.view.LoginView;
import com.sms.view.MainView;
import com.sms.view.ViewUtils;

public class LoginController {
	private StudentDAO studentDao;
	private LoginView	loginView;
	public LoginController(StudentDAO studentDao, LoginView loginView) {
		this.studentDao = studentDao;
		this.loginView = loginView;
		this.loginView.addLoginListener(new LoginActionListener());
	}
		
	private class LoginActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String id = loginView.getId();
			String password = loginView.getPassword();
			String role = loginView.getSelectRole();
			
			if(id.isEmpty() || password.isEmpty()) {
				ViewUtils.showMessage(loginView, "아이디와 비밀번호를 모두 입력해주세요.");
				return;
			}
			
			if(role.equals("학생")) {
				StudentDTO student = studentDao.loginStudent(id, password);
				if(student != null) {
					ViewUtils.showMessage(loginView, student.getName() + "학생님 환영합니다.");
					loginView.dispose();
					
					MainView mainView = new MainView(student.getName(), role);
					new MainController(student, mainView, "학생");
					mainView.setVisible(true);
					
				
				} else {
					ViewUtils.showMessage(loginView, "학번 또는 비밀번호를 확인하세요");
				}
			} else if(role.equals("관리자")) {
				AdminDTO admin = studentDao.loginAdmin(id, password);
				if(admin != null) {
					ViewUtils.showMessage(loginView, admin.getAdmin_name() + "관리자님 환영합니다.");
					loginView.dispose();
					
					MainView mainView = new MainView(admin.getAdmin_name(), role);
					new MainController(mainView, "관리자");
					mainView.setVisible(true);
				} else {
					ViewUtils.showMessage(loginView, "아이디 또는 비밀번호를 확인하세요.");
				}
			}
		}
	}
}
