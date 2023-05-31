package com.lec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public List<Member> getMemberList(Member member) {
		return (List<Member>) memberRepository.findAll();
	}

	@Override
	public Member getMember(Member member) {
		return memberRepository.findById(member.getId()).get();
	}

	@Override
	public void insertMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public void updateMember(Member member) {
		Member findMember = memberRepository.findById(member.getId()).get();
		findMember.setPassword(member.getPassword());
		findMember.setName(member.getName());
		findMember.setRole(member.getRole());
		memberRepository.save(findMember);
	}

	@Override
	public void deleteMember(Member member) {
		memberRepository.deleteById(member.getId());
	}

}
