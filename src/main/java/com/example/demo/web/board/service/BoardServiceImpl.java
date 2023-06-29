package com.example.demo.web.board.service;


import com.example.demo.web.board.dao.BoardDAO;
import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.board.paging.Pagination;
import com.example.demo.web.board.paging.PagingResponse;
import com.example.demo.web.board.paging.SearchDto;
import com.example.demo.web.board.paging.BoardModelCond;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
	public PagingResponse<BoardModel> findAllPaging(SearchDto searchDto) {
		// 조건에 해당하는 데이터가 없는 경우, 응답 데이터에 비어있는 리스트와 null을 담아 반환
		int count = boardDAO.count(searchDto);
		if (count < 1) {
			return new PagingResponse<>(Collections.emptyList(), null);
		}

		// Pagination 객체를 생성해서 페이지 정보 계산 후 SearchDto 타입의 객체인 params에 계산된 페이지 정보 저장
		Pagination pagination = new Pagination(count, searchDto);
		searchDto.setPagination(pagination);

		// 계산된 페이지 정보의 일부(limitStart, recordSize)를 기준으로 리스트 데이터 조회 후 응답 데이터 반환
		List<BoardModel> list = boardDAO.findAll(searchDto);
		return new PagingResponse<>(list, pagination);
	}


	@Override
	public void delete(int boardNo) {
		boardDAO.delete(boardNo);
	}

	@Override
	public List<BoardModel> getBoardList(int page, int perPageNum) {
		return null;
	}

}
