package com.lec.service;

import java.util.List;

import com.lec.domain.Member;

public interface MemberService {

	Member getMember(Member member);
	List<Member> getMemberList(Member member);
	void insertMember(Member member);
	void updateMember(Member member);
	void deleteMember(Member member);


}