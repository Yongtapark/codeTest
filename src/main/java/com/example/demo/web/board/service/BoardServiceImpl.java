package com.example.demo.web.board.service;


import com.example.demo.web.board.dao.BoardDAO;
import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDAO;


	@Override
	public BoardModel selectBoardDetail(BoardModel boardModel) {
		addHits(boardModel.getBoardNo());
		BoardModel findBoard = boardDAO.selectBoardDetail(boardModel);
		return findBoard;
	}

	@Override
	public int save(BoardModel boardModel) {
		return boardDAO.save(boardModel);
	}

	@Override
	public void update(int boardNo, BoardModelUpdateDto boardModelUpdateDto) {
		boardDAO.update(boardNo,boardModelUpdateDto);
	}

	@Override
	public Optional<BoardModel> findById(int boardNo) {
		return boardDAO.findById(boardNo);
	}

	@Override
	public void addHits(int boardNo) {
		boardDAO.addHits(boardNo);
	}

	@Override
	public List<BoardModel> findAll(BoardModelCond boardModelCond) {
		return boardDAO.findAll(boardModelCond);
	}

	@Override
	public void delete(int boardNo) {
		boardDAO.delete(boardNo);
	}

}
