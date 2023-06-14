package com.lec.excercise.answer;

import java.util.Arrays;
import java.util.stream.Stream;

public class Excercise14_6 {

	public static void main(String[] args) {
		
		String[] strArr = {"aaa", "bb", "c", "dddd"};
		
		Stream<String> arr = Arrays.stream(strArr);
		int max = arr.mapToInt(String::length).max().getAsInt();
		System.out.println(max);
		

	}

}
