package com.lec.excercise.answer;

import java.io.IOException;
import java.util.Scanner;

public class Excercise09 {

	public static void main(String[] args) throws IOException {

		/*
		8. Exercise09.java : 	
			   키보드로부터 학생 수와 각 학생들의 점수를 입력받아서 최고 점수 및 평균 점수를 구하기
			   (참고: Scanner의 nextlnt() 메소드이용)

				System.out.println("---------------------------------------------");
				System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("---------------------------------------------");
				System.out.print("선택> ");	
				
				JOptionPan.showInputDialog() 이용해도 상관없음
		*/
		boolean run = true;
		int keyCode = 0;
		int[] arr = null;
		int std = 0;
		int score = 0;
		int num = 0;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			if(keyCode != 13 && keyCode != 10) {
				System.out.println("---------------------------------------------");
				System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
				System.out.println("---------------------------------------------");
				System.out.print("선택> ");
			}
			keyCode = System.in.read();
			if(keyCode == 49) {
				System.out.println("학생수를 입력하세요");
				std = sc.nextInt();
				arr = new int[std];
			} else if (keyCode == 50) {
				System.out.println("점수를 입력하세요");
				for(int i=0;i<arr.length;i++) {
					arr[i] = sc.nextInt();
				}
			} else if (keyCode == 51) {
				System.out.println("점수리스트입니다");
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i] + ", ");
				}
				System.out.println();
			} else if (keyCode == 52) {
				for(int i=0;i<arr.length;i++) {
					sum += arr[i];
					if(arr[i] > num) {
						num = arr[i];
					}
				}	
				System.out.println("최고점수는 " + num + "이고, 평균점수는 " + sum/(float)(arr.length) + "입니다");
				
			} else if (keyCode == 53) {
				run = false;
			}
		}	System.out.println("프로그램 종료합니다");
		


	}

}
