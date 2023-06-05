package com.lec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.domain.Member;
import com.lec.domain.PagingInfo;
import com.lec.service.MemberService;

@Controller
@SessionAttributes("pagingInfo")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	public PagingInfo pagingInfo = new PagingInfo();

	@GetMapping("insertMember")
	public String insertMemberForm(Member member) {
		return "member/insertMember";
	}
	
	@PostMapping("/insertMember")
	public String insertMember(Member member) {
		
		memberService.insertMember(member);
		return "";
	}
	
	
//	@GetMapping("getMemberList")
	
	
//	@GetMapping("getMember")
//	@GetMapping("updateMember")
//	@GetMapping("deleteMember")

}
