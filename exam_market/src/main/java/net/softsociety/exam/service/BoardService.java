package net.softsociety.exam.service;

import java.util.ArrayList;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

public interface BoardService {

	int insertBoard(Board b);

	ArrayList<Board> selectAll();

	Board read(int boardnum);


}
