package com.lec.ex02_try_catch;

public class TryCatchMain1 {

	public static void main(String[] args) {
		
		// 1. 일반예외
		// Class.forName()메서드는 해당클래스를 객체로 반환해주는 기능
		// 즉, new객체생성연산자와 동일한 기능을 한다.
		try {
			Class _class = Class.forName("java.lang.String");
			System.out.println("클래스를 찾았습니다");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스를 찾지 못햇습니다");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		System.out.println("아주 중요한 로직을 처리합니다");
	}

}
