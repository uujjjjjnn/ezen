package com.lec.robot.v2_상속;

public class Robot {

	public int qty;
	public String name;

	public Robot(int qty) {
		this.qty = qty;
	}
	
	public Robot(String name) {
		this.name = name;
	}
	
	public void shape() {System.out.println(name + "입니다! 팔, 다리, 머리, 몸통이 있습니다. ");}
	public void actionWalk() {System.out.println("걸을 수 있습니다");}
	public void actionRun() {System.out.println("달릴 수 있습니다");}
	
	
}
