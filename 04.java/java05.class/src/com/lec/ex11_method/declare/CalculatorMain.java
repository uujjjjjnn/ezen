package com.lec.ex11_method.declare;

public class CalculatorMain {

	public static void main(String[] args) {

		// Calculator 객체를 생성하고 add~div까지 구현

		Calculator cal1 = new Calculator();
		cal1.powerOn();
		int result1 = cal1.add(10, 20);
		int result2 = cal1.sub(20, 10);
		int result3 = cal1.mul(20, 10);
		double result4 = cal1.div(20, 10);
		System.out.println("add = " + result1);
		System.out.println("sub = " + result2);
		System.out.println("mul = " + result3);
		System.out.println("div = " + result4);
		cal1.powerOff();
		
		String result5 = cal1.xxx(false);
		System.out.println("xxx = " + result5);

		String result6 = cal1.yyy();
		System.out.println("yyy = " + result6);
		System.out.println();
		Calculator result7 = cal1.zzz();
		System.out.println("result7.add() = " + result7.add(50, 70));
		System.out.println("result7.div() = " + result7.sub(50, 70));
		System.out.println("result7.mul() = " + result7.mul(50, 70));
		System.out.println("result7.div() = " + result7.div(50, 70));
	}

}
