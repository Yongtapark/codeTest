package com.example.demo.web.board.dao.mybatis;

import com.example.demo.web.board.dto.BoardModelUpdateDto;
import com.example.demo.web.board.paging.SearchDto;
import com.example.demo.web.board.paging.BoardModelCond;
import com.example.demo.web.model.BoardModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardModelMapper {
    int save(BoardModel boardModel);
    void update(@Param("boardNo") int boardNo,@Param("updateParam") BoardModelUpdateDto boardModelUpdateDto);
    void addHits(int boardNo);

    List<BoardModel> findAll(BoardModelCond boardModelCond);

    List<BoardModel> findAll(SearchDto searchDto);

    int count(SearchDto searchDto);

    Optional<BoardModel> findById(int boardNo);

    void delete(int boardNo);

    void deleteAll();
}
