package com.lec.ex18_getset;

public class Car {

	private int speed = 0;
	private boolean stop;
	
	public void setSpeed(int speed) {
		
		if(speed > 100) {
			System.out.println(speed + " [속도위반] 제한속도를 초과했습니다");
			this.speed = 100;
		} else {
			if(speed < 30) {
				System.out.println(speed + " [속도위반] 제한속도가 너무 느립니다");
				this.speed = speed;
			} else {
				this.speed = speed;
			}
		}
	}
	public void isStop() {

		if(this.speed < 30) {
			System.out.println("자동차 운행정지");
			this.stop = true;
		} else {
			System.out.println("현재속도는 " + this.speed + "km/h 입니다");
			System.out.print("정지하기에는 속도가 너무 빠릅니다.");
			System.out.println("속도를 줄여주세요!");
		}
	}
	
	public void isStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "Car [speed=" + speed + ", stop=" + stop + "]";
	}
	public int getSpeed() {
		return this.speed;
	}
	public boolean getStop() {
		return this.stop;
	}

	
	
	
}
