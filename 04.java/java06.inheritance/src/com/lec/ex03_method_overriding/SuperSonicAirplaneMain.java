package com.lec.ex03_method_overriding;

public class SuperSonicAirplaneMain {

	public static void main(String[] args) {
		
		SuperSonicAirplane sa = new SuperSonicAirplane();
		
		sa.takeOff();
		sa.fly();
		sa.flymod = SuperSonicAirplane.SUPERSONIC; // 클래스명으로 상수 접근
		sa.fly();
		
		sa.flymod = SuperSonicAirplane.NORMAL;
		sa.fly();
		sa.land();

	}

}
