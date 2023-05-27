package com.lec.ex05_protected.pkg2;

import com.lec.ex05_protected.pkg1.*;

public class D extends A {
	
	public D() {
		
		// A a = new A(); // 직접접근은 불가능
		super(); // 부모객체를 생성한 후 
		this.field1 = "부모객체 생성한 후에 접근가능";
		// this.field2 = "접근불가";
		method_a(); // 접근가능
	}

}
