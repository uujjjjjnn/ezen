package com.lec.ex01_inheritance;

public class Korean extends Adam {

	@Override
	public String toString() {
		return "Korean [toString()=" + super.toString() + "]";
	}

	@Override
	void speak() {
		// super.speak(); 	// super는 Human.speak()가리킴 (Adam에 재정의한게 없어서)
		System.out.println("한국어로 말을 합니다");
	}
	
	@Override
	void move() {
		System.out.println("프로그램을 개발합니다");
	}
}
