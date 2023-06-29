package com.example.demo.web.board.controller;


import com.example.demo.web.board.service.BoardService;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.board.utils.PagingResponse;
import com.example.demo.web.board.utils.SearchDto;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;


	/**
	 * Index Page
	 * @param model ModelAndView
	 * @return ModelAndView
	 */
	@GetMapping(value = "/")
	public String index(ModelAndView model) {
		return "redirect:/board/list";
	}
	
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
		//List<BoardModel> boards = boardService.findAll(new BoardModelCond(title, content));
		PagingResponse<BoardModel> boards = boardService.findAllPaging(searchDto);
		model.setViewName("board/list");
		model.addObject("boards",boards.getList());
		model.addObject("pagination",boards.getPagination());
		return model;
	}
	
	/**
	 * 게시판 글 상세
	 * @param model ModelAndView
	 * @return ModelAndView
	 */
	@GetMapping(value = "/board/detail/{boardNo}")
	public ModelAndView boardWrite(ModelAndView model, BoardModel boardModel) {
		model.addObject("boardDetail", boardService.selectBoardDetail(boardModel));
		model.setViewName("/board/detail");
		return model;
	}
	
}
