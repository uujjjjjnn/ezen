package com.lec.ex01_intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LambdaMain {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student("홍길동", 95),
				new Student("홍길순", 91),
				new Student("홍길자", 98),
				new Student("홍길상", 92)
				);
		System.out.println("총 객체 수(list.size()) = " + list.size()); 	  // 외부반복자. 직렬처리
		Stream<Student> stream = list.stream();
		System.out.println("총 객체 수(stream.count()) = " + stream.count()); // 내부반복자. 병렬처리
		System.out.println();
		
		System.out.println("총 객체 수(list.size()) = " + list.size()); 	  // (O). list컬렉션의 속성이기 때문에 stream을 한 번 더 불러오지 않아도 정상처리
		System.out.println();
		
		// 에러발생 : 내부반복자이기 때문에 더이상 꺼내올 자료가 없어서 예외발생
		// stream을 다시 사용하려면 stream에 값을 다시 대입한 후에 사용할 수 있다.
		// System.out.println("총 객체 수(stream.count()) = " + stream.count()); // (X)

		stream = list.stream();
		// 학생이름과 점수를 출력
		// forEach() 최종처리메서드
		stream.forEach(s -> System.out.println(s.name));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(s -> System.out.println(s.score));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(s -> System.out.println(s.getScore()));
		System.out.println();
		
		stream = list.stream();
		stream.forEach(s -> {
			String name = s.name;
			int score = s.score;
			System.out.println(name + "의 점수 = " + score);
		});
		System.out.println();
		
		stream = list.stream();
		stream.forEach(s -> System.out.println(s.getName() + "의 점수 = " + s.getScore()));
	}

}

class Student {
	public String name;
	public int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
}