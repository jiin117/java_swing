package com.board.model;

public class BoardDTO {
	private int board_id;
	private String title;
	private String content;
	private String writer;
	private String timestamp;	
	
	public BoardDTO() {
	}

	public BoardDTO(int board_id, String title, String content, String writer, String timestamp) {
		this.board_id = board_id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.timestamp = timestamp;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}	
}
