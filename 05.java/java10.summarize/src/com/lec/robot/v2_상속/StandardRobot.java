package com.lec.robot.v2_상속;

public class StandardRobot extends Robot {

	public StandardRobot(int qty) {
		super(qty);
	}
	
	public void actionFly() {System.out.println("날 수 없습니다");}
	public void actoinMissile() {System.out.println("미사일을 쏠 수 있습니다");}
	public void actionSword() {System.out.println("목검이 있습니다");}
}
