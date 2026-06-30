package com.board.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;
import java.util.List;

import javax.swing.JOptionPane;

import com.board.model.BoardDAO;
import com.board.model.BoardDTO;
import com.board.view.BoardDetailView;
import com.board.view.BoardListView;
import com.board.view.BoardWriteView;

public class BoardController {
	private BoardListView view;
	private BoardDAO dao;
	
	public BoardController(BoardListView view, BoardDAO dao) {
		this.view = view;
		this.dao = dao;
		
		loadBoardList();
		
		view.setVisible(true);
		view.setBtnWriteListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteView();
			}
		});
		
		view.setBtnDetailListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetailView();
			}
		});
	}
	private void loadBoardList() {
		List<BoardDTO> list = dao.selectAll();
		Object[][] data = new Object[list.size()][4];
		for(int i = 0; i < list.size(); i++) {
			BoardDTO dto = list.get(i);
			data[i][0] = dto.getBoard_id();
			data[i][1] = dto.getTitle();
			data[i][2] = dto.getWriter();
			data[i][3] = dto.getTimestamp();
		}
		view.setTableData(data);
	}
	
	private void DetailView() {
		int id = view.getSelectId();
		if (id == -1) {
			JOptionPane.showMessageDialog(view, "게시글을 선택하세요");
		} 
		else {
			BoardDTO dto = dao.selectDetail(id);
			BoardDetailView detailView = new BoardDetailView(dto);
			detailView.setVisible(true);
			detailView.getBtnDelete().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(dao.delete(id)) {
						JOptionPane.showMessageDialog(detailView, "게시글 삭제 완료");
						detailView.dispose();					
					} else {
						JOptionPane.showMessageDialog(detailView, "게시글 삭제 실패");
					}
				}
			});
			detailView.getBtnUpdate().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dto.setTitle(detailView.getTitle());
					dto.setContent(detailView.getContent());
					dto.setWriter(detailView.getWriter());
					if(dao.update(dto)) {
						JOptionPane.showMessageDialog(detailView, "게시글 수정 완료");
						detailView.dispose();
					} else {
						JOptionPane.showMessageDialog(detailView, "게시글 수정 실패");
					}
				}
			});
		}
	}
	
	private void WriteView() {
		BoardWriteView writeView = new BoardWriteView();
		writeView.setVisible(true);
		writeView.getBtnSave().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardDTO dto = new BoardDTO();
				dto.setTitle(writeView.getTitle());
				dto.setContent(writeView.getContent());
				dto.setWriter(writeView.getWriter());
				
				if(dao.insert(dto)) {
					JOptionPane.showMessageDialog(writeView, "게시글 등록 완료");
					writeView.dispose();
				} else {
					JOptionPane.showMessageDialog(writeView, "게시글 등록 실패");
				}
			}
		});
	}
}
