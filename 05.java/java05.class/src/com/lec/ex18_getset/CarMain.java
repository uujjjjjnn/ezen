package com.lec.ex18_getset;

public class CarMain {

	public static void main(String[] args) {

		Car car = new Car();
		
		// car객체의 필드(속성)는 캡슐화(은닉화, private)
		// car.speed = 10000;
		// car.stop = true;

		car.setSpeed(20);
		System.out.println(car);
		
		car.setSpeed(10000);
		System.out.println(car);
		
		car.isStop();
		
		car.setSpeed(10);
		car.isStop();
		System.out.println();
		
		// car의 객체의 속성이 은닉화되었기 때문에 접근불가
		// System.out.println(car.speed);
		car.setSpeed(90);
		int speed = car.getSpeed();
		System.out.println("현재 운행속도는 " + speed + "km/h 입니다");
		
		car.isStop(true);
		if(!car.getStop()) {
			System.out.println("현재 " + speed + "km/h 속도로 운행중 입니다");
		} else {
			System.out.println("현재 운행 정지");
		}
	}

}
