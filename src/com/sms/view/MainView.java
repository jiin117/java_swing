package com.sms.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainView extends JFrame{
	private JToolBar toolBar = new JToolBar();
	private JPanel contentP = new JPanel();
	private JLabel lbl = new JLabel();
	
	private JButton btnEditInfo = new JButton("학생정보수정"); //학생용
	private JButton btnStudentDept = new JButton("학생정보조회"); //관리자용
	private JButton btnRegisterDept = new JButton("학과정보추가"); //관리자용
	private JButton btnRegisterStudent = new JButton("학생정보추가"); //관리자용
	private JButton btnLogout = new JButton("로그아웃"); //누구나
	
	public MainView(String name, String role) {
		setTitle("학생 관리 시스템 - 메인("+role+")");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 450);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		loadAndSetIcon();
		
		toolBar.setFloatable(true);
		toolBar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		if(role.equals("학생")) {
			toolBar.add(btnEditInfo);
		} else {
			toolBar.add(btnStudentDept);
			toolBar.add(btnRegisterDept);
			toolBar.add(btnRegisterStudent);
		}
		toolBar.add(btnLogout);
		
		add(toolBar, BorderLayout.NORTH);
		lbl.setText(name+" "+role+ "님, 환영합니다.");
		lbl.setFont(new Font("맑은 고딕", Font.BOLD, 20));		
		contentP.add(lbl, BorderLayout.CENTER);
		add(contentP, BorderLayout.CENTER);
	}

	private void loadAndSetIcon() {
		int width = 20;
		int height = 30;
		btnEditInfo.setIcon(createIcon("images/edit.png", width, height));
		btnStudentDept.setIcon(createIcon("images/search.png", width, height));
		btnRegisterDept.setIcon(createIcon("images/dept.png", width, height));
		btnRegisterStudent.setIcon(createIcon("images/add.png", width, height));
		btnLogout.setIcon(createIcon("images/logout.png", width, height));
	}

	private Icon createIcon(String path, int width, int height) {
		ImageIcon icon = new ImageIcon(path);
		Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return new ImageIcon(img);
	}
	
	public void addMenuListener(ActionListener listener) {
		btnLogout.addActionListener(listener);
		btnEditInfo.addActionListener(listener);
		btnRegisterDept.addActionListener(listener);
		btnRegisterStudent.addActionListener(listener);
		btnStudentDept.addActionListener(listener);
	}
	
	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	public JButton getBtnEditInfo() {
		return btnEditInfo;
	}	
	
	public JButton getBtnRegisterDept() {
		return btnRegisterDept;
	}

	public JButton getBtnRegisterStudent() {
		return btnRegisterStudent;
	}

	public JButton getBtnStudentDept() {
		return btnStudentDept;
	}
}
