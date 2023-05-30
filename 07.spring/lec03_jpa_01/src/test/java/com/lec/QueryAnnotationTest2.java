package com.lec;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest2 {
	
	@Autowired
	private MemberRepository memberRepository;

//	@Test
//	public void testQueryAnnotationTest11() {
//		List<Member> memberList = memberRepository.queryAnnotation11("role 19");
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//	}

//	@Test
//	public void testQueryAnnotationTest22() {
//		List<Object[]> memberList = memberRepository.queryAnnotation22("role 19");
//		
//		System.out.println("===> 검색결과");
//		for(Object[] row:memberList) {
//			System.out.println("---> " + Arrays.toString(row));
//		}
//	}
	
//	@Test
//	public void testQueryAnnotationTest33() {
//		List<Object[]> memberList = memberRepository.queryAnnotation33("role 19");
//		
//		System.out.println("===> 검색결과");
//		for(Object[] row:memberList) {
//			System.out.println("---> " + Arrays.toString(row));
//		}
//	}
	
	@Test
	public void testQueryAnnotationTest44() {
		Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "member_id");
		List<Member> memberList = memberRepository.queryAnnotation44(paging);
		
		System.out.println("===> 검색결과");
		for(Member member:memberList) {
			System.out.println("---> " + member.toString());
		}
	}
}
