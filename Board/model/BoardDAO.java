package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public boolean delete(int board_id) {
		String query = "DELETE FROM board WHERE board_id = ?;";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, board_id);
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(BoardDTO board) {
		String query = "UPDATE board SET title = ?, content = ?, writer = ? WHERE board_id = ?;";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			pstmt.setInt(4, board.getBoard_id());
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insert(BoardDTO board) {
		String query = "INSERT INTO board (title, content, writer) VALUES (?, ?, ?);";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			return pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String query = "SELECT * FROM board;";
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BoardDTO(rs.getInt("board_id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer"),
						rs.getString("created_at")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public BoardDTO selectDetail(int id) {
		BoardDTO board = null;
		String query = "SELECT * FROM board WHERE board_id = ?";
		try {
			Connection conn = DBConnection.getConnection();		
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new BoardDTO(rs.getInt("board_id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getString("writer"),
						rs.getString("created_at"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return board;
	}
}
