package com.lec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.lec.domain.Member;
import com.lec.service.MemberService;

@Controller
@SessionAttributes("member")
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginView() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member findMember = memberService.getMember(member);
		if(findMember != null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "member/getMemberInfo";
		} else {
			return "redirect:login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:login";
	}
	
	
	
}
