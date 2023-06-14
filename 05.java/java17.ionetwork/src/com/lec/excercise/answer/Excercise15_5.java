package com.lec.excercise.answer;

import java.io.*;

public class Excercise15_5 {

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("USAGE : java Excercise15_5 TAGET_FILERESULT_FILE");
			System.exit(0);
		}
		
		
		String inputFile = args[0];
		String outputFile = args[1];
		
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile));
			int ch = 0;
			
			while((ch=input.read()) != -1) {
				output.write(ch);
			}
			
			input.close();
			output.close();
			
			} catch (Exception e) {
		}
	}
}
	class HtmlTagFilterWriter extends FilterWriter {
		StringWriter tmp = new StringWriter();
		boolean inTag = false;
		
		HtmlTagFilterWriter(Writer out) {
			super(out);
		}
		
		public void write(int c) throws Exception {
			
			/*
			 	1. 출력할 문자(c)가 '<'이면 inTag의 값을 true
			 	2. 출력할 문자(c)가 '>'이면 inTag의 값을 false
			 		새로운 StringWriter를 생성한다. (기존 stringWriter 내용 버림)
			 	3. inTag의 값이 true라면, StringWriter에 문자(c) 출력하고
			 		inTag의 값이 false라면, out에 문자 (c) 출력
			 		
			 	*참고. 태그가 시작되면 StringWriter에 출력하고 태그가 끝나면 StringWriter는 비워짐
			 */
			
			FileOutputStream fos = new FileOutputStream(c);
			
			
			if()
			
			
			
			
		}
		
		public void close() throws Exception {
			out.write(tmp.toString()); // StringWriter의 내용 출력
			super.close(); 				// 조상의 close() 호출해서 기반 스트림 닫기
		}
	
	}
