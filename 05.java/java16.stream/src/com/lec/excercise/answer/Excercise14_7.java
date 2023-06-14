package com.lec.excercise.answer;

import java.util.Random;
import java.util.stream.IntStream;

public class Excercise14_7 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int start=1, end=45;
		random.ints(start, end+1).limit(6).distinct().sorted()
		.forEach(System.out::println);
		
	}

}
