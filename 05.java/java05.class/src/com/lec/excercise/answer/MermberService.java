package com.lec.excercise.answer;

public class MermberService {

	public static void main(String[] args) {
		
		MemberService ms = new MemberService();
		
		ms.login("hong","12345");
		ms.login("hong","123");
		ms.logout("hong");
		

	
		
	}

}
