package com.lec.ex03_system;

public class TimeMain {

	public static void main(String[] args) {
		// 1~1000000까지의 합을 구하는데 소요시간?
		// long start = System.nanoTime();
		long start = System.currentTimeMillis();
		
		int sum = 0;
		for(int i=1; i<=1000000; i++) {
			sum += i;
		}
		
		
		// long end = System.nanoTime();
		long end = System.currentTimeMillis();

		System.out.println("1~1000000까지 합 = " + sum);
		System.out.println("백만까지 합을 구하는데 소요시간 = " + (end-start + "ms"));
	}

}
