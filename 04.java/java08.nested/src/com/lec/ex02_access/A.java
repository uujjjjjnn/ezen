package com.lec.ex02_access;

public class A {

	String a_field1;
	static String a_field2;
	void a_method1() {}
	static void a_method2() {}
	
	// 1. 객체중첩클래스 - 객체멤버, 정적멤버 모두 접근 가능
	class B {
		void b_method() {
			a_field1 = "접근가능";
			a_field2 = "접근가능";
			
			a_method1();
			a_method2();
		}
	}
	
	// 2. 정적중첩클래스 - 정적멤버만 접근 가능
	static class C {
		void c_method() {
			// a_field1 = "접근불가"; (X)
			a_field2 = "접근가능";
			
			// a_method1(); (X)
			a_method2();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
