package com.lec.ex01_inheritance;

public class Human {

	String name;
	String gender;
	int age;

// 숨겨있음
//	public Human() {
//		super();
//	}
	
	void speak() {
		System.out.println("말을 한다");
	}
	void eat() {
		System.out.println("음식을 먹는다");
	}
	void move() {
		System.out.println("움직인다");
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}
