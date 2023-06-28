package com.example.demo.web.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
@Setter
@Getter
@Data
public class BoardModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int boardNo;
	private String title;
	private String content;
	private int hits;
	private String regName;
	private LocalDateTime regDttm; //String -> LocalDate로 변경

	public BoardModel(String title, String content, String regName) {
		this.title = title;
		this.content = content;
		this.hits = 0;
		this.regName = regName;
	}

	public BoardModel() {
	}
}
