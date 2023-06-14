package com.lec.ex03_compare;

public class ConditionalCompareMain {

	public static void main(String[] args) {
		// 삼항연산자 (조건식 ? true일 경우 : false일 경우)는 세 개의 피연산자를 필요로하는 연산자를 말한다.
		// 삼항연산자는 ? 앞의 조건식에 따라 콜론(:) 앞뒤의 피연산자가 선택된다고해서 조건연산식이라고 하기도 한다.
		// 사용방법은
		// 조건식 ? 값 or 표현식 : 값 or 표현식
		
		int score = 85;
		if(score>=90) {
			System.out.println("A학점입니다");
		} else {
			System.out.println("B학점입니다");
		}

		// 삼항연산식
		// (score >= 90) ? System.out.println("A학점입니다") : System.out.println("B학점입니다"); 	// 에러
		char grade = (score >= 90) ? 'A' : 'B';
		System.out.println(grade + "학점입니다");
		
	}

}
