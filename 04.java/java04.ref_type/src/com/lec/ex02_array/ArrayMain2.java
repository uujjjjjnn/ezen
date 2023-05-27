package com.lec.ex02_array;

public class ArrayMain2 {

	public static void main(String[] args) {
		// 2. new 연산자 - 배열선언 및 초기화
		int scores[]; 	// 배열선언만 되어 있고 크기,값 등은 선언되어 있지 않음
		// System.out.println(scores[0]); 	// 에러 : 초기화하지 않음
		scores = new int[] {90, 95, 88, 89, 100, 99};
		
		int sum = 0;
		for(int score : scores) {
			sum += score;
		}
		
		System.out.println("배열요소의 합계 = " + sum);
		System.out.println("배열요소의 평균 = " + (sum / (float)(scores.length)) + "\n");
		
		
		// 3. 메서드를 이용한 배열처리
		int tot = total(scores);
		System.out.println("배열요소의 합계 = " + tot);
		System.out.println("배열요소의 평균 = " + (tot / (float)(scores.length)) + "\n");
		
		xxx();
	}

	static void xxx() {}
	
	
	public static int total(int[] scores) {
		int tot = 0;
		for(int score : scores) {
			tot += score;
		}
		return tot;
	}

}
