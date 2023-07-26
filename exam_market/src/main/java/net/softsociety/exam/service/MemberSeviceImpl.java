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

   

}
