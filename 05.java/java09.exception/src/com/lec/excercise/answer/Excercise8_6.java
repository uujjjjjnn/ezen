package com.lec.excercise.answer;

import com.lec.ex01_runtime.NullPointException;

public class Excercise8_6 {

	public static void main(String[] args) {

		// 8-6. 실행결과
		
		// 3
		// 5
		
		try {
			method1();
		} catch (Exception e) {
			System.out.println(5);
		}
		
	}
	
	static void method1() {
		try {
			method2();
			System.out.println(1);
		} catch (ArithmeticException e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		}
		System.out.println(4);
	}

	static void method2() {
		throw new NullPointerException();
	}
}
