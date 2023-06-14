package com.lec.ex05_compare;

import java.util.Iterator;
import java.util.TreeSet;

/*
 	Comparable vs Comparator
 	
 	TreeSet객체와 TreeMap의 키는 저장과 동시에 자동으로 오름차순으로 정렬되는데 숫자(Integer, Double..)타입일 경우에는 값을 정렬하고,
 	문자열(String)타입일 경우에는 유니코드로 정렬된다.
 	
 	TreeSet객체와 TreeMap을 정렬하기 위해서는 java.lang.Comparable인터페이스를 구현한 객체를 요구하는데 Integer, Double, String등으로
 	모두 Comparable인터페이스를 구현하고 있다.
 	
 	사용자가 정의한 클래스를 TreeSet이나 TreeMap에 저장할 경우에 Comparable을 구현하고 있지 않을 경우에 자동정렬을 할 수가 없다.
 	Comparable인터페이스는 compareTo() 추상메서드가 정의되어 있기 때문에 사용자가 정의하는 클래스도 Comparable을 구현하려면 compareTo()메서드를 재정의해야 한다.
 	
 	compareTo()메서드는 int값을 리턴하는데 객체가 동일할 경우는 0, 작을 경우는 -1, 클 경우는 1을 리턴한다. 
 	TreeSet객체와 TreeMap의 키(Key)가 Comparable을 구현하고 있지 않을 경우에는 객체를 저장하는 순간 ClassCastException예외가 발생한다.
 	
 */
public class ComparableMain {

	public static void main(String[] args) {
		
		TreeSet<Person> persons = new TreeSet<>();
		persons.add(new Person("홍길동", 1000));
		persons.add(new Person("손흥민", 31));
		persons.add(new Person("이강인", 22));
		persons.add(new Person("김민재", 25));
		persons.add(new Person("소향", 10));
		persons.add(new Person("나얼", 40));
		persons.add(new Person("거미", 42));
		persons.add(new Person("거미", 10));
		
		System.out.println("총 객체 수 = " + persons.size());
		System.out.println();
		
		Iterator<Person> persons1 = persons.iterator();
		while(persons1.hasNext()) {
			Person person = persons1.next();
			System.out.println(person.name + ", " + person.age);
		}
		
	}

}

class Person implements Comparable<Person> {
	
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 1. 이름순으로 정렬
//	@Override public int compareTo(Person p) {
//		return this.name.compareTo(p.name);
//	}
		
		
	// 2. 나이순으로 정렬 - 나이가 같으면 동일하다고 인식 (마지막에 들어오는 애가 덮어쓰기함)
//	@Override public int compareTo(Person p) {
//		if(this.age < p.age) return -1;
//		else if(this.age == p.age) return 0;
//		else return 1;
//	}
	
//	@Override public int compareTo(Person p) {
//		return (this.age < p.age) ? -1 : ((this.age == p.age) ? 0 : 1);
//	}
	
//	@Override public int compareTo(Person p) {
//		return Integer.compare(this.age, p.age);
//	}
	
	// 3. 이름과 나이순으로 정렬
	@Override public int compareTo(Person p) {
		String x = this.name + this.age; // this.age + this.name 으로 하면 나이,이름순으로 정렬
		String y = p.name + p.age; 		 // p.age + p.name
		// return x.compareTo(y);
		return x.compareToIgnoreCase(y);
	}
}