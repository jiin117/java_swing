package com.sms.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sms.model.StudentDTO;

public class DeptStudentView extends JDialog{
	private JComboBox<String> cbDept =  new JComboBox<String>();
	private JButton btnLoad = new JButton("조회");
	private JTable table;
	private DefaultTableModel model;
	
//	public StudentLoadView(JFrame parent, List<String> deptlist) {
//	}


	public DeptStudentView(JFrame parent, List<String> deptList) {
		super(parent, "학과별 학생 조회", true);
		setLayout(new BorderLayout());
		setSize(500, 300);
		setLocationRelativeTo(parent);
		
		JPanel northP = new JPanel();
		for(String dept : deptList)
			cbDept.addItem(dept);
		northP.add(cbDept);
		northP.add(btnLoad);
		add(northP, BorderLayout.NORTH);
		
		model = new DefaultTableModel(new String[] {"학번", "성명", "연락처"}, 0);	
		table = new JTable(model);
		add(new JScrollPane(table), BorderLayout.CENTER);
		setSize(400, 300);		
	}


	public void addSearchListener(ActionListener listener) {
		btnLoad.addActionListener(listener);
	}

	public String getSelectedDept() {
		return (String) cbDept.getSelectedItem();
	}
	
	public void setTableData(List<StudentDTO> studentByDept) {
		model.setRowCount(0);
		for(StudentDTO s: studentByDept)
			model.addRow(new Object[] { s.getStudent_id(), s.getName(), s.getPhone()});
	}
}

