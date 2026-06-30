package com.sms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeptRegisterView extends JDialog{
	private JTextField txtDeptCode = new JTextField();
	private JTextField txtDeptName = new JTextField();
	private JButton btnAdd = new JButton("등록");
	public DeptRegisterView(JFrame parent) {
		super(parent, "학과 정보 등록");
		setLayout(new BorderLayout());
		setSize(300, 300);
		setLocationRelativeTo(parent);
		
		JPanel contP = new JPanel(new GridLayout(2, 2, 5, 5));
		contP.add(new JLabel("학과 코드"));
		contP.add(txtDeptCode);
		contP.add(new JLabel("학과명"));
		contP.add(txtDeptName);
		
		add(contP, BorderLayout.CENTER);
		add(btnAdd, BorderLayout.SOUTH);		
	}
	public void addRegisterListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}
	public String[] getData() {
		return new String[] {txtDeptCode.getText(), txtDeptName.getText()};
	}
}
