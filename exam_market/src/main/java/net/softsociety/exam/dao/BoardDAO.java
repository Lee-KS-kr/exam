package net.softsociety.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.exam.domain.Board;
import net.softsociety.exam.domain.Reply;

/**
 * 게시판 관련 매퍼
 */
@Mapper
public interface BoardDAO {

	int insertBoard(Board b);

	ArrayList<Board> selectAll();

	Board read(int boardnum);

	int delete(Board b);

	ArrayList<Board> selectProduct(HashMap<String, String> map);

	int buyProduct(Board b);

	int insertReply(Reply r);

	ArrayList<Reply> getAllReply(int boardnum);

}
