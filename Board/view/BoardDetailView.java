package com.board.view;

import java.awt.FlowLayout;
import java.net.http.WebSocket.Listener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.board.model.BoardDTO;

public class BoardDetailView extends JFrame{
	private BoardDTO dto;
	private JTextField txtTitle = new JTextField(20);
	private JTextField txtWriter = new JTextField(20);
	private JTextArea txtContent = new JTextArea(5, 20);
	private JButton btnEdit = new JButton("수정");
	private JButton btnDelete = new JButton("삭제");
	private int board_id;
	
	public BoardDetailView(BoardDTO dto) {
		this.board_id = dto.getBoard_id();
		setTitle("상세보기");
		setSize(300, 400);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.dto =dto;
		
		// 데이터 채우기
		txtTitle.setText(dto.getTitle());
		txtWriter.setText(dto.getWriter());
		txtContent.setText(dto.getContent());
		
		add(new JLabel("제목"));
		add(txtTitle);
		add(new JLabel("작성자"));
		add(txtWriter);
		add(new JLabel("내용"));
		add(new JScrollPane(txtContent));
		add(btnEdit);
		add(btnDelete);
	}
	
	public int getBoard_id() {
		return board_id;		
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

	public JButton getBtnDelete() {
		return btnDelete;
	}
	
	public JButton getBtnUpdate() {
		return btnEdit;
	}
}
