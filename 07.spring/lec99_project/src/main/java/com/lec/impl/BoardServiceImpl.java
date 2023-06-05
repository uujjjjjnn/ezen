package com.lec.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lec.domain.Board;
import com.lec.persistence.BoardRepository;
import com.lec.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Override
	public long getTotalRowCount(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board getBoard(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Board> getBoardList(Pageable pageable, String searchType, String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateReadCount(Board board) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
