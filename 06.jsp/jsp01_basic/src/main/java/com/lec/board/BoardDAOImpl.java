package com.lec.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class BoardDAOImpl implements BoardDAOService {

	private BoardVO inputBoard() {
		BoardVO board = new BoardVO();
		
		String subject = JOptionPane.showInputDialog("글제목을 입력하세요");
		String writer = JOptionPane.showInputDialog("작성자를 입력하세요");
		String content = JOptionPane.showInputDialog("본문글을 입력하세요");
		
		board.setSubject(subject);
		board.setWriter(writer);
		board.setContent(content);
		return board;
	}
	
	@Override
	public void createBoard() {
		BoardVO board = inputBoard();

		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		String sql = cf.getInsert();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 등록되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	@Override
	public ArrayList<BoardVO> listBoard() {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
					+ " where rownum between 1 and 10"
					+ " order by bno desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("게시글목록 조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return boardList;
	}

	@Override
	public BoardVO viewBoard(int bno) {
		BoardVO board_select = new BoardVO();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
					+ " where bno = ?";
		
		try {
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) { // 한 건이라서 if로 써도 됨
				
				board_select.setBno(rs.getInt(1));
				board_select.setSubject(rs.getString("subject"));
				board_select.setWriter(rs.getString("writer"));
				board_select.setContent(rs.getString("content"));
				
//				System.out.println(board_select);
				
			}
			
		} catch (SQLException e) {
			System.out.println("글 조회 실패");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return board_select;
	}

	@Override
	public void updateBoard(int bno) {
		
		BoardVO board = viewBoard(bno);
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		String sql = cf.getUpdate();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			String subject = JOptionPane.showInputDialog("글제목을 입력하세요");
			String content = JOptionPane.showInputDialog("본문글을 입력하세요");
	
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, bno);
			
//			pstmt.setString(1, board.getSubject());
//			pstmt.setString(2, board.getContent());
//			pstmt.setInt(3, bno);
			// writer에 대해서 setString한 부분이 없어서 입력해도 내용이 수정되지 x
			
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 수정되었습니다");
			
		} catch (Exception e) {
			System.out.println("글 수정 실패");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
		
		
	@Override
	public void deleteBoard(int bno) {
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		String sql = cf.getDelete();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 삭제되었습니다");
			
			
		} catch (Exception e) {
			System.out.println("글 삭제 실패");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
}

	@Override
	public ArrayList<BoardVO> findBySubjectBoard(String subject) {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
					+ " where subject like ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+subject+"%");
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				boardList.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("제목 검색 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	return boardList;
}

	@Override
	public ArrayList<BoardVO> findByWriterBoard(String writer) {
		ArrayList<BoardVO> boardList = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
					+ " where writer like ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+writer+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setBno(rs.getInt(1));
				board.setSubject(rs.getString("subject"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				boardList.add(board);
			}
			
		} catch (Exception e) {
			System.out.println("작성자 검색 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
	return boardList;
}
}
