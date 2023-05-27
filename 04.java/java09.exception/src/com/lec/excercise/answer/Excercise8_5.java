package com.lec.excercise.answer;

public class Excercise8_5 {

	// 8-5. 실행결과를 적으시오
	// 1
	// 3
	// 5
	// 1
	// 2
	// 5
	// 6
	
	
	static void method(boolean b) {
		try {
			System.out.println(1);
			if(b) throw new ArithmeticException();
			System.out.println(2);
		} catch (RuntimeException r) {
			System.out.println(3);
			return;
		} catch(Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
	}
	public static void main(String[] args) {
		method(true);
		method(false);
	}
	
}
