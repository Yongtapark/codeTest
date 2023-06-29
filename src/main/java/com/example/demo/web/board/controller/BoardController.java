package com.example.demo.web.board.controller;


import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.board.service.BoardService;
import com.example.demo.web.board.paging.PagingResponse;
import com.example.demo.web.board.paging.SearchDto;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;


	/**
	 * Index Page
	 * @return "redirect:/board/list"
	 */
	@GetMapping(value = "/")
	public String index() {
		return "redirect:/board/list";
	}

	/*조회*/

	/**
	 * 게시판 목록
	 * @param model ModelAndView
	 * @return ModelAndView
	 */
	@GetMapping(value = "/board/list")
	public ModelAndView boardList(ModelAndView model,
								  SearchDto searchDto,
								  @RequestParam(value = "title",required = false) String title,
								  @RequestParam(value = "content",required = false) String content) {
		PagingResponse<BoardModel> boards = boardService.findAllPaging(searchDto);
		model.setViewName("board/list");
		model.addObject("boards",boards.getList()); //게시물
		model.addObject("pagination",boards.getPagination()); //페
		model.addObject("searchDto",searchDto);
		return model;
	}
	
	/**
	 * 게시판 글 상세
	 * @param model ModelAndView
	 * @return ModelAndView
	 */
	@GetMapping(value = "/board/detail/{boardNo}")
	public ModelAndView boardDetail(ModelAndView model, BoardModel boardModel) {
		model.addObject("boardDetail", boardService.selectBoardDetail(boardModel));
		model.setViewName("/board/detail");
		return model;
	}

	/*수정*/

	/**
	 * 게시판 글 추가 (GET)
	 * @param model ModelAndView
	 * @return ModelAndView
	 */
	@GetMapping(value = "/board")
	public ModelAndView boardGetWrite(ModelAndView model) {
		model.setViewName("/board/add");
		return model;
	}

	/**
	 * 게시판 글 추가 (POST)
	 * @param boardModel BoardModel
	 * @return "redirect:/board/list"
	 */
	@PostMapping(value = "/board")
	public String boardPostWrite(@ModelAttribute("boardModel") BoardModel boardModel) {
		boardService.save(boardModel);
		return "redirect:/board/list";
	}

	@GetMapping(value = "/board/{boardNo}")
	public ModelAndView boardGetUpdate(ModelAndView model,BoardModel boardModel) {
		model.addObject("boardModel", boardService.selectBoardDetail(boardModel));
		model.setViewName("/board/update");
		return model;
	}

	@PostMapping(value = "/board/{boardNo}")
	public String boardPostUpdate(@PathVariable int boardNo, ModelAndView model,BoardModel boardModel) {
		boardService.update(boardNo,new BoardModelUpdateDto(boardModel.getTitle(),boardModel.getRegName(),boardModel.getContent()));
		return "redirect:/board/list";
	}

	/**
	 * 게시판 글 삭제
	 * @param boardNo int
	 * @return "redirect:/board/list"
	 */
	@GetMapping(value = "/board/delete/{boardNo}")
	public String boardDelete(@PathVariable int boardNo) {
		System.out.println("boardNos = " + boardNo);
		boardService.delete(boardNo);
		return "redirect:/board/list";
	}

	/**
	 * LocalDate 를 Date 로 변환하는 메서드
	 * @param localDateTime LocalDateTime
	 * @return Date
	 */
	public Date convertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
