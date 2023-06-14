package com.lec.ex17_access.construcor.pkg2;

import com.lec.ex17_access.construcor.pkg1.A;

public class C {
	
	A a1 = new A(false); 	// public (import해야만 사용가능)
	// A a2 = new A(1.0); 	// protected (X)
	// A a3 = new A(1); 	// default (X)
	// A a4 = new A("1"); 	// private (X)

}
