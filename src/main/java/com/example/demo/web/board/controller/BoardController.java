package com.example.demo.web.board.controller;


import com.example.demo.web.board.service.BoardService;
import com.example.demo.web.board.utils.BoardModelCond;
import com.example.demo.web.board.utils.PagingResponse;
import com.example.demo.web.board.utils.SearchDto;
import com.example.demo.web.model.BoardModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
		//List<BoardModel> boards = boardService.findAll(new BoardModelCond(title, content));
		PagingResponse<BoardModel> boards = boardService.findAllPaging(searchDto);
		model.setViewName("board/list");
		model.addObject("boards",boards.getList());
		model.addObject("pagination",boards.getPagination());
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

	@GetMapping(value = "/board")
	public ModelAndView boardGetWrite(ModelAndView model, @ModelAttribute BoardModel boardModel) {
		model.setViewName("/board/detail");
		return model;
	}

	@PostMapping(value = "/board")
	public ModelAndView boardPostWrite(ModelAndView model, @ModelAttribute BoardModel boardModel) {
		model.addObject(boardService.save(boardModel));
		model.setViewName("/board/detail");
		return model;
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
	
}
