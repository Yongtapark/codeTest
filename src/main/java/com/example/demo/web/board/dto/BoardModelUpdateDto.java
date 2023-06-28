package com.example.demo.web.board.dto;

import lombok.Data;

@Data
public class BoardModelUpdateDto {
    private String title;
    private String content;

    public BoardModelUpdateDto() {
    }

    public BoardModelUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
