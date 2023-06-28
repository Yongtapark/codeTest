package com.example.demo.web.board.service;


import com.example.demo.web.board.dao.BoardDAO;
import com.example.demo.web.model.BoardModel;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDAO;

	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public BoardModel selectBoardDetail(BoardModel boardModel) {
		return boardDAO.selectBoardDetail(boardModel);
	}
	
}
