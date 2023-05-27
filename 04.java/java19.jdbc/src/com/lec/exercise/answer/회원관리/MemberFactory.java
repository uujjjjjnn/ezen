package com.lec.exercise.answer.회원관리;

public class MemberFactory {

	private MemberFactory() {}
	private static MemberDAOImpl mdao = null;
	public static MemberDAOImpl getInstance() {
		if(mdao == null) mdao = new MemberDAOImpl();
		return mdao;
	}
}
