package net.softsociety.exam.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.softsociety.exam.dao.BoardDAO;
import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;


@Transactional
@Service
public class BoardSeviceImpl implements BoardService {
	@Autowired
	BoardDAO dao;

	@Override
	public int insertBoard(Board b) {
		int n = dao.insertBoard(b);
		return n;
	}

	@Override
	public ArrayList<Board> selectAll() {
		ArrayList<Board> list = dao.selectAll();
		return list;
	}

	@Override
	public Board read(int boardnum) {
		Board b = dao.read(boardnum);
		return b;
	}

	@Override
	public int delete(Board b) {
		int n = dao.delete(b);
		return n;
	}

	@Override
	public ArrayList<Board> selectProduct(String category, String item) {
		HashMap<String, String> map = new HashMap<>();
		if(category.equals("all"))
			category = null;
		
		map.put("category", category);
		map.put("item", item);
		
		ArrayList<Board> list = dao.selectProduct(map);
		return list;
	}

	@Override
	public int buyProduct(Board b) {
		int n = dao.buyProduct(b);
		return n;
	}

	@Override
	public int insertReply(Reply r) {
		int n = dao.insertReply(r);
		return n;
	}

	@Override
	public ArrayList<Reply> getAllReply(int boardnum) {
		ArrayList<Reply> list = dao.getAllReply(boardnum);
		return list;
	}


}
