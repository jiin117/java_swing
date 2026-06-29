package com.sms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sms.model.StudentDTO;

public class StudentEditView extends JDialog{	
	private JButton btnEdit = new JButton("수정");
	private StudentDTO student;
	private JPasswordField txtPassword;
	private JTextField txtPhone;
	
	
	public StudentEditView(JFrame parent, StudentDTO student) {
		super(parent,"학생 정보 수정", true);
		this.student = student;
		setSize(350, 200);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());

		JPanel contentP = new JPanel(new GridLayout(3, 2, 5, 5));	
		
		contentP.add(new JLabel("학번"));
		contentP.add(new JLabel(student.getStudent_id()));
		contentP.add(new JLabel("비밀번호"));
		txtPassword = new JPasswordField(student.getPassword());
		contentP.add(txtPassword);
		contentP.add(new JLabel("연락처"));
		txtPhone = new JTextField(student.getPhone());
		contentP.add(txtPhone);
		add(contentP, BorderLayout.CENTER);
		add(btnEdit, BorderLayout.SOUTH);
	}


	public void addSaveButtonListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	public StudentDTO getUpdateData() {
		return new StudentDTO(
				student.getStudent_id(), 
				new String(txtPassword.getPassword()),
				student.getName(),
				student.getDept_code(),
				txtPhone.getText());
	}	
}
