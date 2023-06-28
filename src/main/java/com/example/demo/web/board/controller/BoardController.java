/*
package com.example.demo.web.board.controller;


import com.example.demo.web.board.service.BoardService;
import com.example.demo.web.model.BoardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	*/
/**
	 * Index Page
	 * @param model ModelAndView
	 * @return ModelAndView
	 *//*

	@GetMapping(value = "/")
	public String index(ModelAndView model) {
		return "redirect:/board/list";
	}
	
	*/
/**
	 * 게시판 목록
	 * @param model ModelAndView
	 * @return ModelAndView
	 *//*

	@GetMapping(value = "/board/list")
	public ModelAndView boardList(ModelAndView model, BoardModel boardModel) {
		model.setViewName("/board/list");
		return model;
	}
	
	*/
/**
	 * 게시판 글 상세
	 * @param model ModelAndView
	 * @return ModelAndView
	 *//*

	@GetMapping(value = "/board/detail/{boardNo}")
	public ModelAndView boardWrite(ModelAndView model, BoardModel boardModel) {
		model.addObject("boardDetail", boardService.selectBoardDetail(boardModel));
		model.setViewName("/board/detail");
		return model;
	}
	
}
*/
