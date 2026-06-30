package com.board.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BoardListView extends JFrame{
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnWrite, btnDetail;
	public BoardListView() {
		setTitle("게시판");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		String[] colNames = {"ID", "제목", "작성자", "작성일"};
		tableModel = new DefaultTableModel(colNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(tableModel);
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel btnPanel = new JPanel();
		btnWrite = new JButton("글쓰기");
		btnDetail =  new JButton("상세보기");
		btnPanel.add(btnWrite);
		btnPanel.add(btnDetail);
		add(btnPanel, BorderLayout.SOUTH);
	}
	
	public void setBtnWriteListener(ActionListener listener) {
		btnWrite.addActionListener(listener);
	}
	
	public void setBtnDetailListener(ActionListener listener) {
		btnDetail.addActionListener(listener);
	}
	
	public void setTableData(Object[][] data) {
		tableModel.setRowCount(0);
		for(Object[] row : data) {
			tableModel.addRow(row);
		}
	}
	public int getSelectId() {
		int row = table.getSelectedRow();
		if(row == -1) {
			return -1;
		}
		int modelRow = table.convertRowIndexToModel(row);
		Object idValue = tableModel.getValueAt(modelRow, 0);
		return (int) idValue;		
	}
}