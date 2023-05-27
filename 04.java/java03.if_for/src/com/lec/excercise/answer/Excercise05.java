package com.lec.excercise.answer;

public class Excercise05 {

	public static void main(String[] args) {
//		 5. Exercise05.java :
//			    중첩for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x,y)형태로 출력
//			    단 x와 y는 10이하의 자연수이다.

		int x = 0;
		int y = 0;
		int result = 0;
		
		for(x=1;x<=10;x++) {
			for(y=1;y<=10;y++) {
				result = 4*x + 5*y;
				if(result == 60) {
					System.out.println("x = " + x + ", y = " + y);
				} 
			}
		}
		
	}

}
