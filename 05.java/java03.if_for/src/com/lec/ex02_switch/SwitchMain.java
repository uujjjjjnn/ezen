package com.lec.ex02_switch;

public class SwitchMain {

	public static void main(String[] args) {
		// 실습. 주사위던지기
		// switch
		
		int num = (int) (Math.random()*6 +1);
		// num = (int) ((num*6)+1);
		// System.out.println(num);
		
		switch(num) {
		case 1 :
			System.out.println("1번이 나왔습니다");
			break;
		case 2: 
			System.out.println("2번이 나왔습니다");
			break;
		case 3: 
			System.out.println("3번이 나왔습니다");
			break;
		case 4: 
			System.out.println("4번이 나왔습니다");
			break;
		case 5: 
			System.out.println("5번이 나왔습니다");
			break;
		default: 
			System.out.println("6번이 나왔습니다");
	}

}
}