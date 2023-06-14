package com.lec.excercise.answer;

public class ShopServiceExample {

	public static void main(String[] args) {
		
		ShopService s1 = ShopService.getInstance();
		ShopService s2 = ShopService.getInstance();
		ShopService s3 = ShopService.getInstance();

		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
	}

}
