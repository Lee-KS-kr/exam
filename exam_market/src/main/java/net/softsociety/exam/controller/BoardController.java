package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;
import net.softsociety.exam.service.BoardService;

/**
 * 상품게시판 관련 콘트롤러
 */
@Slf4j
@RequestMapping("board")
@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("list")
	public String list() {
		return "boardView/boardlist";
	}
	
	@GetMapping("write")
	public String wirte() {
		return "boardView/boardinsert";
	}
	
	@PostMapping("boardinsert")
	public String boardinsert(Board b, @AuthenticationPrincipal UserDetails user) {
		b.setMemberid(user.getUsername());
		log.debug("쓴 글 내용 {}", b);
		service.insertBoard(b);
		return "redirect:/board/list";
	}
	
	@GetMapping("read")
	public String read(Model m, int boardnum) {
		Board b = service.read(boardnum);
		log.debug("읽을 글 : {}", b);
		m.addAttribute("board", b);
		
		return "boardView/boardread";
	}
	
	@GetMapping("search")
	public String search(Model m) {
		ArrayList<Board> list = service.selectAll();
		m.addAttribute("board", list);
		
		return "boardView/boardsearch";
	}
	
	@GetMapping("delete")
	public String delete(@AuthenticationPrincipal UserDetails user, int boardnum) {
		Board b = new Board();
		b.setBoardnum(boardnum);
		b.setMemberid(user.getUsername());
		service.delete(b);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("buy")
	public String buyBoard(@AuthenticationPrincipal UserDetails user, int boardnum) {
		Board b = new Board();
		b.setBoardnum(boardnum);
		b.setMemberid(user.getUsername());
		service.buyProduct(b);
		
		return "redirect:/board/list";
	}
}
