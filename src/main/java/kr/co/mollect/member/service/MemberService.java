package kr.co.mollect.member.service;

import kr.co.mollect.member.domain.Member;

public interface MemberService {

	public int registerMember(Member member);

	public Member checkMemberLogin(Member member);

	public Member getMemberById(String memberId);

	public int updateMember(Member member);

	public int deleteMember(String memberId);

}
