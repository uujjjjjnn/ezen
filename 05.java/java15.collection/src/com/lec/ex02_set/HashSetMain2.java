package com.lec.ex02_set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetMain2 {

	public static void main(String[] args) {
		
		Set<Member> members = new HashSet<>();
		
		members.add(new Member("손흥민",31));
		members.add(new Member("손흥민",31));
		members.add(new Member("손흥민",20));
		members.add(new Member("이강인",23));
		System.out.println("총 객체 수 = " + members.size());
		
		for(Member member: members) {
			System.out.println(member.toString() + ", " + member.hashCode());
		}
		
		
	}

}


class Member {
	
	String name;
	int age;
	
	public Member(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	// hashCode와 equals - eclipse의 자동완성
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && Objects.equals(name, other.name);
		
		
	/*
	@Override
	public int hashCode() {
		// System.out.println(this.name.hashCode());
		// System.out.println(this.age);
		// name의 hashCode와 age가 같을 경우 동일한 hashCode를 리턴
		// return Objects.hash(name, age);
		return name.hashCode() + age;
	}

	@Override
	public boolean equals(Object obj) {
		// name과 age가 같을 경우 동일객체로 판단해서 true를 리턴
		// 아닐 경우 false가 되도록 equals()메서드를 재정의
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return (member.name.equals(this.name)) && (member.age == this.age);
		} 
		return false;
	}
	*/
	
	}
	
}