package com.lec.ex01_create;

import java.awt.Toolkit;

public class BeepMain3 {

	public static void main(String[] args) throws InterruptedException {
		
		// 1. 외부클래스(Thread 상속, BeepTask2)
//		Thread thread1 = new BeepTask2();
//		thread1.start();
		
		// 2. 익명객체(Thread 클래스)
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				// 띵소리를 5번
				Toolkit toolkit = Toolkit.getDefaultToolkit(); 	// 스피커자원
				for(int i=0; i<5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(1000); // 1초간 정지
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 	
				}
			}
		};
		thread2.start();
		
		// 띵출력을 5번
		for(int i=0; i<5; i++) {
			System.out.println("띵~~");
			Thread.sleep(500); 	// 0.5초간 정지
		}

	}

}
