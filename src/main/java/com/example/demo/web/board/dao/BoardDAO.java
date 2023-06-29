package com.example.demo.web.board.dao;


import com.example.demo.web.board.utils.SearchDto;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.model.BoardModel;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BoardDAO {
	
	/**
	 * 게시글 상세 조회
	 * @param boardModel BoardModel
	 * @return BoardModel
	 */
	public BoardModel selectBoardDetail(BoardModel boardModel);

	/**
	 * 게시글 저장
	 * @param boardModel BoardModel
	 * @return BoardModel
	 */
	int save(BoardModel boardModel);

	/**
	 * 게시글 수정
	 * @param boardNo int
	 * @param boardModelUpdateDto BoardModelUpdateDto
	 */
	void update(int boardNo, BoardModelUpdateDto boardModelUpdateDto);

	/**
	 * 조회수 증가
	 * @param boardNo
	 */
	void addHits(int boardNo);

	/**
	 * 게시글 조회
	 * @param boardNo int
	 * @return Optional<BoardModel>
	 */
	Optional<BoardModel> findById(int boardNo);

	/**
	 * 게시글 전체 조회
	 * @param boardModelCond BoardModelCond
	 * @return List<BoardModel>
	 */
	List<BoardModel> findAll(BoardModelCond boardModelCond);
	List<BoardModel> findAll(SearchDto searchDto);

	int count(SearchDto searchDto);

	List<BoardModel> findAllPaging(Map<String, Integer> paramMap);


	/**
	 * 게시글 삭제
	 * @param boardNo int
	 */
	void delete(int boardNo);

	void deleteAll();



}
