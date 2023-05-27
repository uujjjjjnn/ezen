package com.lec.ex01_inheritance;

public class Adam extends Human {

	@Override
	public String toString() {
		return "Adam [toString()=" + super.toString() + "]";
	}

	@Override  // 부모와 동일 내용이라 재정의는 아님
	void speak() {
		super.speak();
	}
	
	@Override
	void move() {
		System.out.println(this.name + "이 사냥을 합니다");
	}


	
}
