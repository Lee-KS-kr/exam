package net.softsociety.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

@Controller
@RequestMapping("board")
@ResponseBody
@Slf4j
public class BoardAjaxController {
	@Autowired
	BoardService service;
	
	@GetMapping("boardlist")
	public ArrayList<Board> boardlist(){
		ArrayList<Board> list = service.selectAll();
		log.debug("게시글 정보 : {}", list);
		
		return list;
	}
	
	@PostMapping("search")
	public ArrayList<Board> search(String category, String item){
		ArrayList<Board> list = service.selectProduct(category, item);
		log.debug("{}", list);
		return list;
	}
	
	@GetMapping("replylist")
	public ArrayList<Reply> replylist(int boardnum){
		ArrayList<Reply> list = service.getAllReply(boardnum);
		return list;
	}
	
	@PostMapping("insertReply")
	public void writeReply(@AuthenticationPrincipal UserDetails user, Reply r) {
		r.setMemberid(user.getUsername());
		service.insertReply(r);
	}
	
	@PostMapping("deleteReply")
	public int deleteReply(@AuthenticationPrincipal UserDetails user, Reply r) {
		r.setMemberid(user.getUsername());
		int n = service.deleteReply(r);
		return n;
	}
}
