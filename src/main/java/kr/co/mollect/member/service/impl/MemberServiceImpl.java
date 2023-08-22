package kr.co.mollect.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mollect.member.domain.Member;
import kr.co.mollect.member.service.MemberService;
import kr.co.mollect.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberStore mStore;
	
	@Override
	public int registerMember(Member member) {
		int result = mStore.registerMember(session, member);
		return result;
	}

	@Override
	public Member checkMemberLogin(Member member) {
		Member mOne = mStore.checkMemberLogin(session, member);
		return mOne;
	}

	@Override
	public Member getMemberById(String memberId) {
		Member member = mStore.getMemberById(session, memberId);
		return member;
	}

	@Override
	public int updateMember(Member member) {
		int result = mStore.updateMember(session, member);
		return result;
	}

	@Override
	public int deleteMember(String memberId) {
		int result = mStore.deleteMember(session, memberId);
		return result;
	}

}
