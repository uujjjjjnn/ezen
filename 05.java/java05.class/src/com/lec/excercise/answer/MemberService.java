package com.lec.excercise.answer;

public class MemberService {

	String id;
	String password;
	
	
	public boolean login(String id, String password) {
		if(id == "hong"&& password =="12345" ) {
			System.out.println("id가 hong, 비번 12345인 사람");
			return true; 
		} else {
			System.out.println("id가 hong, 비번 12345이 아닌 사람");
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
	
}
