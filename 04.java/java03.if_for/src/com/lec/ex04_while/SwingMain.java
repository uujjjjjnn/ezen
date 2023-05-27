package com.lec.ex04_while;

import javax.swing.JOptionPane;

public class SwingMain {

	public static void main(String[] args) {
		// 숫자 맞추기 게임
		// Java에서 swing은 GUI환경으로 인터페이스를 만들어 준다.
		String data = JOptionPane.showInputDialog("숫자를 입력하세요");
		// System.out.println("입력된 값 = " + data);
		int answer = 77;
		int inputNumber = 0;
		
		inputNumber = Integer.parseInt(data);
		
		if(inputNumber == answer) {
			System.out.println("축하합니다! 정답입니다!");
		} else {
			System.out.println("정답이 아닙니다! 다음 기회에 도전하세요!");
		}
		
		System.out.println(JOptionPane.showConfirmDialog(null, data)); // Yes=0, No=1, Cancel=2
	}

}
