package com.lec.excercise.answer;

import java.io.FileInputStream;
import java.io.PrintStream;

public class HexaViewer {

	public static void main(String[] args) throws Exception {
		
		if(args.length != 1) {
			System.out.println("USAGE : java HexaViewer FILENAME");
			System.exit(0);
		}
		
		
		String inputFile = args[0];
		
		FileInputStream fis = new FileInputStream(inputFile);
		PrintStream ps = new PrintStream(System.out);
		
		int data = 0;
		int i = 0;
		
		while((data = fis.read()) != -1) {
			ps.printf("%02X ", data);
			if(++i%16==0)
				ps.println();
		}
		
		fis.close();
		ps.close();
		

	}

}
