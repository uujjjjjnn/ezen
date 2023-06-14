package com.lec.robot.v1_기본;

public class RobotMain {

	public static void main(String[] args) {

		System.out.println("===== Robot V1.0 (기본) =====");
		System.out.println();
		
		CheapRobot cheapRobot = new CheapRobot(10);
		cheapRobot.shape();
		cheapRobot.actionWalk();
		cheapRobot.actionRun();
		cheapRobot.actionFly();
		cheapRobot.actionMissile();
		cheapRobot.actionSword();
		System.out.println("CheapRobot의 재고수량 = " + cheapRobot.qty);
		System.out.println();
		
		
		StandardRobot standartRobot = new StandardRobot(10);
		standartRobot.shape();
		standartRobot.actionWalk();
		standartRobot.actionRun();
		standartRobot.actionFly();
		standartRobot.actoinMissile();
		standartRobot.actionSword();
		System.out.println("StandartRobot의 재고수량 = " + standartRobot.qty);
		System.out.println();
		
		
		SuperRobot superRobot = new SuperRobot(10);
		superRobot.shape();
		superRobot.actionWalk();
		superRobot.actionRun();
		superRobot.actionFly();
		superRobot.actoinMissile();
		superRobot.actionSword();
		System.out.println("SuperRobot의 재고수량 = " + superRobot.qty);
		System.out.println();
	}

}
