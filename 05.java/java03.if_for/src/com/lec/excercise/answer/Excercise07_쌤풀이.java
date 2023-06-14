package com.lec.excercise.answer;

import javax.swing.JOptionPane;

public class Excercise07_쌤풀이 {

	public static void main(String[] args) {

		int num = 0;
		String data;
		int money = 0;
		int balance = 0;
		do {
			data = JOptionPane.showInputDialog("1. 입금 \n2. 출금\n3. 조회\n4. 종료\n");
			
			if(data.equals("")) {
				num = 0;
			}	else {
				num = Integer.parseInt(data);
				
				if(num==1) {
					money = Integer.parseInt(JOptionPane.showInputDialog("입금할 금액을 입력하세요"));
					balance += money;
				}	else if(num==2) {
					money = Integer.parseInt(JOptionPane.showInputDialog("출금할 금액을 입력하세요"));
					balance -= money;
				}	else if(num==3) {
					System.out.println("현재 잔액 = " + balance);
				}
			}
			
			
		}	while (num !=4 );
		System.out.println("프로그램 종료");

	}

}
