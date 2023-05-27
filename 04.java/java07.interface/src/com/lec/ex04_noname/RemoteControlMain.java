package com.lec.ex04_noname;

import com.lec.ex02_implement.RemoteControl;

public class RemoteControlMain {

	public static void main(String[] args) {
		
		// 1. 인터페이스는 객체를 생성불가
		// RemoteControl rc = new RemoteControl(); 
		
		// 2. 익명구현객체
		RemoteControl tv = new RemoteControl() {
			public void turnOn() { System.out.println("파워온");}
			public void turnOff() { System.out.println("파워오프");}
			public void setVolumn(int volumn) { System.out.println("현재 볼륨 = " + volumn);}
		};
		tv.turnOn();
		tv.setVolumn(100);
		tv.turnOff();
		// tv.changeBattery(); (X)
		RemoteControl.changeBattery();
		System.out.println();
		
		RemoteControl audio = new RemoteControl() {
			public void turnOn() { /*실행블럭*/ }
			public void turnOff() { /*실행블럭*/ }
			public void setVolumn(int volumn) { /*실행블럭*/ }
		};
		audio.turnOn();
		audio.setVolumn(100);
		audio.turnOff();
		
		// 객체 생성 없이 사용 가능
		RemoteControl radio = new RemoteControl() {
			public void turnOn() { /*실행블럭*/ }
			public void turnOff() { /*실행블럭*/ }
			public void setVolumn(int volumn) { /*실행블럭*/ }
		};
		radio.turnOn();
	}

}

