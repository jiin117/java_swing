package com.sms.main;

import com.sms.controller.LoginController;
import com.sms.model.StudentDAO;
import com.sms.view.LoginView;

public class Main {
	public static void main(String[] args) {
		LoginView view = new LoginView();
		StudentDAO studentDAO = new StudentDAO();
		new LoginController(studentDAO, view);
		view.setVisible(true);
	}
}