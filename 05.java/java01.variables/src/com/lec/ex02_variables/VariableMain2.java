package com.lec.ex02_variables;

public class VariableMain2 {

	public static void main(String[] args) {
		
		// 1. 변수의 선언 : 선언 & 초기화
		int val1 = 10;
		int val2 = 20;
		System.out.println("val1 = " + val1);
		System.out.println("val2 = " + val2);
		System.out.println("val1 + val2 = " + val1 + val2);  // 문자열이 우선
		System.out.println("(val1 + val2) = " + (val1 + val2));
		System.out.println();
		
		// 2. 변수의 동시선언
		int a, b, c;
		int x=10, y=20, z=30;
		System.out.println("x="+ x + ", y=" + y + ", z=" + z);
		
		// int l, m, n = 40; // l, m은 초기화 되지 않음
		// System.out.println("a = " + a); //초기화 에러
		
		// int l = m = n = 40; // 문법에러
		// System.out.println("l="+ l + ", m=" + m + ", n=" + n);
		System.out.println();
		
		
		// 3. 변수선언과 변수타입
		// a. 기본타입(promitive)
		// 1) 정수 : byte(1), char(2), short(2), int(4), long(8)
		// 정수의 기본타입은 int
		// byte
		byte b1; 	// -128 ~ 127 범위의 값만 가질 수 있다.
		byte b2;
		b1 = -128;
		b2 = 127;
		System.out.println("b1=" + b1 + ", b2=" + b2);
		
		// b1 = -129; 	// -128을 벗어난 에러
		// b2 = 128; 	// byte타입이 표현할 수 있는 숫자범위를 초과한 에러
		b1 = (byte) -12312; // 정수의 기본타입은 int, int를 byte로 변환
		b2 = (byte) 12312; // (byte) int타입인 12312을 byte로 강제변환
		System.out.println("b1=" + b1 + ", b2=" + b2);
		System.out.println();
		
		// char
		char c1 = 'A'; // 한 개의 문자(내부적으로 유니코드인 값(정수))로 저장된다. char은 작은 따옴표
		char c2 = '가';
		// A는 내부적으로 65, 가는 44032의 정수(유니코드)값으로 저장된다.
		// char c3 = "A"; // ""문자열이기 때문에 에러
		// char c4 = 'AA'; // 한 개 이상의 문자를 저장불가
		char c5 = 65; 		// A
		char c6 = 44032; 	// 가
		char c7 = 97; 		// a
		char c8 = 48; 		// 0
		System.out.println("c1=" + c1 + ", c2=" + c2 + ", c5=" + c5 + ", c6=" + c6 + ", c7=" + c7 + ", c8=" + c8);
		System.out.println();
		
		// short
		short s1; // -2의 15승 ~ 2의 15승-1의 범위
		short s2;
		s1 = -32768;
		s2 = 32767;
		System.out.println("s1=" + s1 + ", s2=" + s2 );
		System.out.println();
		
		// int
		int i1 = 'A'; // int i1 = 65;와 동일
		int i2 = 'Z'; // int i2 = 90;
		int i3 = '0'; // int i3 = 48;
		int i4 = -2147483648;
		int i5 = 2147483647;
		System.out.println("i1=" + i1 + ", i2=" + i2 + ", i3=" + i3);
		
		// long
		long l1; // -2의 61승 ~ 2의 61승-1
		long l2;
		// l1 = -2147483649; // 숫자리터럴의 기본타입은 int타입
		// l2 = 2147483648; // int표현범위를 초과한 에러
		l1 = -2147483649L; // L or l로 선언
		l2 = 2147483648l; // int -> long 변환 -> l2에 대입
		System.out.println("l1=" + l1 + ", l2=" + l2);
		System.out.println();
		
		
		// 2) 실수 : float(4), double(8)
		// java에서는 정수타입의 기본형은 int이지만 실수타입의 기본형은 double타입이다.
		// 따라서 float로 선언할 경우 long타입처럼 뒤에 F or f로 선언하거나 데이터타입을 변경(형변환)해야 한다.
		
		// float
		float f1 = 1.0F;
		float f2 = 1.0f;
		System.out.println("f1=" + f1 + ", f2=" + f2);
		
		// double : 실수의 기본타입
		double d1 = 1.0D;
		double d2 = 3.14d;
		double d3 = 1.0;
		double d4 = 3.14;
		System.out.println("d1=" + d1 + ", d2=" + d2 + ", d3=" + d3 + ", d4=" + d4);
		System.out.println();
		
		// 3) 논리 : boolean(1) : true, false, 내부적으로 true=1, false=0의 정수값을 가지고 있다.
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println("bool1=" + bool1 + ", bool2=" + bool2);

		
		//  b. 참조타입(reference)
	}
}
