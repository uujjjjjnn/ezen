package com.lec.board;

import java.util.ArrayList;

public class BoardMain1 {

	public static void main(String[] args) {
		
		BoardList1 bl = new BoardList1();
		ArrayList<Board1> boards = bl.getBoardList1();
		
		for(Board1 board : boards) {
			System.out.println(board.toString());
		}

	}

}
