package com.lec.excercise.answer;

public class Excercise13_1 {

	public static void main(String[] args) {
		Thread1 th1 = new Thread1();
		
		th1.start();

	}
}

class Thread1 extends Thread {
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print('-');
		}
	}
}
class Thread2 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<300; i++) {
			System.out.print('-');
		}
	}
	
}