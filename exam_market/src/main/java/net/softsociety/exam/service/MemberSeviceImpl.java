package net.softsociety.exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.softsociety.exam.dao.MemberDAO;
import net.softsociety.exam.domain.Member;

@Service
public class MemberSeviceImpl implements MemberService {
	@Autowired
	MemberDAO dao;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public int insertMember(Member mem) {
		String pw = encoder.encode(mem.getMemberpw());
		mem.setMemberpw(pw);
		
		int n = dao.insertMember(mem);
		return n;
	}

	@Override
	public int duplicationCheck(String id) {
		int n = dao.duplicationCheck(id);
		return n;
	}

	@Override
	public Member selectOne(String username) {
		Member m = dao.selectOne(username);
		return m;
	}

	@Override
	public int updateMember(Member m) {
		int n = dao.updateMember(m);
		return n;
	}

   

}
