package com.lec.robot.v7_생산자;

import com.lec.robot.v4_인터페이스.inter.InterFly;
import com.lec.robot.v4_인터페이스.inter.InterMissile;
import com.lec.robot.v4_인터페이스.inter.InterSword;

public class StandardRobot extends Robot {

	public StandardRobot(String name, int qty, InterFly fly, InterMissile missile, InterSword sword) {
		super(name, qty, fly, missile, sword);
	}

}
