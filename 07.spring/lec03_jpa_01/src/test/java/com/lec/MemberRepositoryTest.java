package com.lec;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository MemberRepo;
	
//	@Test
//	public void testInsertMember() {
//		
//		Member member = new Member();
//		member.setMember_id("id");
//		member.setName("이름");
//		member.setPassword("1234");
//		member.setRole("role");
//		MemberRepo.save(member);
//
//	}
	
//	@Test
//	public void testGetMember() {
//		Member member = MemberRepo.findById("id 0").get();
//		System.out.println("===> " + member);
//	}
	
//	@Test
//	public void testUpdateMember() {
//		System.out.println("=== id 0 회원 조회 ===");
//		Member member = MemberRepo.findById("id 0").get();
//		
//		System.out.println("=== id 0 회원 이름 수정 ===");
//		member.setName("수정 후 이름");
//		MemberRepo.save(member);
//		System.out.println(MemberRepo.findById("id 0").get());
//		
//	}
	
//	@Test
//	public void testDeleteMember() {
//		MemberRepo.deleteById("id 0");
//	}
	
	
//	@Test // 코드수정해야함
//	public void testGetMemberList() {
//		System.out.println("===> " + MemberRepo.findAll().iterator().toString());
//		Iterator<Member> memberList = MemberRepo.findAll().iterator();
//		while(memberList.hasNext()) {
//			System.out.println("---> " + memberList.toString());
//		}
//	}
	
}
