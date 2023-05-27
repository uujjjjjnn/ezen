package com.lec.excercise.answer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileMergeTest {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream(args[0]);
		
		for(int i=0; i<args.length; i++) {
			fis = new FileInputStream(args[i]);
		}
		

	}

}
