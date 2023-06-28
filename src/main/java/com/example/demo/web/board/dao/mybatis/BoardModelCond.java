package com.example.demo.web.board.dao.mybatis;

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
