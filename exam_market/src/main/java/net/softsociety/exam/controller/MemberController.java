package net.softsociety.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Member;
import net.softsociety.exam.service.MemberService;

/**
 * 회원 정보 관련 콘트롤러
 */

@Slf4j
@RequestMapping("member")
@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@GetMapping("join")
	public String join() {
		return "joinForm";
	}
	
	@GetMapping("login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("join")
	public String join(Member mem) {
		service.insertMember(mem);
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public String mypage(@AuthenticationPrincipal UserDetails user, Model m) {
		Member mem = service.selectOne(user.getUsername());
		m.addAttribute("member", mem);
		
		return "mypage";
	}
	
	@GetMapping("update")
	public String update(@AuthenticationPrincipal UserDetails user, Model m) {
		Member mem = service.selectOne(user.getUsername());
		m.addAttribute("member", mem);
		
		return "update";
	}
	
	@PostMapping("update")
	public String editProfile(@AuthenticationPrincipal UserDetails user, Member m) {
		m.setMemberid(user.getUsername());
		log.debug("변경할 내용 : {}", m);
		service.updateMember(m);
		
		return "redirect:/member/mypage";
	}
	
	@ResponseBody
	@PostMapping("idCheck")
	public int duplicationCheck(String id) {
		return service.duplicationCheck(id);
	}

}
