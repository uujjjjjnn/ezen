package com.lec.excercise.answer;

import java.util.Arrays;
import java.util.stream.Stream;

public class Excercise14_5 {

	public static void main(String[] args) {

		String[] strArr = {"aaa", "bb", "c", "dddd"};
		
		Stream<String> arr = Arrays.stream(strArr);
		int sum = arr.mapToInt(String::length).sum();
		System.out.println("sum = " +sum);
	}

}
