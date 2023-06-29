package com.example.demo.web.board.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {
    private int page;
    private int pageSize;
    private int pageButtonSize;
    private String search;
    private Pagination pagination;

    public SearchDto() {
        this.page=0;
        this.pageSize = 10;
        this.pageButtonSize =10;
    }
}


