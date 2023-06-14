package com.lec.ex02_implement;

public class Audio implements RemoteControl {

	private int volumn;
	
	@Override
	public void turnOn() {
		System.out.println("Audio power on");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio power off");
	}

	@Override
	public void setVolumn(int volumn) {
		if(volumn > RemoteControl.MAX_VOLUMN) {
			this.volumn = RemoteControl.MAX_VOLUMN;
		} else if(volumn < RemoteControl.MIN_VOLUMN) {
			this.volumn = RemoteControl.MIN_VOLUMN;
		} else {
			this.volumn = volumn;
		}
		System.out.println("현재 Audio 볼륨은 " + this.volumn + "입니다");
	}
}


