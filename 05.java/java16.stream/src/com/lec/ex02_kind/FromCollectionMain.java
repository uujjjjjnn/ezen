package com.lec.ex02_kind;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 	Stream의 종류
 	
 	Java8부터 새로 추가된 java.util.stream패키지는 stream API들이 포함되어 있다. stream의 종류는 BaseStream과 이 스트림을 구현한 Stream, IntStream, LongStream, DoubleStream이 있다.
 	
 	BaseStream에는 모든 스트림에서 사용할 수 있는 공통메서드가 저으이되어 있을 뿐 코드에서 직접 사용되지는 않는다.
 	하위 스트림이 직접적으로 사용되는 스트림인데 Stream은 객체의 요소를 처리하는 스트림이고, 
 	IntStream, LongStream, DoubleStream은 각각 기본타입인 int, long, double요소를 처리하는 스트림이다.
 	
 	Stream을 얻는 방법은
 	
 	1. Collection으로부터 Stream을 얻기 
 	2. Arrays로부터 Stream을 얻기
 	3. 숫자범위로부터 Stream을 얻기
 	4. 파일로부터 Stream을 얻기
 	5. 디렉토리로부터 Stream을 얻기
 	
 	
 */
public class FromCollectionMain {

	public static void main(String[] args) {
		
		// 1. Collection으로부터 Stream을 얻기
		List<Student> list = Arrays.asList(
					new Student("홍길동", 10),
					new Student("홍길동", 20),
					new Student("홍길동", 30)
				);
		
		Stream<Student> stream = list.stream();
		stream.forEach(s -> System.out.println(s.toString()));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(s -> System.out.println(s));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(System.out :: println);
		// System.out.println(s);
		// System.out.println(s.toString());
		
	}

}

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return this.name +", " + this.score;
	}


}