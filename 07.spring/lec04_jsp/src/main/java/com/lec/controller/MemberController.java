package com.lec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;
import com.lec.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/getMemberList")
	public String getMemberList(Model model, Member member) {
		List<Member> members = memberService.getMemberList(member);
		model.addAttribute("members", members);
		
		return "getMemberList";
	}
	
	@GetMapping("/insertMember") // getMemberList에서 회원등록으로 가는 a태그는 get방식
	public String insertMember() {
		return "insertMember";
	}
	
	@PostMapping("/insertMember") // insertMember에서 회원등록하는 form태그
	public String insertMember(Member member) {
		memberService.insertMember(member);
		return "redirect:getMemberList";
	}
	
	@GetMapping("/getMember")
	public String getMember(Model model, Member member) {
		model.addAttribute("member", memberService.getMember(member));
		return "getMember";
	}
	
	@PostMapping("/updateMember") 
	public String updateMember(Member member) {
		memberService.updateMember(member);
		return "forward:getMemberList";
	}
	
	@GetMapping("/deleteMember") 
	public String deleteMember(Member member) {
		memberService.deleteMember(member);
		return "forward:getMemberList";
	}
	
	
}
