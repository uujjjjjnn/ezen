package com.lec.ex07_instanceof;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스를 운행합니다");
	}

	public void checkFare() {
		System.out.println("버스요금을 확인합니다");
	}
}
