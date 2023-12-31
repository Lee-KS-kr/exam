package net.softsociety.exam.service;

import net.softsociety.exam.domain.Member;

/** 
 * 회원정보 관련 서비스
 */
public interface MemberService {

	int insertMember(Member mem);

	int duplicationCheck(String id);

	Member selectOne(String username);

	int updateMember(Member m);

}
