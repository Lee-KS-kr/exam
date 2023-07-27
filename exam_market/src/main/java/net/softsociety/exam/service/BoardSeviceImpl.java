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


}
