package com.lec.ex07_polymorphism.pkg2;

public class DriverMain {

	public static void main(String[] args) {
		
		Driver hong = new Driver();
		hong.drive(new Vehicle());
		hong.drive(new Bus());
		hong.drive(new Taxi());
		hong.drive(new BiCycle());
		hong.drive(new 오토바이());
		hong.drive(new 비행기());

	}

}

class BiCycle extends Vehicle {
	@Override
	void run() {
		System.out.println("자전거를 탑니다");
	}
}

class 오토바이 extends Vehicle {
	@Override
	void run() {
		System.out.println("오토바이를 탑니다");
	}
}

class 비행기 extends Vehicle {
	@Override
	void run() {
		System.out.println("비행기를 탑니다");
	}
}

