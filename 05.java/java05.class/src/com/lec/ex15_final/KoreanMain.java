package com.lec.ex15_final;

public class KoreanMain {

	public static void main(String[] args) {
		
		// Korean.NATION = "미국";
		
		Korean hong = new Korean("홍길동", null);
		System.out.println(hong);
		// hong.NATION = "미국";
		hong.name = "홍길상";
		// hong.ssn = "901118-123456789";
		System.out.println(hong);
		System.out.println(hong.ssn);
		
		

	}

}
