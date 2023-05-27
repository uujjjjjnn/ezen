package com.lec.excercise.answer;

public class Excercise07 {

	public static void main(String[] args) {
		/*
		주어진 배열의 항목에서 최대값을 구하기.(for문을 이용)
		int[] array={1,5,3,8,2};
		*/
		
		int[] array = {1,5,3,8,2};
		int num = 0;
		// System.out.println(array[array.length-1]);
		
		for(int i=0; i<array.length; i++) {
			if(array[i] > num) {
				num = array[i];
			} 
		}
		System.out.println(num);
		
	}

}
