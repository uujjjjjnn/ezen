package com.lec.ex17_access.field.pkg2;

import com.lec.ex17_access.field.pkg1.A;

public class C {
	
	public C() {
		
		A a = new A();
		a.field1 = 20; 		// public
		// a.field2 = 20; 	// default (X)
		 // a.field3 = 20; 	// private (X)
		
		a.method1(); 		// public
		// a.method2(); 	// default (X)
		// a.method3(); 	// private (X)
	}
	
	
}
