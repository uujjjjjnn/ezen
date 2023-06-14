package com.lec.ex01_create;

import java.awt.Toolkit;

public class BeepMain2 {

	public static void main(String[] args) throws InterruptedException {
		
		// Thread객체를 만드는 방법
		// 1. 외부에 클래스 생성(BeepTask1, Runnable구현)
		// 띵소리를 5번
//		Runnable beepTask = new BeepTask1();
//		Thread thread1 = new Thread(beepTask);
//		thread1.start();
		
		// 2. 익명객체(Runnable 인터페이스)
//		Thread thread2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// 띵소리를 5번
//				Toolkit toolkit = Toolkit.getDefaultToolkit(); 	// 스피커자원
//				for(int i=0; i<5; i++) {
//					toolkit.beep();
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					} 	
//				}
//				
//			}
//		});
//		thread2.start();
		
		// 3. 람다식(Lambda) -> JavaScript의 화살표함수와 유사
		Thread thread3 = new Thread(() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit(); 	// 스피커자원
			for(int i=0; i<5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(1000); // 1초간 정지
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 	
			}
		});
		thread3.start();
		
		// 띵출력을 5번
		for(int i=0; i<5; i++) {
			System.out.println("띵~~");
			Thread.sleep(500); 	// 0.5초간 정지
		}
	}

}
