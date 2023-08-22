package kr.co.mollect.member.store;

import org.apache.ibatis.session.SqlSession;

import kr.co.mollect.member.domain.Member;

public interface MemberStore {

	public int registerMember(SqlSession session, Member member);

	public Member checkMemberLogin(SqlSession session, Member member);

	public Member getMemberById(SqlSession session, String memberId);

	public int updateMember(SqlSession session, Member member);

	public int deleteMember(SqlSession session, String memberId);

}
