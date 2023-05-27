package com.lec.exercise.answer.회원관리;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.lec.ex02_board.ConnectionFactory;

public class MemberDAOImpl implements MemberDAOService {

	private MemberVO inputMember() {
		MemberVO member = new MemberVO();
		
		String member_id = JOptionPane.showInputDialog("아이디를 입력하세요");
		String member_pw = JOptionPane.showInputDialog("비밀번호를 입력하세요");
		String member_name = JOptionPane.showInputDialog("이름을 입력하세요");
		String m_age = JOptionPane.showInputDialog("나이를 입력하세요");
		int member_age = Integer.parseInt(m_age);
		String member_gender = JOptionPane.showInputDialog("성별을 입력하세요");
		String member_email = JOptionPane.showInputDialog("이메일을 입력하세요");
		
		member.setMember_id(member_id);
		member.setMember_pw(member_pw);
		member.setMember_name(member_name);
		member.setMember_age(member_age);
		member.setMember_gender(member_gender);
		member.setMember_email(member_email);
		return member;
	}
	
	
	@Override
	public void createMember() {
		MemberVO member = inputMember();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		String sql = cf.getInsert();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getMember_pw());
			pstmt.setString(3, member.getMember_name());
			pstmt.setInt(4, member.getMember_age());
			pstmt.setString(5, member.getMember_gender());
			pstmt.setString(6, member.getMember_email());
			
			while(true) {
			if(member.getMember_email() != null || !member.getMember_email().equals("")) {
				 String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
				  Pattern p = Pattern.compile(regex);
				  Matcher m = p.matcher(member.getMember_email());
				  if(!m.matches()) System.out.println("이메일을 다시 입력해주세요");
			} 
			 break;}
			int row = pstmt.executeUpdate();
			System.out.println(row + "건이 성공적으로 등록되었습니다");
			
		} catch (Exception e) {
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
	public ArrayList<MemberVO> listMember() {
		ArrayList<MemberVO> memberList = new ArrayList<>();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member = new MemberVO();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_age(rs.getInt("member_age"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
				memberList.add(member);
			}
			
		} catch (Exception e) {
			System.out.println("회원목록 조회 실패");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
			}
		}
		return memberList;
	}

	@Override
	public MemberVO viewMemer(String member_id) {
		MemberVO member = new MemberVO();
		
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = cf.getSelect()
					+ " where member_id =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pw(rs.getString("member_pw"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_age(rs.getInt("member_age"));
				member.setMember_gender(rs.getString("member_gender"));
				member.setMember_email(rs.getString("member_email"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return member;
	}

	@Override
	public void updateMember(String member_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(String member_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<MemberVO> findByNameMember(String member_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<MemberVO> findByEmailMember(String member_email) {
		// TODO Auto-generated method stub
		return null;
	}

}
