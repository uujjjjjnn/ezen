package com.lec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.domain.Member;
import com.lec.persistence.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepository.findById(member.getId());
		if(findMember.isPresent()) 
			return findMember.get();
		else return null;
	}

	@Override
	public List<Member> getMemberList(Member member) {
		return (List<Member>) memberRepository.findAll();
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
