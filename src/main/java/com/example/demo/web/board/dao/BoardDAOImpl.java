package com.example.demo.web.board.dao;


import com.example.demo.web.board.exception.NotBoardFoundException;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.board.dao.mybatis.BoardModelMapper;
import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

	private final BoardModelMapper boardModelMapper;
	@Override
	public BoardModel selectBoardDetail(BoardModel boardModel) {
		return findById(boardModel.getBoardNo()).orElseThrow(NotBoardFoundException::new);
	}

	@Override
	public int save(BoardModel boardModel) {
		return boardModelMapper.save(boardModel);
	}

	@Override
	public void update(int boardNo, BoardModelUpdateDto boardModelUpdateDto) {
		boardModelMapper.update(boardNo,boardModelUpdateDto);
	}

	@Override
	public Optional<BoardModel> findById(int boardNo) {
		return boardModelMapper.findById(boardNo);
	}

	@Override
	public List<BoardModel> findAll(BoardModelCond boardModelCond) {
		return boardModelMapper.findAll(boardModelCond);
	}

	@Override
	public void delete(int boardNo) {
		boardModelMapper.delete(boardNo);
	}

}
