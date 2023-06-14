package com.lec.exercise.answer.회원관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class MemberMenu {

	private double ver;
	
	public MemberMenu(double ver) {
		this.ver = ver;
	}
	
	public void MemberMainMenu() {
		
		MemberDAOImpl mdao = MemberFactory.getInstance();
		
		while(true) {
			int menuNo = mainMenu();
			
			switch(menuNo) {
			case 1: makeMember(mdao); break;
			case 2: listMember(mdao); break;
			case 3: viewMemer(mdao); break;
			case 4: updateMember(mdao); break;
			case 5: deleteMember(mdao); break;
			case 6: findByNameMember(mdao); break;
			case 7: findByEmailMember(mdao); break;
			case 0: System.out.println("프로그램 종료"); System.exit(0);
			
			}
			
		}
		
	}

	private void makeMember(MemberDAOImpl mdao) {
		mdao.createMember();
	}

	private void findByEmailMember(MemberDAOImpl mdao) {
		// TODO Auto-generated method stub
		
	}

	private void findByNameMember(MemberDAOImpl mdao) {
		// TODO Auto-generated method stub
		
	}

	private void deleteMember(MemberDAOImpl mdao) {
		// TODO Auto-generated method stub
		
	}

	private void updateMember(MemberDAOImpl mdao) {
		// TODO Auto-generated method stub
		
	}

	private void viewMemer(MemberDAOImpl mdao) {
		String member_id = JOptionPane.showInputDialog("조회할 아이디를 입력하세요");
		
		if((member_id==null)||(member_id.equals(""))) {
			return;
		} else {
			MemberVO member = mdao.viewMemer(member_id);
			System.out.println("=================================================================================================");
			System.out.println("아이디\t\t비밀번호\t이름\t\t나이\t\t성별\t\t이메일");
			System.out.println("=================================================================================================");
		}
		
//		
	}

	private void listMember(MemberDAOImpl mdao) {
		ArrayList<MemberVO> members = mdao.listMember();
		System.out.println("=================================================================================================");
		System.out.println("아이디\t\t비밀번호\t이름\t\t나이\t\t성별\t\t이메일");
		System.out.println("=================================================================================================");
		
		for(MemberVO member:members) {
			System.out.println(member.toString());
		}
		System.out.println("\n---------------- 회원 목록 출력 종료 ----------------");
		
	}

	private void createMember(MemberDAOImpl mdao) {
		mdao.createMember();
		
	}

	public int mainMenu() {
		
		String menuNo = JOptionPane.showInputDialog(
		"***** 회원정보 프로그램 V" + ver + " *****\n\n" +
		"1. 신규회원등록\n" +
		"2. 전체회원조회\n" +
		"3. 회원상세조회\n" +
		"4. 회원정보수정\n" +
		"5. 회원정보삭제\n" +
		"6. 이름으로 검색\n" +
		"7. email로 검색\n" +
		"0. 종료\n\n" +
		"처리할 작업번호를 입력하세요"
		);
		if(menuNo == null || menuNo.equals("")) {
			return 0;
		} else {
			return Integer.parseInt(menuNo);
		}
		
	}

	
	
	
	
	
}
