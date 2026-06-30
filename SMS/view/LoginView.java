package com.sms.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LoginView extends JFrame{
	private JTextField txtId = new JTextField(15);
	private JPasswordField txtPassword = new JPasswordField();
	private ButtonGroup roleGroup = new ButtonGroup();
	private JRadioButton rbStudent = new JRadioButton("학생");
	private JRadioButton rbAdmin = new JRadioButton("관리자");
	private JButton btnLogin = new JButton("로그인");
	
	public LoginView() {
		setTitle("학생 관리 시스템 - 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setLocationRelativeTo(null); //프레임 중앙 표시
		setLayout(new BorderLayout());
		
		JLabel lblTitle = new JLabel("학생 관리 시스템", JLabel.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		add(lblTitle, BorderLayout.NORTH);
		
		JPanel contentP = new JPanel(new GridLayout(3, 2, 5, 5));
		
		roleGroup.add(rbStudent);
		roleGroup.add(rbAdmin);
		contentP.add(rbStudent);
		contentP.add(rbAdmin);
		contentP.add(new JLabel("학번(아이디)"));
		contentP.add(txtId);
		contentP.add(new JLabel("비밀번호"));
		contentP.add(txtPassword);
		
		add(contentP, BorderLayout.CENTER);
		add(btnLogin, BorderLayout.SOUTH);
	}
	
	public String getId() {
		return txtId.getText().trim();
	}
	
	public String getPassword() {
		return new String(txtPassword.getPassword());
	}
	
	public String getSelectRole() {
		return rbStudent.isSelected() ? "학생": "관리자";
	}
	
	public void addLoginListener(ActionListener listener) {
		btnLogin.addActionListener(listener);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
