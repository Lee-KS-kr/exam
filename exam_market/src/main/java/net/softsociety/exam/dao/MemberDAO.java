package net.softsociety.exam.dao;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Member;

/**
 * 회원정보 관련 매퍼
 */
@Mapper
public interface MemberDAO {

	int insertMember(Member mem);

	int duplicationCheck(String id);

	Member selectOne(String username);

	int updateMember(Member m);

}
