package com.lec.ex09_default_method;

public interface MyInterface {
	void method1();
	
	default void method2() {
		System.out.println("1년뒤에 새로운 공통기능이 추가되었습니다");
	}
	
	default void method3() {
		System.out.println("2년뒤에 새로운 공통기능이 추가되었습니다");
	}
}
