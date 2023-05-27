package com.lec.excercise.answer;

public class Excercise08 {

	public static void main(String[] args) {
		/*
		주어진 배열의 전체 항목의 합과 평균값을 구하기.(중첩 for문을 이용) 
		   
		   int[][] array ={
							{95, 86},
							{83, 92, 96},
							{78, 83, 93, 87, 88}
						  };
		*/
		int sum = 0;
		int count = 0;
		int[][] array ={
				{95, 86},
				{83, 92, 96},
				{78, 83, 93, 87, 88}
			  };
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				sum += array[i][j];
				count++;
			}
		}
		System.out.println("전체 항목의 합 = " + sum);
		System.out.println("전체 항목의 평균 = " + (sum/(float)count));
	
	}

}
