package com.lec.excercise.answer;

import java.io.IOException;
import java.util.Scanner;

public class Excercise07 {

	public static void main(String[] args) throws IOException {
//		 7. Exercise07.java : 
//			 while문과 Scanner를 이용해서 키보드로 부터 입력된 데이터로 예금, 출금, 조회, 종료기능을
//			 제공하는 코드를 작성(예금잔액을 입출금내역을 출력)
//			 WhileKeyControlMain.java를 참조해서 자유롭게 작성
//							System.out.println("-------------------------------------");
//							System.out.println("1. 예금 | 2. 출금 | 3. 조회 | 4. 종료");
//							System.out.println("-------------------------------------");
//							
//							JOptionPan.showInputDialog() 이용해도 상관없음
		boolean run = true;
		int keyCode = 0;
		int money = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("-------------------------------------");
				System.out.println("1. 예금 | 2. 출금 | 3. 조회 | 4. 종료");
				System.out.println("-------------------------------------");
			}
				keyCode = System.in.read();
			if(keyCode == 49) {
				System.out.println("예금할 금액을 입력하세요");
				money = sc.nextInt();
				sum += money;
				System.out.println(money +"원 입금하셨습니다.");
			} else if(keyCode == 50) {
				System.out.println("출금할 금액을 입력하세요");
				money = sc.nextInt();
					if(money>sum) {
						System.out.println("출금할 잔액이 부족합니다");
					} else {
						sum -= money;
						System.out.println(money +"원 출금하셨습니다.");
					}
			} else if(keyCode == 51) {
				System.out.println("현재 잔액은 " + sum + "입니다.");
			} else if(keyCode == 52) {
				run = false;
			}
			
		} System.out.println("종료합니당");
		
	
	}

}
