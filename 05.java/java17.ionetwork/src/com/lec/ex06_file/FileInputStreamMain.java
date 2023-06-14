package com.lec.ex06_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 	
 	FileInputStream
 	
 	이 클래스는 파일로부터 바이트단위로 읽어 올 때 사용하는 바이트기반 입력스트림이다.
 	바이트단위로 읽기 때문에 그림, 오디오, 비디오, 텍스트파일 등 모든 종류의 파일을 읽을 수가 있다.
 	
 	FileInputStream을 생성하는 방법은 2가지가 있다.
 	
 	1. 문자열로 된 파일의 경로를 가지고 FileInputStream을 생성
 	
 		FileInputStream fis = new FileInputStream("c:/temp/image.jpg");
 		
 	2. File객체로 이미 생성되어 있는 경우
 	
 		File file = new File("c:/temp/image.img");
 		FileInputStream fis = new File(file);
 	
 */
public class FileInputStreamMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("src/com/lec/ex06_file/FileMain.java");
		int data;
		while((data = fis.read()) != -1) {
			System.out.println((char) data);
		}
		fis.close();
	}

}
