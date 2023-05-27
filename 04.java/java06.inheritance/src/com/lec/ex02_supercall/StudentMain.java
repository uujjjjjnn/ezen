package com.lec.ex02_supercall;

public class StudentMain {

	public static void main(String[] args) {

		Student student = new Student("홍길동", "991118-1234567", 1000);
		System.out.println(student);
		
		Student student2 = new Student();
		student2.studentNo = 2000;
		student2.name = "손흥민";
		student2.ssn = "951212-1234567";
		System.out.println(student2);
	}

}
