package com.lec.ex10_default_extends;

public interface ChildInterface2 extends ParentInterface {
	void method3();
	
	default void method2() { /* 실행 블럭 - 디폴트메서드 재정의 */ }
}
