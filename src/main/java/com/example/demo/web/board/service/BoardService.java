package com.example.demo.web.board.service;


import com.example.demo.web.model.BoardModel;

public interface BoardService {
	
	/**
	 * 게시글 상세 조회
	 * @param boardModel BoardModel
	 * @return BoardModel
	 */
	public BoardModel selectBoardDetail(BoardModel boardModel);

}
