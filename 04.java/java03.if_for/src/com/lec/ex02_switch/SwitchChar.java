package com.lec.ex02_switch;

public class SwitchChar {

	public static void main(String[] args) {

		char grade = 'A';
		
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("A 학점입니다!");
			break;
		case 'B':
		case 'b':
			System.out.println("B 학점입니다!");
			break;
		default:
			System.out.println("F 학점입니다!");
		}

	}

}
