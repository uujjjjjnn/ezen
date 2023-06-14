package com.lec.robot.v2_상속;

public class RobotMain {

	public static void main(String[] args) {
		
		System.out.println("===== Robot V2.0 (상속) =====");
		System.out.println();

		CheapRobot cheapRobot = new CheapRobot(10);
		cheapRobot.name = "CheapRobot";
		cheapRobot.shape();
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.actionFly();
		cheapRobot.actionMissile();
		cheapRobot.actionSword();
		System.out.println(cheapRobot.name + "의 재고수량 = " + cheapRobot.qty);
		System.out.println();
		
		StandardRobot standartRobot = new StandardRobot(10);
		standartRobot.name = "StandartRobot";
		standartRobot.shape();
		standartRobot.actionWalk();
		standartRobot.actionRun();
		standartRobot.actionFly();
		standartRobot.actoinMissile();
		standartRobot.actionSword();
		System.out.println(standartRobot.name + "의 재고수량 = " + standartRobot.qty);
		System.out.println();
		
		SuperRobot superRobot = new SuperRobot(10);
		superRobot.name = "SuperRobot";
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.actionFly();
		superRobot.actoinMissile();
		superRobot.actionSword();
		System.out.println(superRobot.name + "의 재고수량 = " + superRobot.qty);
		System.out.println();
		
	}

}
