package com.lec.ex10_default_extends;
/*
 	디폴트메서드가 있는 인터페이스의 상속과 구현
 	
 	인터페이스간에도 상속이 있기 때문에 부모인터페이스에 디폴트메서드가 정의되어 있는 경우 자식인터페이스에서 디폴트메서드를 사용하는 방법은 3가지가 있다.
 	
 	1. 디폴트메서드를 단순히 상속만 받는 경우
 	2. 디폴트메서드를 재정의하는 경우
 	3. 디폴트메서드를 추상메서드로 재선언하는 경우
 	
 */
public class DefaultExtendsMain {

	public static void main(String[] args) {

		// 1. 디폴트메서드 상속
		ChildInterface1 ci1 = new ChildInterface1() {
			public void method1() { /* 실행 블럭 */ }
			public void method3() { /* 실행 블럭 */ }
		};
		ci1.method1(); // parent 추상메서드
		ci1.method2(); // parent 디폴트메서드
		ci1.method3(); // child1 추상메서드
		
		// 2. 디폴트메서드 재정의
		ChildInterface2 ci2 = new ChildInterface2() {
			public void method1() { /* 실행 블럭 */ }
			public void method3() { /* 실행 블럭 */ }
		};
		ci2.method1(); // parent 추상메서드
		ci2.method2(); // parent 재정의된 디폴트메서드
		ci2.method3(); // child2 추상메서드
		
		// 3. 디폴트메서드를 추상메서드로 재선언
		ChildInterface3 ci3 = new ChildInterface3() {
			public void method1() { /* 실행 블럭 */ }
			public void method3() { /* 실행 블럭 */ }
			public void method2() { /* 실행 블럭 */ }
		};
		ci3.method1(); // parent 추상메서드
		ci3.method2(); // child3 parent.method2(디폴트메서드)를 추상메서드로 재선언
		ci3.method3(); // child3 추상메서드
	}

}
