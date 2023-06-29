package com.example.demo.web.board.utils;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class BoardModelCond {

    private String title;
    private String content;

    public BoardModelCond() {
    }

    public BoardModelCond(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
