package com.sms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sms.model.StudentDAO;

public class StudentRegisterView extends JDialog {
	private JTextField txtId = new JTextField(10);
	private JPasswordField txtPass = new JPasswordField(10);
	private JTextField txtName = new JTextField(10);
	private JComboBox<String> cbDept = new JComboBox<String>();
	private JTextField txtPhone = new JTextField(10);
	private JButton btnAdd = new JButton("등록");
	
	public StudentRegisterView(JFrame parent, List<String> deptList) {
		super(parent, "학생 정보 등록", true);
		setLayout(new BorderLayout());
		setSize(300, 300);
		setLocationRelativeTo(parent);
			
		for(String dept : deptList)
			cbDept.addItem(dept);
		
		JPanel contP = new JPanel(new GridLayout(5, 2, 5, 5));
		contP.add(new JLabel("학번:"));
		contP.add(txtId);
		contP.add(new JLabel("비밀번호:"));
		contP.add(txtPass);
		contP.add(new JLabel("성명:"));
		contP.add(txtName);
		contP.add(new JLabel("학과:"));
		contP.add(cbDept);
		contP.add(new JLabel("연락처:"));
		contP.add(txtPhone);
		
		add(contP, BorderLayout.CENTER);
		add(btnAdd, BorderLayout.SOUTH);		
	}
	
	public void addRegisterListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}

	public String[] getData() {
		return new String[] {
				txtId.getText(), 
				new String(txtPass.getPassword()),
				txtName.getText(),
				(String) cbDept.getSelectedItem(),
				txtPhone.getText()};
	}
}
