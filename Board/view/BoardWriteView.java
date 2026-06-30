package com.board.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.board.model.BoardDTO;

public class BoardWriteView extends JFrame{
	private JTextField txtTitle = new JTextField(20);
	private JTextField txtWriter = new JTextField(20);
	private JTextArea txtContent = new JTextArea(5,20);
	private JButton btnSave = new JButton("저장");
	
	public BoardWriteView() {
		setSize(300, 400);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JLabel("제목"));
		add(txtTitle);
		add(new JLabel("작성자"));
		add(txtWriter);
		add(new JLabel("내용"));
		add(new JScrollPane(txtContent));
		add(btnSave);		
	}
	public String getTitle() {
		return txtTitle.getText();
	}
	public String getContent() {
		return txtContent.getText();
	}
	public String getWriter() {
		return txtWriter.getText();
	}
	public JButton getBtnSave() {
		return btnSave;
	}
}