package com.lec.excercise.answer;

public class Account {

		private int balance = 0;
		int MIN_BALANCE = 0;
		int MAX_BALANCE = 1000000;
		
		public void setBalance(int balance) {
			
			if(balance < MIN_BALANCE || balance > MAX_BALANCE) {
				System.out.println("잔고 범위가 넘었습니다");
				this.balance = balance; 
			} else {
				System.out.println("현재 잔고는 " + balance + "원입니다.");
				this.balance = balance;
			}
			
		}
		

	

}
