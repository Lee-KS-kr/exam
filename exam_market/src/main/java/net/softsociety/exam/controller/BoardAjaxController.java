package net.softsociety.exam.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardAjaxController {
	@Autowired
	BoardService service;
	
	@GetMapping("boardlist")
	public ArrayList<Board> boardlist(){
		ArrayList<Board> list = service.selectAll();
		return list;
	}
}
