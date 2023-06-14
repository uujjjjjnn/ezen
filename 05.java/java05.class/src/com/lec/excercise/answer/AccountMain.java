package com.lec.excercise.answer;

public class AccountMain {

	public static void main(String[] args) {
		
		Account acc = new Account();

		System.out.println(acc.MAX_BALANCE);
		System.out.println(acc.MIN_BALANCE);
		// acc.balance = 0;  // 불가
		
		acc.setBalance(2000000);
		acc.setBalance(-10);
		acc.setBalance(10);
		
		System.out.println(acc);
		System.out.println(acc.toString());
		

	}

}
