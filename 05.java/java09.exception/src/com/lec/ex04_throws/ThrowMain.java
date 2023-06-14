package com.lec.ex04_throws;

public class ThrowMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// throw - 강제로 예외를 발생시키기
		try {
			throw new ClassNotFoundException(); // 강제로 Exception객체를 생성
			// throw new Exception();
		} catch (Exception e) {
			System.out.println("강제로 예외가 발생했습니다");
		}
	}

	
}

