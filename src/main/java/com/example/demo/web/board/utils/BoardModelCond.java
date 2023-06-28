package com.example.demo.web.board.utils;

import lombok.Data;

@Data
public class BoardModelCond {

    private String searchQuery;

    public BoardModelCond() {
    }

    public BoardModelCond(String searchQuery) {
        this.searchQuery = searchQuery;
    }
}
