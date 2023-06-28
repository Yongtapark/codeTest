package com.example.demo.web.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BoardModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int boardNo;
	private String title;
	private String content;
	private int hits;
	private String regName;
	private LocalDateTime regDttm; //String -> LocalDate로 변경
	
	public int getBoardNo() {
		return boardNo;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public int getHits() {
		return hits;
	}
	public String getRegName() {
		return regName;
	}
	public LocalDateTime getRegDttm() {
		return regDttm;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public void setRegDttm(LocalDateTime regDttm) {
		this.regDttm = regDttm;
	}

}
