package com.lec.ex06_casting;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스를 운전합니다");
	}
	
	public void checkFare() {
		System.out.println("버스 요금을 확인합니다");
	}

}
