package com.lec.ex14_singleton;

import java.util.Calendar;

import com.lec.ex13_static.Calculator;

public class SingletonMain {

	public static void main(String[] args) {

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(s3.toString());
		System.out.println();
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		System.out.println(cal1.hashCode());
		System.out.println(cal2.hashCode());
	}

}
