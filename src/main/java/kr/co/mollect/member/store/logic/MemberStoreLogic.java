package kr.co.mollect.member.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.mollect.member.domain.Member;
import kr.co.mollect.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore{

	@Override
	public int registerMember(SqlSession session, Member member) {
		int result = session.insert("MemberMapper.registerMember", member);
		return result;
	}

	@Override
	public Member checkMemberLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.checkMemberLogin", member);
		return mOne;
	}

	@Override
	public Member getMemberById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.getMemberById", memberId);
		return member;
	}

	@Override
	public int updateMember(SqlSession session, Member member) {
		int result = session.update("MemberMapper.updateMember", member);
		return result;
	}

	@Override
	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

}
