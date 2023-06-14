package com.lec.ex13_static;

public class Korean {

	static String nation = "대한민국"; 
	String name;
	String ssn;
	
	public Korean(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return this.nation + " Korean [name=" + name + ", ssn=" + ssn + "]";
	}
	
}
