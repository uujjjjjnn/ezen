package com.lec.ex03_class;

public class HumanMain {

	public static void main(String[] args) {

		// 메서드오버로딩
		Human kor = new Human("손흥민");
		kor.speak();
		
		Human usa = new Human("미국놈");
		usa.speak("엉어");
		
		Human chn = new Human("중국놈");
		chn.speak("광동어");
		
		kor.speak("한국어");
		
		kor.speak(30, "엉어");
		usa.speak(25, "한국어");
		kor.speak("불어", 33);
	}

}
