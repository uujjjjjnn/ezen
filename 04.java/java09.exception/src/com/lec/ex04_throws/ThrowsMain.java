package com.lec.ex04_throws;
/*
 	예외를 떠넘기기(throws)
 	
 	메서드 내부에서 예외가 발생할 경우 코딩을 할 때 try~catch로 예외처리를 하는 것이 기본이지만 겨웅에 따라서는 메서드를 호출할 곳으로 예외를 떠넘길 수가 있다.
 	이때 사용하는 명령이 "throws"이다. throws명령은 메서드 선언부에 작성되어 메서드에서 처리하지않고 메서드를 호출하는 곳으로 예외를 떠넘기는 역할을 한다.
 	
 	throws 명령은 떠넘길 예외클래스를 콤마(,)로 구분해서 나열해 주면 된다.
 	throws 키워드가 붙어있는 메서드는 반드시 try~catch블럭내에서 떠넘겨 받은 예외처리를 해야한다.
 	
 	
 */
public class ThrowsMain {

	public static void main(String[] args) throws Exception {
		
		// Class _class = Class.forName("java.lang.Stringxxx");
		// String data = args[0];
		// int val1 = Integer.parseInt("111a");
		
		method();
		

	}

	private static void method() throws ClassNotFoundException {
		Class _class = Class.forName("java.lang.Stringxxx");
	}
	
	void method1() {
		try {
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
