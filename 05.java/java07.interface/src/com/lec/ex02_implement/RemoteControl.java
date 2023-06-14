package com.lec.ex02_implement;

public interface RemoteControl {

	int MIN_VOLUMN = 0;
	int MAX_VOLUMN = 10;
	
	void turnOn();
	void turnOff();
	void setVolumn(int volumn);
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("음소거");
		} else {
			System.out.println("음소거해제");
		}
	}
	
	static void changeBattery() {
		System.out.println("건전지를 교체합니다");
	}
}
