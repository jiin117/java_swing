package com.sms.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import com.sms.model.DeptDAO;
import com.sms.model.DeptDTO;
import com.sms.model.StudentDAO;
import com.sms.model.StudentDTO;
import com.sms.view.StudentEditView;
import com.sms.view.LoginView;
import com.sms.view.MainView;
import com.sms.view.DeptRegisterView;
import com.sms.view.DeptStudentView;
import com.sms.view.StudentRegisterView;
import com.sms.view.ViewUtils;

public class MainController {
	private StudentDTO currentStudent;
	private MainView mainView;
	private String userRole;
	
	//관리자 로그인시 사용
	public MainController(MainView mainView, String userRole) {
		this.mainView = mainView;
		this.userRole = userRole;
		
		this.mainView.addMenuListener(new MenuActionListener());
	}
	
	//학생 로그인 시 사용
	public MainController(StudentDTO currentStudent, MainView mainView, String userRole) {
		this.currentStudent = currentStudent;
		this.mainView = mainView;
		this.userRole = userRole;
		
		this.mainView.addMenuListener(new MenuActionListener());
	}
	
	public class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == mainView.getBtnLogout()) {
				LogOut();
			} else if (e.getSource() == mainView.getBtnEditInfo()) {
				EditInfo();
			} else if (e.getSource() == mainView.getBtnRegisterStudent()) {
				RegisterStudent();
			} else if (e.getSource() == mainView.getBtnStudentDept()) {
				SearchDept();
			} else if (e.getSource() == mainView.getBtnRegisterDept()) {
				RegisterDept();
			}
		}
	}
	
	private void RegisterDept() {
		DeptDAO dao = new DeptDAO();
		DeptRegisterView view = new DeptRegisterView(mainView);
		view.addRegisterListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = view.getData();
				DeptDTO registerDept = new DeptDTO(data[0], data[1]);
				if(dao.insertDept(registerDept) == true)
					ViewUtils.showMessage(view, "등록 완료");
				else
					ViewUtils.showMessage(view, "등록 실패");
			}
		});
		view.setVisible(true);
	}

	
	private void SearchDept() {
		StudentDAO dao = new StudentDAO();		
		DeptStudentView view = new DeptStudentView(mainView, dao.getDeptList());
		view.addSearchListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String deptName = view.getSelectedDept();
				view.setTableData(dao.getStudentByDept(deptName));
			}
		});
		view.setVisible(true);
	}
	
	private void RegisterStudent() {
		StudentDAO dao = new StudentDAO();
		StudentRegisterView view = new StudentRegisterView(mainView, dao.getDeptList());
		view.addRegisterListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] data = view.getData();
				StudentDTO registerStudent = new StudentDTO(
						data[0], data[1], data[2], data[3], data[4]);
				if(dao.insertStudent(registerStudent) == true) {
					ViewUtils.showMessage(view, "등록 완료");
					view.dispose();
				}else {
					ViewUtils.showMessage(view, "등록 실패");
				}
			}
		});
		view.setVisible(true);
	}
	
	private void EditInfo() {
		StudentEditView view = new StudentEditView(mainView, currentStudent);
		view.addSaveButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDTO updateData = view.getUpdateData();
				StudentDAO studentDAO = new StudentDAO();
				if(studentDAO.updateStudent(updateData) == true) {
					ViewUtils.showMessage(view, "수정 완료");
					view.dispose();			
				}else {
					ViewUtils.showMessage(view, "수정 실패");
				}
			}
		});
		view.setVisible(true);
	}
	
	private void LogOut() {
		if(JOptionPane.showConfirmDialog(mainView, "로그아웃 하시겠습니까?", "로그아웃", 
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			mainView.dispose();
			StudentDAO studentDAO = new StudentDAO();
			LoginView loginView = new LoginView();
			new LoginController(studentDAO, loginView);
			loginView.setVisible(true);
		}
	}
}