package com.lec.ex01_interface;

public interface Animal {

	String KIND = "동물"; 	// 상수는 초기화 되어야만함. public static final String KIND = "동물"; 과 동일
	void sound(); 			// public abstract void sound();
	
	default void breath() { // 실행블럭을 가진 메서드
		System.out.println("숨을 쉽니다");
	};
}
