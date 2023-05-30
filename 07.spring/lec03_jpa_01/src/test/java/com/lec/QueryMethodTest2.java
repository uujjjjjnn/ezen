package com.lec;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest2 {

	@Autowired
	private MemberRepository memberRepository;
	
//	@BeforeEach
//	public void dataPrepare() {
//		for(int i=1; i<=200; i++) {
//			Member member = new Member();
//			member.setMember_id("id " + i);
//			member.setName("이름");
//			member.setPassword("12345");
//			member.setRole("role " + i);
//			memberRepository.save(member);
//		}
//	}
//	
//	@Test
//	public void testFindByRole() {
//		List<Member> memberList = memberRepository.findByRole("role 10");
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//
//	}
	
//	@Test
//	public void testFindByRoleContaining() {
//		List<Member> memberList = memberRepository.findByRoleContaining("18");
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//	}
	
//	@Test
//	public void testFindByNameContainingOrRoleContaining() {
//		List<Member> memberList = memberRepository.findByNameContainingOrRoleContaining("123", "18");
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//	}
	
//	@Test // member_id가 에러발생함 수정해야함
//	public void testFindByRoleContainingOrderByMember_idDesc() {
//		List<Member> memberList = memberRepository.findByRoleContainingOrderByMember_idDesc("18");
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//	}
	
//	@Test
//	public void testFindByRoleContaining() {
//		
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "member_id");
//		
//		List<Member> memberList = memberRepository.findByRoleContaining("18", paging);
//		
//		System.out.println("===> 검색결과");
//		for(Member member:memberList) {
//			System.out.println("---> " + member.toString());
//		}
//	}
	
	@Test
	public void testFindByRoleContaining() {
		
		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "member_id");
		Page<Member> pageInfo = memberRepository.findByRoleContaining("18", paging);
		
		System.out.println("페이지사이즈 = " + pageInfo.getSize());
		System.out.println("총페이지 수  = " + pageInfo.getTotalPages());
		System.out.println("총레코드 수  = " + pageInfo.getTotalElements());
		System.out.println("다음페이지   = " + pageInfo.nextPageable());
		
		List<Member> memberList = pageInfo.getContent();
		
		System.out.println("===> 검색결과");
		for(Member member:memberList) {
			System.out.println("---> " + member.toString());
		}
	}
	
}
