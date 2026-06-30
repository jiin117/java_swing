package com.board.main;

import com.board.controller.BoardController;
import com.board.model.BoardDAO;
import com.board.view.BoardListView;

public class Main {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardListView view = new BoardListView();
		new BoardController(view, dao);
	}
}