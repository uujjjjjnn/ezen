package com.lec.ex07_instanceof;

public class Taxi implements Vehicle{

	@Override
	public void run() {
		System.out.println("택시를 운행합니다");
	}

	public void checkNight() {
		System.out.println("야간할증 요금을 확인합니다");
	}
	
}
