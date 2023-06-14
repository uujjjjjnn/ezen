package com.lec.excercise.answer;

public class Excercise04 {

	public static void main(String[] args) {
//		 4. Exercise04.java : 
//			    while문과 Math.random()메서드를 이용해서 두개의 주사위를 던졌을 때 나오는 눈을 
//			    (눈1, 눈2)형태로 출력하고 눈의 합이 5가아니면 계속 주사위를 던지고 눈의 합이 5이면
//			    실행을 멈추는 코드를 작성 (눈의 합이 5가되는 조합은 (1,4) (4,1) (2,3) (3,2)
		
		
		while(true) {
			int num1 = (int) (Math.random()*6 +1);
			int num2 = (int) (Math.random()*6 +1);
			System.out.println("num1 = " + num1 + ", num2 = " + num2); 
			
			if(num1 + num2 == 5) break;
			} System.out.println("num1과 num2의 합이 5가되어 종료합니다");
		}
		
	}


