package com.lec.excercise.answer;

public class Excercise06 {

	public static void main(String[] args) {
//		 6. Exercise06.java : 
//			    for문을 이용해서 삼각형을 출력하는 코드를 작성
//			    1)
//			    *
//			    **
//			    ***
//			    ****
//			    *****
		for(int i=0; i<5;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			} 
			System.out.println();
		}	System.out.println("===========================");
		
//				
//				2)
//			    *****
//			    ****
//			    ***
//			    **
//			    *
		for(int i=0; i<5; i++) {
			for(int j=5; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}	System.out.println("===========================");
//			    
//			    3)
//			        *
//			       **
//			      ***
//			     ****
//			    *****
		for(int i=0; i<5; i++) {
			for(int j=4; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	System.out.println("===========================");
//			    
//			    4) 
//			    *****
//			     ****
//			      ***
//			       **
//			        *
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=4; j>=i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}	System.out.println("===========================");
		
//			    5)	
//			       *
//			      ***
//			     *****
//			    *******
		for(int i=0; i<4; i++) {
			for(int j=3; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i +1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}	System.out.println("===========================");
				
//			    6)
//			    *******
//			     *****
//			      ***
//			       *
		for(int i=0; i<4; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=8; j>2*i+1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}	System.out.println("===========================");
//			       
//			    7)
//			       *
//			      ***
//			     *****
//			    *******      
//			     *****
//			      ***
//			       *  
		for(int i=0; i<4; i++) {
			for(int j=3; j>i; j--) {
				System.out.print(" ");
			}
			for(int j=0; j<2*i +1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(" ");
			}
			for(int j=6; j>2*i+1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

}
