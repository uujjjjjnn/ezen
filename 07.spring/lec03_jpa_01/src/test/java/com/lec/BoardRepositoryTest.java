package com.lec;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lec.domain.Board;
import com.lec.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

	@Autowired // new BoardRepository() 수동생성 대신에 자동생성 후 주입
	private BoardRepository boardRepo;
	
//	@Test
//	public void testInsertBoard() {
//		
//		Board board = new Board();
//		board.setTitle("첫 번째 게시글");
//		board.setWriter("테스터");
//		board.setContent("잘 동작이 될까");
//		board.setCreateDate(new Date());
//		board.setCnt(1L);
//		boardRepo.save(board); // insert into board ..
//
//	}
	
//	@Test
//	public void testGetBoard() {
//		Board board = boardRepo.findById(2L).get();
//		System.out.println(board);
//	}
	
//	@Test
//	public void testUpdateBoard() {
//		System.out.println("=== 2번 글 조회 ===");
//		Board board = boardRepo.findById(2L).get();
//
//		System.out.println("=== 2번 글 제목 수정 ===");
//		board.setTitle("제목을 수정했습니다");
//		boardRepo.save(board); // update
//		System.out.println(boardRepo.findById(2L).get());
//	}
	
//	@Test
//	public void testDeleteBoard() {
//		boardRepo.deleteById(2L);
//
//	}
	
//	@Test // 코드수정해야함
//	public void testGetBoardList() {
//		System.out.println("===> " + boardRepo.findAll().iterator().toString());
//		List<Board> boardList = new ArrayList<Board>();
//		for(long i=0; i<boardList.size(); i++) {
//			boardRepo.findById(i).get();
//			
//		}
//		
//	}
	
}
