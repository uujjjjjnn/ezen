package com.lec.ex03_multi;

import com.lec.ex02_implement.RemoteControl;

public class SmartTelevisionMain {

	public static void main(String[] args) {
		
		RemoteControl rc = new SmartTelevision();
		rc.turnOn();
		rc.setVolumn(5);
		rc.setMute(true);
		rc.turnOff();
		// rc.search(); // 자식객체에서 부모객체로 자동형변환이 되어 search()메서드는 사용불가
		System.out.println();
		
		SmartTelevision stv = new SmartTelevision();
		Searchable rc1 = stv; // 자동형변환
		// rc1.turnOn();
		// rc1.setVolumn(5);
		// rc1.setMute(true);
		// rc1.turnOff();
		rc1.search("www.google.com");
		
		
	}

}
