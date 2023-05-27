package com.lec.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.lec.JDBCConnector;

public class BoardList1 {

	public ArrayList<Board1> getBoardList1() {
		
		ArrayList<Board1> boards = new ArrayList<>();
		Connection conn = JDBCConnector.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from board order by bno desc");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Board1 board = new Board1();
				board.setBno(rs.getInt("bno"));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setReadcnt(rs.getInt("readcnt"));
				board.setCrtdate(rs.getString("crtdate"));
				boards.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL실행 실패");
			e.printStackTrace();
		}
		
		return boards;
	}
}
