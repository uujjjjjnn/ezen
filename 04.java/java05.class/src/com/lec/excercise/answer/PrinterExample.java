package com.lec.excercise.answer;

public class PrinterExample {
	public static void main(String[] args) {
		Printer p = new Printer();

		int a = 123;
		boolean b = true;
		double c = 3.3;
		String d = "123";

//		p.println(a);
//		p.println(b);
//		p.println(c);
//		p.println(d);
//		
		// 메서드에 static
		Printer.println(a);
		Printer.println(b);
		Printer.println(c);
		Printer.println(d);
		

	}	
}
