package com.example.demo.web.board.dao.mybatis;

import lombok.Data;

@Data
public class BoardModelUpdateDto {
    private String title;
    private String text;

    public BoardModelUpdateDto() {
    }

    public BoardModelUpdateDto(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
