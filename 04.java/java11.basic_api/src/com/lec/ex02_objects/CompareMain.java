package com.lec.ex02_objects;

import java.util.Comparator;
import java.util.Objects;

/*
 	Objects 클래스
 	
 	Object클래스와 유사한 이름을 가진 java.util.Objects클래스는 객체의 비교, 해시코드 생성, null 여부, 객체문자열의 리턴 등의 연산을
 	수행하는 static메서드로 구성된 Object의 유닐리티 클래스이다.
 	
 	1. 객체비교 (compare(T a, T b, Comparator<T> c))
 	
 		Objects.compare()메서드는 2개의 객체를 비교해서 int값(-1, 0, 1)을 리턴한다. (-1:작다, 0:같다, 1:크다)
 		java.util.Compare<T>는 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(a, b)메서드가 정의되어 있다.
 	
 	
 */
public class CompareMain {

	public static void main(String[] args) {
		Student s1 = new Student(1);
		Student s2 = new Student(1);
		Student s3 = new Student(2);
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println("비교결과 = " + result);
		System.out.println("비교결과 = " + Objects.compare(s1, s3, new StudentComparator()));
		System.out.println("비교결과 = " + Objects.compare(s3, s1, new StudentComparator()));
		
	}
	
	static class Student {
		int sno;
		
		public Student(int sno) {
			this.sno = sno;
		}
	} 

	static class StudentComparator implements Comparator<Student> { // Student타입만 들어올 수 있음

		@Override
		public int compare(Student a, Student b) {
//			if(a.sno < b.sno) return -1;
//			else if(a.sno == b.sno) return 0;
//			else return 1;
			return Integer.compare(a.sno, b.sno);
		}
		
	}
}
