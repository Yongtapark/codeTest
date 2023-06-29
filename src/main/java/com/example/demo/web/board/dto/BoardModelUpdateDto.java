package com.example.demo.web.board.dto;

import lombok.Data;

@Data
public class BoardModelUpdateDto {
    private String title;
    private String regName;
    private String content;

    public BoardModelUpdateDto() {
    }

    public BoardModelUpdateDto(String title, String regName, String content) {
        this.title = title;
        this.regName = regName;
        this.content = content;
    }
}
