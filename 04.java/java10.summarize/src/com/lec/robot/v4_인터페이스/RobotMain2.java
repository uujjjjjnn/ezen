package com.lec.robot.v4_인터페이스;

import com.lec.robot.v4_인터페이스.impl.*;


public class RobotMain2 {

	public static void main(String[] args) {
		
		System.out.println("===== Robot V4.1 (인터페이스) =====");
		System.out.println();

		CheapRobot cheapRobot = new CheapRobot("Cheap", 5);
		cheapRobot.shape();
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.actionFly(new FlyNo()); 
		cheapRobot.actionMissile(new MissileNo());
		cheapRobot.actionSword(new SwordNamu());
		System.out.println(cheapRobot.name + "Robot의 재고수량 = " + cheapRobot.qty);
		System.out.println();
		
		StandardRobot standardRobot = new StandardRobot("Stand", 10);
		standardRobot.shape();
		standardRobot.actionWalk();
		standardRobot.actionRun();
		standardRobot.actionFly(new FlyYes()); 
		standardRobot.actionMissile(new MissileNo());
		standardRobot.actionSword(new SwordLayser());
		System.out.println(standardRobot.name + "Robot의 재고수량 = " + standardRobot.qty);
		System.out.println();
		
		SuperRobot superRobot = new SuperRobot("Super", 10);
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.actionFly(new FlyYes()); 
		superRobot.actionMissile(new MissileNo());
		superRobot.actionSword(new UltraJJangSword());
		System.out.println(superRobot.name + "Robot의 재고수량 = " + superRobot.qty);
		System.out.println();
		
		
	}

}
