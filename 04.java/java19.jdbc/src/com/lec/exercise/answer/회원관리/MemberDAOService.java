package com.lec.exercise.answer.회원관리;

import java.util.ArrayList;
import java.util.List;

public interface MemberDAOService {

	void createMember();
	List<MemberVO> listMember();
	MemberVO viewMemer(String member_id);
	void updateMember(String member_id);
	void deleteMember(String member_id);
	
	ArrayList<MemberVO> findByNameMember(String member_name);
	ArrayList<MemberVO> findByEmailMember(String member_email);
}
