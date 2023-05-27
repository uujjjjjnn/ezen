package com.lec.robot.v8_final;

import com.lec.robot.v4_인터페이스.impl.*;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("===== Robot V8.0 (final) =====");
		System.out.println();
		
		Robot robot = null;
		
		robot = new Robot("Cheap", 5, new FlyYes(), new MissileYes(), new SwordLayser());
		robot.makeRobot();
		
		robot = new Robot("Standard", 5, new FlyYes(), new MissileNo(), new SwordLayser());
		robot.makeRobot();
		
		robot = new Robot("Super", 5, new FlyNo(), new MissileYes(), new SwordLayser());
		robot.makeRobot();
		
		System.out.println("=======================");
		
		
		// 실습
		// 1. v4에서 setter없애는 로작
		// 2. v8에서 method 다형성(makeRobot(InterFly, InterMissile, InterSword)
		
		robot = new Robot("Cheap", 10);
		robot.makeRobot(new FlyNo(), new MissileYes(), new SwordNone());
		
		robot = new Robot("Standard", 4);
		robot.makeRobot(new FlyYes(), new MissileNo(), new SwordLayser());
		
		robot = new Robot("Super", 7);
		robot.makeRobot(new FlyYes(), new MissileNo(), new UltraJJangSword());
	}

}
